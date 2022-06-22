#!/bin/bash

# Start the MySQL Service for Tomcat to connect to
startSQL() {
    service mysql start
}

# Use Maven to run the spring-boot application
runSpringBoot() {
    mvn spring-boot:run
}

startSQL
runSpringBoot