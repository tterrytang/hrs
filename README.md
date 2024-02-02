# hrs
For hrs interview

Hotel Parcel Management System
This project provides a solution for managing parcels received at a hotel for guests. It allows receptionists to track guest check-ins and check-outs, accept parcels for checked-in guests, and ensure guests receive their parcels before leaving.

Getting Started
Follow these instructions to get the project up and running on your local machine for development and testing purposes.

Prerequisites
What you need to install the software:

JDK 8
Maven (if using Maven as your build tool)
Gradle (if using Gradle as your build tool)

Installing
Clone the repository


Copy code
git clone https://github.com/xxx/xxx.
Navigate to the project directory


Copy code
cd hotel-parcel-management
Build the project

For Maven:
mvn clean install
For Gradle:
./gradlew build
Running the Application
Start the application

For Maven:
mvn spring-boot:run
For Gradle:
./gradlew bootRun
Access the application

The application will be available at http://localhost:8080

Using the Application

Check-in a guest: Send a POST request to /api/guests/check-in with guest details.
Check-out a guest: Send a POST request to /api/guests/check-out/{guestId}.
Accept a parcel for a guest: Send a POST request to /api/parcels/accept/{guestId} with parcel details.
List parcels for guest pick-up: Send a GET request to /api/parcels/pickup/{guestId}.
Running the Tests
To run the automated tests for this project:

For Maven:

Copy code
mvn test

For Gradle:
./gradlew test
Built With
Spring Boot - The web framework used
Maven or Gradle - Dependency Management
H2 Database - Used for the embedded database

Contributing
Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests to us.

Authors
xxx - Initial work - xxx

License
This project is licensed under the MIT License - see the LICENSE.md file for details.

Acknowledgments
-- 

