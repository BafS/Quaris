var badges = require("./support/badges.js");
var auth = require("./support/auth.js");
var registration = require("./support/registration.js");
var chai = require("chai");
chai.should();
chai.use(require("chai-things"));

describe("The /badges endpoint", function(){
    it("should allow an application to register, login and get the list of all badges", itShouldAllowAnApplicationToRegisterLoginAndGeTheListOfAllBadges );
    it("should allow an application to register, login and add a new badge", itShouldAllowAnApplicationToRegisterLoginAndAddANewBadges )
    it("should allow an application to register, login and get a badge by it name", itShouldAllowAnApplicationToRegisteLoginAndGetABadgeByItName);
    it("should refuse to create a badge if the provided badgeName is not available", itShouldRefuseToCreateABadgeIfTheBadgeNameIsNotAvailable);
});

function itShouldAllowAnApplicationToRegisterLoginAndGeTheListOfAllBadges(){
    
    return badges.getbadges()
    .then(function(response){
        response.status.should.equal(200);
        response.body.should.be.an('array');
        return response;
    });
}

function itShouldAllowAnApplicationToRegisterLoginAndAddANewBadges(){
    
    var badge = badges.generateBadge();
    return badges.addBadge(badge)
    .then(function(response){
        response.status.should.equal(201);
        return response;
    });
}

function itShouldAllowAnApplicationToRegisteLoginAndGetABadgeByItName(){
    
    var badge = badges.generateBadge();
    return badges.addBadge(badge)
    .then(function(response){
        return badges.getbadgeByName(badge.name)
    }) 
    .then(function(response){
        response.status.should.equal(200);
        response.should.be.json;
        response.body.should.be.an('object');
        response.body.should.have.property("name");
        response.body.should.have.property("description");
        return response;
    });
}
function itShouldRefuseToCreateABadgeIfTheBadgeNameIsNotAvailable(){
    var b1 = badges.generateBadge();
    var b2 = badges.generateBadge();
    b2.name = b1.name;
   
    return badges.addBadge(b1)
    .then(function(response){
            response.status.should.equal(201);
            return badges.addBadge(b2);
    })
    .then(function(response){
            response.status.should.equal(500);
    })
}