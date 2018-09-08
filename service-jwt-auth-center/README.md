# Okeyja Security Framework - JWT Auth Center
JWT Auth Center provides the authentication surface for our users to access our application.
It is a useful common way, and it has a very high performance because all the TOKENs are stored at the clients.

[Learn more about JWT (JSON Web Tokens)](https://jwt.io/ "JWT").

## Generate Public and Private Keys
* Private key - okeyja-jwt.jks
```
keytool -genkeypair -alias okeyja-jwt -validity 3650 -keyalg RSA -dname "CN=jwt,OU=jtw,O=jtw,L=zurich,S=zurich,C=CH" -keypass okeyja -keystore okeyja-jwt.jks -storepass okeyja123
```
* Public Key - public.cert
```
keytool -list -rfc --keystore okeyja-jwt.jks | openssl x509 -inform pem -pubkey
```
## APIs
### [POST] /oauth/token
Check the user's login and return a JWT to access the protected resources.
* [head] Authorization
```
Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==
```
* [param] Grant_Type
```
password
```
* [param] Username
```
admin
```
* [param] Password
```
123456
```

Usually we using the authentication service through a feign client following:

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
*uaa-service* is this service module.

And the hystrix code flowed:

```java
@Component
public class AuthServiceHystrix implements AuthServiceClient{

    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
```