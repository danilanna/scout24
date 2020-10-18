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

# Known constraints and/or limitations
There is no interactive map - This was not possible once I did not have enough time to do it. I would have to convert all the entries first into latitute and logintude, and then put the pin on the map.

# Possible further improvements
Add the interactive map

# Considerations of work that would be needed to productionize your code
Add a container such as Docker, in order to provide the same environment required to run the application and also to easy the deployment