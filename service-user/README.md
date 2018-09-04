#Okeyja Security Framework - User Service
##APIs
### [POST] /user/register
To create a new user in the database, no ROLE in default.
* [param] username
```
okeyja
```
* [param] password
```
ilovehuangsong
```
### [POST] /user/login
To login with correct username and password, check the username in database and get a JWT as returning, then the following calling to the APIs should take the JWT.
* [param] username
```
okeyja
```
```
ilovehuangsong
```
The calling of JWT-based uaa service is in a Feign client class followed:
```java
@FeignClient(value = "uaa-service", fallback = AuthServiceHystrix.class)
public interface AuthServiceClient {

    @PostMapping("/oauth/token")
    JWT getToken(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("grant_type") String type,
            @RequestParam("username") String username,
            @RequestParam("password") String password
    );
}
```
And the Hystrix is:
```java
@Component
public class AuthServiceHystrix implements AuthServiceClient{

    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
```
### [ * ] /foo
A sample RESTful resource access only on role *ROLE_ADMIN*, with a bearer authorization head property, using JWT.
* [head] Authorization
```
Bearer {access_token}
```