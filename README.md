# QUARIS

## A multi-tier application project by Henrik Akesson & Fabien Salathe

# Context
This repo contains the code to run a gamification API. It is a project proposed by [Olivier Liechti](https://github.com/wasadigi) in the context of our [AMT lesson](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-AMT-Lectures) at HEIG-VD.

# How to

## Setup
Before getting started you'll need to download and install [IntelliJ IDEA](https://www.jetbrains.com/idea/#chooseYourEdition) and  [MySql Server](https://dev.mysql.com/downloads/windows/installer/5.7.html).

## Run the app
Then, after cloning this repo, open it IntelliJ IDE run the project by clicking on the run/debug command. IntelliJ will build and run the Spring Server that will run the database and run the app.

- Clone this repository
- Open the projet in your IntelliJ IDE
- Edit the application.properties file, by adding the password of you Root account of MySql Server
- Click on the Run/Update button
- Open your browser and access the url `http://localhost:8090/`
- And magic happens.

## API documentation
Check it out here: https://akessonhenrik.github.io/QUARIS/api/

### PostMan tests info
To make the postman tests work ("*QUARIS.postman_collection.json*"), you may want to use postman environment variables.

Three are needed in that case, unless you want to manually inject them in every query:

 - **host** : address where the site is running (examples: **localhost** or **192.168.99.100**)
 - **port** : port where the webapp is accessible (using docker or without modifying the configuration: **9090**)
 - **base** : Name of the webapp (using docker or without modifying the configuration: **/QUARIS-1.0-SNAPSHOT**)
