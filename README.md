# BACKEND
This project was built using Java, Spring and Spring Boot.

### Building: `mvn clean package`
This will create the runnable jar file `realestate-0.0.1-SNAPSHOT.jar` inside the target folder.

### Running locally: `java -jar realestate-0.0.1-SNAPSHOT.jar` or run the class `RealEstateApplication.java`

Runs the backend.<br />
Open [http://localhost:8080](http://localhost:8080) 

### Run tests: `mvn test`

Runs the maven tests.<br />

### Build to deploy: `mvn clean package`

When this command runs, maven will generate the runnable jar file (`realestate-0.0.1-SNAPSHOT.jar`), which can be deployed. 
<br>

# FRONTEND

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app)

## Available Scripts

In the project directory, you can run:

### Running locally: `npm start`

Runs the app in the development mode.<br />
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.<br />
You will also see any lint errors in the console.

### Run tests: `npm test`

Launches the test runner in the interactive watch mode.<br />

### Build to deploy: `npm run build`

Builds the app for production to the `build` folder.<br />

# A description of how your app works
The app is very simple. It's responsive, it uses in the frontend react, react-router, redux, and in the backend Java 11, Spring and Spring Boot.
The backend uses in-memory database, which is populated by using the listings.csv file. This was done using liquibase.
The frontend consumes the Rest API that the backend provides.
The backend code has 100% coverage that contains integration tests, which tests the API contract, and unit tests, which asserts the functionality of the business classes.

# Known limitations
- There is no interactive map
    - This was not possible once I did not have enough time to do it. I would have to convert all the address first into latitude and longitude, and then with the latitude and longitude put the pin on the map.<br />

# Possible further improvements
* Add the interactive map
* Add frontend tests
* Add a container such as Docker, in order to provide the same environment required to run the application and also to easy the deployment and scalability.
* Add a nice styling, such as material design.

# Considerations of work that would be needed to productionize your code
* The code is prod-ready, once the jar built can be deployed anywhere, and also the npm run build provides the necessary bundles in order to deploy the frontend as well.