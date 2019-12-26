#!/bin/bash
# Package content to jar
cd ..
# remove .target/ to clean install
mvn clean
mvn validate
mvn clean compile
mvn test
mvn package