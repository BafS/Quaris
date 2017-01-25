var apiPrefix = "http://localhost:8090/api";
var api = require("supertest-as-promised")(apiPrefix);
var Chance = require("chance");
var chance = new Chance();

var context = {};

function getRules(jsonWebToken) {
    context.token = jsonWebToken.headers.authorization.replace(/Bearer */i, "");
    var request = api.get('/rules');
    request.set("Authorization", context.token);
    return request
        .then(function(response) {
            return response;
        });
}

function addRule(rule, jsonWebToken) {
    if (context.token === undefined)
        context.token = jsonWebToken.headers.authorization.replace(/Bearer */i, "");
    return api
        .post('/rules')
        .set("Authorization", context.token)
        .set('Content-Type', 'application/json')
        .send(rule)
        .then(function(response) {
            return response;
        });
}

function generateRule() {
    return {
        name: chance.name(),
        condition: chance.name(),
        action: chance.name(),
        enabled: chance.bool()
    }
}

module.exports = {
    getRules: getRules,
    addRule: addRule,
    generateRule: generateRule
}