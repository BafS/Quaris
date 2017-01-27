var registration = require("./support/registration");
var auth = require("./support/auth.js");
var Chance = require("chance");
var chance = new Chance();
var chai = require("chai");
chai.should();
chai.use(require('chai-things'));

describe("The /auth endpoint", function(){
    it("should allow a registered application to get a JSON Web Token", itShouldAllowARegisteredApplicationToGetAJSONWebToken);
    it("should refuse to send a JSON Web Token if password is wrong", itShouldRefuseToSendAJSONWebTokenIfPasswordIsWrong);
});

function itShouldAllowARegisteredApplicationToGetAJSONWebToken(){
     var application = registration.generateApplication();
     var credentials = {
        applicationName: application.applicationName,
        password: application.password
     }
     return registration.registration(application)
        .then(function(response){
            return auth.auth(credentials);
        })
        .then(function(response){
            response.status.should.equal(200);
            response.headers.should.not.be.empty;
            //console.log("response : " + response.get('Authorization'));
            return response;
        });

}

function itShouldRefuseToSendAJSONWebTokenIfPasswordIsWrong(){
    var application = registration.generateApplication();
    var credentials = {
        applicationName:  application.applicationName,
        password: "correctPassword"
    }
    return registration.registration(application)
        .then(function(response){
            credentials.password = "incorrectPassword";
            return auth.auth(credentials);
        })
        .then(function(response){
            response.status.should.equal(401);
            return response;
        });
}