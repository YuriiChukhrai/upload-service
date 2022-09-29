# upload-service

## Dependencies
Make sure you have installed on your operating system:<br/>
1. [JDK. Oracle](http://www.java.com/) OR [OpenJDK](https://jdk.java.net/archive/)
2. [Git](https://git-scm.com/)
3. [Maven](https://maven.apache.org/)


## Run using Maven

`$> mvn spring-boot:run -Dspring-boot.run.profiles=[{provile: local, dev,prod}] -DAPI_USER={user name} -DAPI_PSW={bcypto password} -DSTORAGE_PATH={storage folder path}`</br>
OR</br>
`$> mvn spring-boot:run -Dspring-boot.run.profiles=local,prod -DAPI_USER=user -DAPI_PSW=$2a$10$wS9mh62IdlmpaNiPP6n3DuxAZ00H3fhbgfj$atWLR9NCibJSklV3PMu -DSTORAGE_PATH=/Users/bla/upload-service/storage`

## Run using JAR
`$> mvn clean package -Dmaven.test.skip=true` - generate JAR artifact</br>
`$> java -Dspring.profiles.active=local,prod -jar ./target/upload-service.jar` - run service</br>
> **_NOTE:_** The environment variables [API_USER, API_PSW, STORAGE_PATH] should be setup in your system in that case. 


## cURL

```shell
curl --location --request POST '{URI}:{port}/api/v1/upload' \
--header 'Accept: application/json' \
--header 'Authorization: Basic {Base64}' \
--form 'file=@"{path}"' \
--form 'platform="{platform name}"'
```

OR

```shell
curl --location --request POST 'http://localhost:7779/api/v1/upload' \
--header 'Accept: application/json' \
--header 'Authorization: Basic YXBpOnZsc3BnbkBmUjEyMyA=' \
--form 'file=@"/Users/bla/Downloads/heroku-osx.pkg"' \
--form 'platform="rasberry"'
```


## Open API / Swagger UI

**Swagger:** `http://server:port/context-path/swagger-ui.html` - `http://localhost:7777/swagger-ui/index.html` </br>
**OpenAPI:** `http://server:port/context-path/v3/api-docs` - `http://localhost:7777/v3/api-docs`


## References
* [Spring. Uploading files](https://spring.io/guides/gs/uploading-files/)
* [Spring. Basic authentication#1](https://www.baeldung.com/spring-security-basic-authentication)
* [Spring. Authentication](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/basic.html)
* [Spring. Spring security#1](https://www.javadevjournal.com/spring/basic-authentication-with-spring-security/)
* [SpringBoot. Upload/download file](https://dzone.com/articles/java-springboot-rest-api-to-uploaddownload-file-on)
* [Spring. Basic authentication#2](https://howtodoinjava.com/spring-boot2/security-rest-basic-auth-example/)
* [Spring. Spring security#2](https://howtodoinjava.com/spring-security/http-basic-authentication-example/)
* [Spring. Spring security#3](https://spring.io/blog/2017/11/01/spring-security-5-0-0-rc1-released#password-storage-format)
* [Project Lombok](https://projectlombok.org/)
* [Oracle. Project Lombok](https://www.oracle.com/corporate/features/project-lombok.html)
* [Spring Doc/OpenAPI](https://springdoc.org/#getting-started)

