var events = require("./support/events.js");
var auth = require("./support/auth.js");
var registration = require("./support/registration.js");
var chai = require("chai");
chai.should();
chai.use(require("chai-things"));

describe("The /events endpoint", function(){
    it("should allow an application to register, login and add a new event", itShouldAllowAnApplicationToRegisterLoginAndAddANewEvent )
});

function itShouldAllowAnApplicationToRegisterLoginAndAddANewEvent(){
    
    var event = events.generateEvent();
    return events.addEvent(event)
    .then(function(response){
        response.status.should.equal(200);
        return response;
    });
}