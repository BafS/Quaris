var registration = require("./support/registration.js");
var chai = require("chai");
chai.should();
chai.use(require('chai-things'));
var apiPrefix = "http://localhost:8090/api";
var api = require("supertest-as-promised")(apiPrefix);

describe("The /registrations endpoint", function(){
    it("should make it possible to create a new application account", itShouldMakeItPossibleToCreateANewApplicationAccount);
    it("should refuse to create an application account if mandatory fields are not provided", itShouldRefuseToCreateAnApplicationAccountIfMandatoryFieldsAreNotProvided);
    it("should allow any application to get the list of applications", itShouldAallowAnyApplicationToGetTheListOfApplications );
    it("should refuse to create an application account if the password length is < 5", itShouldRefuseToCreateAnApplicationAccountIfThePasswordLengthIsSmallerThan5);
    it("should refuse to create an application account if the provided applicationName is not available", itShouldRefuseToCreateAnApplicationAccountIfTheApplicationNameIsNotAvailable);
});

function itShouldMakeItPossibleToCreateANewApplicationAccount(){
    var payload = registration.generateApplication();
    return registration.registration(payload)
        .then(function(response){
            response.status.should.equal(201);
            response.should.have.property('status', 201);
            return response;
        });
}

function itShouldRefuseToCreateAnApplicationAccountIfMandatoryFieldsAreNotProvided(){
    var payload = registration.generateApplication();
    var original = JSON.stringify(payload);

     var wrongPayloads = [];
     for(var i=0; i<2; i++){
         wrongPayloads.push(JSON.parse(original));
     }

     delete wrongPayloads[0].applicationName;
     delete wrongPayloads[1].password;

     var promises = wrongPayloads.map(p => registration.registration(p));
     console.log(wrongPayloads)
     return Promise.all(promises)
     .then(function(response){
         response.forEach(r => (r.status.should.equal(422)));
     });
}

function itShouldAallowAnyApplicationToGetTheListOfApplications(){
    registration.getApplications()
    .then(function(response){
            response.status.should.equal(200);
            response.body.should.be.an("array");
            return response;
        });
}

function itShouldRefuseToCreateAnApplicationAccountIfThePasswordLengthIsSmallerThan5(){
    var payload = registration.generateApplication();
    payload.password = 1234;
    return registration.registration(payload)
        .then(function(response){
            response.status.should.equal(422);
        })
        .then(function(){
            payload.password = "12345";
            return registration.registration(payload);
        })
        .then(function(response){
            response.status.should.equal(201);
        });
}

function itShouldRefuseToCreateAnApplicationAccountIfTheApplicationNameIsNotAvailable(){
    var a1 = registration.generateApplication();
    var a2 = registration.generateApplication();
    a2.applicationName = a1.applicationName;
    return registration.registration(a1)
        .then(function(response){
            response.status.should.equal(201);
            return registration.registration(a2)
        })
        .then(function(response){
            response.status.should.equal(422);
        })
}