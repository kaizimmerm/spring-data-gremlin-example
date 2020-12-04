# The Sprint Data Gremlin with Azure Cosmos DB example project

- Simple Sprint Data Gremlin service with Sprint Data Rest
- Minimal integration tests 

## Getting started

### Prerequisites

- OpenJDK >=11
- Maven >=3.5

### Build

`mvn clean install`

### Run integration tests

`mvn clean install -Pintegration-tests -Dgremlin.endpoint=XXX -Dgremlin.username=XXX -Dgremlin.password=XXXX`
