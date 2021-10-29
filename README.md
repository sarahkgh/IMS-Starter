Coverage: 71%
# IMS Starter Project

IMS project with customer, item and order entities linking with JDBC to SQL. The project included methods which were tested using JUnit, and it was regularly backed up to GitHub and documented on Jira.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software

-Eclipse IDE. This software can be installed from the Eclipse website.
-MySQL Workbench. This software can be installed from the MySQL website.

### Installing

A step by step series of examples that tell you how to get a development env running

1. Fork the IMS-Starter repository and copy the code URL.
2. In a local folder, use GitBash to clone the code URL so the project is now within your local system.
3. Open Eclipse > file > open Projects from File System...
4. Open the folder which was created after cloning the IMS code over.
5. The folder should show in the package explorer. Expand and look over the various packages and classes.
6. Right-click the src/test package to conduct the customer tests which are there. Coverage As > JUnit Test.
7. A JUnit tab will pop up next to the package explorer. Observe all tests have passed.
8. Right-click src/main then Run as > java application. Observe the IMS in the console.
9. Use the methods (create, read) to manipulate customer data. Follow the instructions in the console.

## Running the tests

By right-clicking the src/test package and using coverage as JUnit test, this will test all the code covered within the classes and whether the methods within them have passed. It is important to ensure the tests have passed as this suggests the methods are working and functional. Each DAO and controller class have their own tests which overall all link back to the methods create, read, update and delete; these are what are majorly tested.

### Unit Tests 

Testing the methods within the classes allows for detection of whether these tests have passed or failed. If they have failed, it suggests that there is some sort of error in the method code so this would have to be looked at. If there is a test failure here, then it may cause issues in the console when running as a java application.

### Integration Tests 
This tests connections and more of the database as opposed to unit tests which only test a function per class. Integration tests look at all modules of the project and how they link. This can be a seperate folder to Unit testing and can be run with its own tests.

### And coding style tests

This refers to the coding standards and how the code is supposed to be laid out in a test for it to run.

## Deployment

Ensuring that this is a Maven project so that it can link to other databases and can use JUnit testing.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Sarah Khan** - *Initial work* - [Sarah Khan](https://github.com/sarahkgh)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
