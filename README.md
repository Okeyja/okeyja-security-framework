# Okeyja Security Framework

## Introduction

This is a simple WEB-API security framework through Spring Cloud.

It uses Spring Boot Security OAuth2 to build a 
unified authentication interface.

Usually a resource service is gaining a protection via Spring Security,
this project have 3 methods of security schemes,

they are Classic Web Protection, OAuth Token Protection, and JWT OAuth Protection.

## Component
* cloud-eureka: Eureka Service
* service-hi: Sample of protected Service.
* service-jwt-auth-center: JWT protected service.
* service-token-auth-center: Auth Center Service.
* service-user: User Service, to login and register, Returning a token or JWT from RESTful API.
* service-web-security: Sample of Token protected Service.

## Version

### v1.2 (Current Version)
* Provides JWT Protection.

### v1.1
* Provides Token Protection.

### v1.0
* Provides Classic Web Protection.
* Multi Deployed Eureka Service.

## License
MIT License