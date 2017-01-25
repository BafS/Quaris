var events = require("./support/events.js");
var auth = require("./support/auth.js");
var registration = require("./support/registration.js");
var chai = require("chai");
chai.should();
chai.use(require("chai-things"));

describe("The /events endpoint", function() {
    it("should allow an application to register, login and add a new Event", itShouldAllowAnApplicationToRegisterLoginAndAddANewEvent)
});


function itShouldAllowAnApplicationToRegisterLoginAndAddANewEvent() {
    var application = registration.generateApplication();
    var credentials = {
        applicationName: application.applicationName,
        password: application.password
    }
    var event = events.generateEvent();
    return registration.registration(application)
        .then(function(response) {
            return auth.auth(credentials);
        })
        .then(function(response) {
            return events.addEvent(event, response);
        })
        .then(function(response) {
            response.status.should.equal(200);
            return response;
        });
}