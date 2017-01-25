var registration = require("./support/registration");
var auth = require("./support/auth.js");
var Chance = require("chance");
var chance = new Chance();
var chai = require("chai");
var expect = require('chai').expect;
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
     return registration.registration(credentials)
        .then(function(response){
            return auth.auth(credentials);
        })
        .then(function(response){
            response.status.should.equal(200);
            return response;
        });

}

function itShouldRefuseToSendAJSONWebTokenIfPasswordIsWrong(){
    var application = registration.generateApplication();
    var credentials = {
        applicationName:  application.applicationName,
        password: "correctPassword"
    }
    return registration.registration(credentials)
        .then(function(response){
            credentials.password = "incorrectPassword";
            return auth.auth(credentials);
        })
        .then(function(response){
            response.status.should.equal(401);
            return response;
        });
}