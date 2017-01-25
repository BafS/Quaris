var apiPrefix = "http://localhost:8090/api";
var api = require("supertest-as-promised")(apiPrefix);
var Chance = require("chance");
var chance = new Chance();

var context = {};

function getbadges(jsonWebToken) {
    context.token = jsonWebToken.headers.authorization.replace(/Bearer */i,"");
    var request = api.get("/badges");
        request.set("Authorization", context.token);
    return request
        .then(function(response) {
            return response;
        });
}

function addBadge(badge, jsonWebToken) {
    var request = api.post('/badges');
    if(context.token === undefined || context.token === null)
        context.token = jsonWebToken.headers.authorization.replace(/Bearer */i,"");
    request.set("Authorization", context.token);
    context.name = badge.name;
    return request
        .set('Content-Type', 'application/json')
        .send(badge)
        .then(function(response) {
            return response;
        });
}
function getbadgeByName(name) {
    var request = api.get("/badges/" + context.name);
    request.set("Authorization", context.token);
    return request
        .then(response => {
            return response;
        });
}

function generateBadge() {
    return {
        name: chance.name(),
        description: "for test app"
        //icon: "smiley"
    }
}

module.exports = {
    getbadges: getbadges,
    addBadge: addBadge,
    getbadgeByName: getbadgeByName,
    generateBadge: generateBadge
}