


# Weighted Report Card Generation System

## Overview
This project is a Spring Boot application designed to generate student report cards by aggregating subject-wise marks with configurable weightages. It dynamically groups subjects (e.g., Physics, Chemistry, Biology into Science) and applies weighted calculations across exams and terms to ensure accurate and fair assessments. The system leverages MongoDB for scalable data storage and provides a RESTful API for report card generation.

## Features
- **Dynamic Subject Grouping**: Combines Physics (40%), Chemistry (30%), and Biology (30%) into a weighted Science score.
- **Weighted Score Calculation**: Aggregates marks across exams (10% Exam 1, 10% Exam 2, 80% Exam 3) and terms.
- **Flexible Term Configurations**: Supports mapping multiple exams into terms (e.g., Exams 1-3 → Term 1, Exams 4-6 → Term 2).
- **MongoDB Integration**: Stores student data efficiently in a scalable architecture.

## Prerequisites
To set up and run this application, ensure the following are installed on your system:
1. **Java 17**: Install JDK 17 and configure the `JAVA_HOME` environment variable (e.g., `C:\Program Files\Java\jdk-17`) and add `%JAVA_HOME%\bin` to the `Path`.
2. **Maven**: Install Maven (e.g., extract to `C:\Maven`) and add `C:\Maven\bin` to the `Path`.
3. **MongoDB**: Install MongoDB Community Edition and ensure it runs on `localhost:27017`.
4. **Git**: Required to clone and manage the repository.

## Setup Instructions
Follow these steps to configure the project locally on a Windows system:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/HarshaGuntreddi/ReportCardSystem.git
   cd ReportCardSystem
   ```

2. **Configure MongoDB**:
   - Start the MongoDB service by running `mongod` in a separate terminal.
   - Create a database named `reportcard_db`. No manual collection creation is required; Spring Boot handles this automatically.

3. **Verify Configuration**:
   - Open `src/main/resources/application.properties` and confirm the following settings:
     ```
     spring.data.mongodb.uri=mongodb://localhost:27017/reportcard_db
     spring.data.mongodb.database=reportcard_db
     ```

4. **Build the Project**:
   ```bash
   mvn clean package
   ```
   This command generates a JAR file in the `target` directory: `target/report-card-system-0.0.1-SNAPSHOT.jar`.

## Running the Application
1. **Execute the JAR**:
   ```bash
   java -jar target/report-card-system-0.0.1-SNAPSHOT.jar
   ```
   The application starts on `http://localhost:8080`.

2. **Test the Endpoint**:
   - Use a tool like Postman or `curl` to send a POST request to `http://localhost:8080/api/reportcard/generate`.
   - **Example Request Body**:
     ```json
     {
         "name": "Suresh/src/main/java/com/reportcard/ReportCardApplication.java Doe",
         "subjectScores": {
             "Term1": {
                 "Physics": 78.0,
                 "Chemistry": 72.0,
                 "Biology": 80.0,
                 "English": 82.0
             },
             "Term2": {
                 "Physics": 88.0,
                 "Chemistry": 82.0,
                 "Biology": 86.0,
                 "English": 84.0
             }
         }
     }
     ```
   - **Expected Response**: Includes calculated final scores (e.g., Science ≈ 81.2, English ≈ 83.0).

## Project Structure
```
ReportCardSystem/
├── pom.xml                    # Maven configuration with Spring Boot and MongoDB dependencies
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/reportcard/
│   │   │       ├── ReportCardApplication.java  # Main Spring Boot application class
│   │   │       ├── model/
│   │   │       │   └── Student.java           # Entity class for student data in MongoDB
│   │   │       ├── repository/
│   │   │       │   └── StudentRepository.java # MongoDB repository interface
│   │   │       ├── service/
│   │   │       │   └── ReportCardService.java # Logic for weighted score calculations
│   │   │       └── controller/
│   │   │           └── ReportCardController.java # REST API endpoint for report generation
│   └── resources/
│       └── application.properties  # MongoDB connection settings
└── README.md                  # This documentation file
```

## GitHub Integration
To manage this project on GitHub:
1. **Initialize Git Locally** (if not already done):
   ```bash
   cd C:\Users\win\Documents\ReportCardSystem
   git init
   git add .
   git commit -m "Initial commit of Weighted Report Card Generation System"
   ```
2. **Link to Remote Repository**:
   ```bash
   git remote add origin https://github.com/HarshaGuntreddi/ReportCardSystem.git
   ```
3. **Push to GitHub**:
   ```bash
   git push -u origin main
   ```
   - Note: If your local branch is `master`, rename it with `git branch -m master main` before pushing.

## Test Cases
1. **Standard Case**:
   - Input: As shown in the "Running the Application" example.
   - Expected Output: Science ≈ 81.2, English ≈ 83.0 (simplified term aggregation).
2. **Missing Subject**:
   - Input:
     ```json
     {
         "name": "Suresh Sir",
         "subjectScores": {
             "Term1": {
                 "Physics": 90.0,
                 "Chemistry": 85.0,
                 "English": 88.0
             }
         }
     }
     ```
   - Expected Output: Science ≈ 63.5 (Biology defaults to 0), English ≈ 88.0.

## Troubleshooting
- **MongoDB Connection**: Ensure MongoDB is running and the URI in `application.properties` is correct.
- **Push Errors**: If `src refspec main does not match any` occurs, verify commits exist (`git log`) and the branch is `main`.
- **Build Failures**: Check Java and Maven versions match the prerequisites.

## Contributing
Contributions are welcome. Please fork the repository, create a feature branch, and submit a pull request for review.

## License
This project is currently unlicensed. A formal license may be added in future updates.

---
Developed by Harsha Guntreddi, March 2025
```

