# The Sprint Data Gremlin with Azure Cosmos DB example project

[![Build Status](https://dev.azure.com/kaizimmerm/tutorials/_apis/build/status/kaizimmerm.spring-data-gremlin-example?branchName=master)](https://dev.azure.com/kaizimmerm/tutorials/_build/latest?definitionId=7&branchName=master) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.kaizimmerm%3Aspring-data-gremlin-example&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.kaizimmerm%3Aspring-data-gremlin-example)

- Simple Sprint Data Gremlin service with Sprint Data Rest
- Minimal integration tests

## Used in the articles

- [Advanced DevOps: PaaS service integration testing](https://kaizimmerm.com/post/paas-service-integration-testing/)

## Getting started

### Prerequisites

- OpenJDK >=11
- Maven >=3.5

### Build

`mvn clean install`

### Run integration tests

`mvn clean install -Pintegration-tests -Dgremlin.endpoint=XXX -Dgremlin.username=XXX -Dgremlin.password=XXXX`
