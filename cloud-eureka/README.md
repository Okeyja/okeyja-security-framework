# Okeyja Security Framework Eureka

## Build Highly-Available Eureka Server Environment in IntelliJ IDEA

The resources directory contains three configuration files:

* application-6001.properties
* application-6002.properties
* application-6003.properties

Attaching following argument to deploy eureka nodes with different ports:
```
--spring.profiles.active=6001
```
Or assign a unique config item in console:
```
--server.port=6001
```
Open *Run/Debug Configuration* Window to add a new enter point and add the argument at *Program arguments*