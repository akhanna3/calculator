# Calculator
This application is a simple calculator. The program reads in arithmetic expressions as text from an input stream, parse the expressions, evaluate them, and then write the result to an output stream.
Calculator is a [Maven](http://maven.apache.org/) Java project.  It contains a Maven file called pom.xml that sits in the root directory of the project.  The pom.xml file describes how the project is structured, built, tested, and packaged.

## Prerequisites
- SSH terminal software

### Required software
- Java SE7 (latest) + J2EE7SDK installed and configured
- Maven 3.2.1 installed and configured
- Modern Java IDE recommended (Eclipse Kepler, NetBeans or Intellij) with Maven and Git

## Extract Code

- Open a terminal on Mac or Linux
- tar xvf calculator.bla 
- cd calculator
- ls -la
- You should see pom.xml and src directory


## Compiling and Running Calculator
Maven allows for many commands that are quite useful when running Calculator. [Sonatype's Maven guide][mvn] has an excellent review of lifecycle phases and goals.

### Compiling
- mvn clean compile

### Installing local on your machine
- mvn clean install 

### Starting Calculator
-  cd calculator
-  mvn -e exec:java -Dexec.mainClass="com.calculator.Main"

##Testing

### Running unit tests
Unit tests are coded in JUnit and can be run from within Eclipse or using Maven.

- mvn clean test 

## Logging
Logs are stored under calculator/logs/ directory. 




[mvn]: http://books.sonatype.com/mvnref-book/reference/lifecycle-sect-structure.html





# calculator
