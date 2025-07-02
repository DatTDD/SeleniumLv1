# Railway Website Test Automation Framework

This repository contains an automated testing framework for the Railway website. It is built using Selenium WebDriver, Java, and TestNG to automate user scenarios like logging in, booking tickets, and verifying booking details.

## Features

- Language: Java 11+
- Test Runner: TestNG
- Build & Dependency Management: Apache Maven
- Web Automation: Selenium WebDriver
- Design Pattern: Page Object Model (POM) for clean, maintainable, and reusable code.
- Data-Driven Testing: Uses TestNG's @DataProvider to read test data from external JSON files, effectively separating test logic from test data.
- Centralized Driver Management: A DriverManager class handles the lifecycle of WebDriver instances.
- Utilities: Includes common helper methods for waits, dropdown handling, and other recurring actions.

## Prerequisites
Before you begin, ensure you have the following installed on your system:
- Java Development Kit (JDK) - Version 11 or higher•Apache Maven
- An IDE - IntelliJ IDEA or Eclipse is recommended
- Web Browsers - Google Chrome

## Getting Started

### 1. Clone the Repository
git clone https://github.com/your-username/selenium-test.git

cd selenium-test

### 2. Install Dependencies
Open the project in your IDE (IntelliJ/Eclipse). It should automatically detect the pom.xml file and download all the required Maven dependencies.
If not, you can run the following command in your terminal from the project's root directory: mvn clean install

## Running the Tests

### 1. Using Maven from the Command Line
This is the simplest way to run all the tests defined in your testng.xml suite.
mvn clean test

### 2. Using TestNG in Your IDE
Most IDEs have excellent TestNG integration.
- Find the testng.xml file in the root of the project.
- Right-click on the file.
- Select "Run '.../testng.xml'".

You can also run individual test classes or methods by right-clicking them and choosing the "Run" option.
