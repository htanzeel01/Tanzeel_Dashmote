# Tanzeel_Dashmote

# Dashmote Case Study

This is a spring boot application that has been made with h2 database.


## Starting
using an IDE such as intellij you start the project. 
To find the database use the link localhost:8080/h2. username and password of database is sa (sa is both password and username). To best access the endpoints I used postman but you can also use your browser. 

## To access Files
To access the files you can go to the src/main/java/CaseStudy/Dashmote/ and see all the controller/model/service classes. The apprunner file contains the code where the json files were read. 

## For Api Endpoints
To navigate through the api Endpoint. There are 2, for Endpoints regarding ubereats use the localhost:8080/ubereats, with /brand being used for getting the brand using request param and /price for getting a menu item above a certain price, also requires a request param.

For Endpoints regarding traveladvisor use the localhost:8080/tripadvisor, this one has 3 endpoints, with one used to post  a new outlet. A get request to get a specific outlet which requires a requires param. And the third Endpoint which is also a get but with /source, which gets a list of all outlets. 
