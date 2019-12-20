#!/bin/bash
# Package content to jar
cd ..
mvn validate
mvn clean compile
mvn test
mvn package