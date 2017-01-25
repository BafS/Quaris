var badges = require("./support/badges.js");
var auth = require("./support/auth.js");
var registration = require("./support/registration.js");
var chai = require("chai");
chai.should();
chai.use(require("chai-things"));

describe("The /badges endpoint", function() {
    it("should allow an application to register, login and get the list of all badges", itShouldAllowAnApplicationToRegisterLoginAndGeTheListOfAllBadges );
    it("should allow an application to register, login and add a new badge", itShouldAllowAnApplicationToRegisterLoginAndAddANewBadges )
    it("should allow an application to register, login and get a badge by its name", itShouldAllowAnApplicationToRegisteLoginAndGetABadgeByItsName);
    it("should refuse to create a badge if the provided badgeName is not available", itShouldRefuseToCreateABadgeIfTheBadgeNameIsNotAvailable);
});

function itShouldAllowAnApplicationToRegisterLoginAndGeTheListOfAllBadges() {
    var application = registration.generateApplication();
    var credentials = {
        applicationName : application.applicationName,
        password: application.password
    }
    return registration.registration(application)
    .then(function(response) {
        return auth.auth(credentials);
    })
    .then(function(response) {
        return badges.getbadges(response);
    })
    .then(function(response) {
        response.status.should.equal(200);
        response.body.should.be.an('array');
        return response;
    });
}

function itShouldAllowAnApplicationToRegisterLoginAndAddANewBadges() {
    var application = registration.generateApplication();
    var credentials = {
        applicationName : application.applicationName,
        password: application.password
    }
    var badge = badges.generateBadge();
    return registration.registration(application)
    .then(function(response) {
        return auth.auth(credentials);
    })
    .then(function(response) {
        return badges.addBadge(badge, response);
    })
    .then(function(response) {
        response.status.should.equal(201);
        return response;
    });
}

function itShouldAllowAnApplicationToRegisteLoginAndGetABadgeByItsName() {
    var application = registration.generateApplication();
    var credentials = {
        applicationName : application.applicationName,
        password: application.password
    } 
    var badge = badges.generateBadge();
    var name = badge.name;
    return registration.registration(application)
    .then(function(response) {
        return auth.auth(credentials);
    })
    .then(function(response) {
        return badges.addBadge(badge, response);
    })
    .then(function(response) {
        return badges.getbadgeByName(response);
    })
    .then(function(response) {
        response.status.should.equal(200);
        response.should.be.json;
        response.body.should.be.an('object');
        response.body.should.have.property("name");
        response.body.should.have.property("description");
        response.body.should.have.property("icon");
        return response;
    });
}
function itShouldRefuseToCreateABadgeIfTheBadgeNameIsNotAvailable() {
    var b1 = badges.generateBadge();
    var b2 = badges.generateBadge();
    b2.name = b1.name;
    var application = registration.generateApplication();
    var credentials = {
        applicationName : application.applicationName,
        password: application.password
    }
    return registration.registration(application)
    .then(function(response) {
        return auth.auth(credentials);
    })
    .then(function(response) {
        return badges.addBadge(b1, response.body.applicationName);
    })
    .then(function(response) {
            response.status.should.equal(201);
            return badges.addBadge(b2, response.body.applicationName);
    })
    .then(function(response) {
            response.status.should.equal(409);
    })
}