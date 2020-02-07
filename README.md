# Fire Emblem API
Fire Emblem API is a RESTful API that provides access to Fire Emblem data.

All data is collected from https://fireemblemwiki.org through web scraping.
The web scraping repository can be found [here](https://github.com/raymondtang310/fire-emblem-data-scraper).

## Documentation
### Swagger
For documentation on how to access Fire Emblem API (e.g., endpoints, operations, request and response contracts, etc.), Swagger documentation can be found [here](https://fire-emblem-data-provider.herokuapp.com/swagger-ui.html).

### Javadoc
For documentation on the code behind Fire Emblem API, Javadoc documentation can be found [here](https://raymondtang310.github.io/fire-emblem-api/).

## Running the Application Locally
This project uses [Maven](https://maven.apache.org/) as a dependency management and build tool.

Useful commands for running and/or testing this application locally:

| Command             | Description                                                     |
| ------------------- | --------------------------------------------------------------- |
| mvn install         | Installs dependencies.                                          |
| mvn compile         | Compiles and outputs Java source classes into target directory. |
| mvn clean           | Deletes target directory.                                       |
| mvn test            | Runs tests.                                                     |
| mvn spring-boot:run | Runs this Spring Boot application on localhost:8080.            |

## Disclaimer
This application is not affiliated with Nintendo.
All data is collected from https://fireemblemwiki.org, a freely available resource on the Internet.
This project is open source and will not be used to generate profit.

## Helpful Links
- Fire Emblem wiki from which data was collected: https://fireemblemwiki.org
- Web scraping project used to collect data: https://github.com/raymondtang310/fire-emblem-data-scraper
- Swagger documentation: https://fire-emblem-data-provider.herokuapp.com/swagger-ui.html
- Javadoc documentation: https://raymondtang310.github.io/fire-emblem-api
