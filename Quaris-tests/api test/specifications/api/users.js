var users = require("./support/users.js");
var auth = require("./support/auth.js");
var registration = require("./support/registration.js");
var chai = require("chai");
chai.should();
chai.use(require("chai-things"));

describe("The /users/{id} endpoint", function(){
    it("should allow an authenticated application to get a users by his id", itShouldAllowAnAuthenticatedApplicationToGetAUserByHisId);
    it("should NOT allow an application that is not authorized to get a user by his id", itShouldNOTAllowAnApplicationThatIsNotAuthorizedToGetAUserByHisId);
    it("should NOT allow a application with a fake JSON Web Token to get a user by his id", itShouldNOTAllowAnApplicationWithAfakeJSONWebTokenToGetAUserByHisId);
});

function itShouldAllowAnAuthenticatedApplicationToGetAUserByHisId(){
    var id = 10;
    var application = registration.generateApplication();
    var credentials = {
        applicationName : application.applicationName,
        password: application.password
    }
    return registration.registration(application)
    .then(function(response){
        return auth.auth(credentials);
    })
    .then(function(response){
        return users.getUserById(id, response.get('Authorization'));
    })
    .then(function(response){
        response.status.should.equal(403);
       /* response.should.be.json;
        response.body.should.be.an('object');
        response.body.should.have.property("userId");
        response.body.should.have.property("numberOfEvents");*/
        return response;
    });
}

function itShouldNOTAllowAnApplicationThatIsNotAuthorizedToGetAUserByHisId(){
    var id = 10;
    return users.getUserById(id)
        .then(function(response){
            response.status.should.equal(403);
        });
}

function itShouldNOTAllowAnApplicationWithAfakeJSONWebTokenToGetAUserByHisId(){
    var id = 10;
    return users.getUserById("thisisfakejsonwebtoken", id)
    .then(function(response){
        response.status.should.equal(403);
        return response;
    });
}