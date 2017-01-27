var rules = require("./support/rules.js");
var auth = require("./support/auth.js");
var registration = require("./support/registration.js");
var chai = require("chai");
chai.should();
chai.use(require("chai-things"));

describe("The /rules endpoint", function(){
    it("should allow an application to register, login and get the list of all rules", itShouldAllowAnApplicationToRegisterLoginAndGeTheListOfAllRules );
    it("should allow an application to register, login and add a new rule", itShouldAllowAnApplicationToRegisterLoginAndAddANewRule );
        it("should refuse to create a rule if the provided ruleName is not available", itShouldRefuseToCreateARuleIfTheRuleNameIsNotAvailable);
});

function itShouldAllowAnApplicationToRegisterLoginAndGeTheListOfAllRules(){
    
    return rules.getRules()
    .then(function(response){
        response.status.should.equal(200)
        response.body.should.be.an('array');
        return response;
    });
}

function itShouldAllowAnApplicationToRegisterLoginAndAddANewRule(){
   
    var rule = rules.generateRule();
    return rules.addRule(rule)
    .then(function(response){
        response.status.should.equal(200);
        return response;
    });
}

function itShouldRefuseToCreateARuleIfTheRuleNameIsNotAvailable(){
    var r1 = rules.generateRule();
    var r2 = rules.generateRule();
    r2.name = r1.name;
    
    return rules.addRule(r1)
    .then(function(response){
            response.status.should.equal(200);
            return rules.addRule(r2);
    })
    .then(function(response){
            response.status.should.equal(500);
            return response;
    })
}