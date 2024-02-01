# How to run locally

## Prerequisites (you need to have installed Docker,Java, Maven NodeJs, NPM, Angular CLI) 
1. Start docker daemon & start docker container for Postgres with the commands in 2) and 3) 
2. `cd docker`
3. `docker-compose -f docker-compose.yml up`
4. Use a DB Client (like DataGrip) to execute the sql script (in the folder `sql` in the root) to create a table in the Database & import the data from the `files/homework_order_lines.csv`
5. Using another terminal, from the root folder - build the Java Backend API (from the root folder do `mvn clean install`)
6. After it is built - start the backend `java -jar .\target\proton-orders-0.0.1-SNAPSHOT.jar`
7. Using third terminal, from the root folder - change to the Frontend App, ` cd .\orders-ui\` and run `ng serve` to start the Frontend App
8. Open `http://localhost:4200/` (the Frontend App)
9. Test the app - Mark something to be followed up, remove it, refresh the page
10. Postman-like collections are provided in the `bruno-collections` folder - they can be used to execute REST requests to test the backend API