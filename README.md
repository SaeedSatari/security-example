# security-example
An Example of integrating Spring Boot + Hibernate + Spring Security + OAuth2. 

## Getting started
### Prerequisites:

- Java 11
- Spring Boot 2.4.1
- Maven as our project management and comprehension tool
- H2 as our Database

To enable cache statistics `dev` profile needs to be turned on.

### Tools:
- IntelliJ IDEA
- Mapstruct for implementation of mappings between Java bean types
- Open Api and Swagger for describing RESTful APIs expressed
- Flyway as our database-migration tool
- Lombok 

### Clone the repository

```bash
    git clone https://github.com/SaeedSatari/security-example.git
```

### Run the app using maven

```bash
    cd security-example
    mvn spring-boot:run
```

### Accessing all the apis

Project documented with swagger, so you can access the apis with this link:

```
  http://localhost:8080/swagger-ui.html
```

### Authentication

```
curl -X POST \
  http://localhost:8080/oauth/token \
  -H 'authorization: Basic c3ByaW5nLXNlY3VyaXR5LW9hdXRoMi1yZWFkLXdyaXRlLWNsaWVudDpzcHJpbmctc2VjdXJpdHktb2F1dGgyLXJlYWQtd3JpdGUtY2xpZW50LXBhc3N3b3JkMTIzNA==' \
  -F grant_type=password \
  -F username=admin \
  -F password=admin1234 \
  -F client_id=spring-security-oauth2-read-write-client
```

### Accessing secured endpoints

```
curl -X GET \
  http://localhost:8080/secured/company/ \
  -H 'authorization: Bearer e6631caa-bcf9-433c-8e54-3511fa55816d'
```

I hope this example helps developers who want to learn more about Spring Security and OAuth2 integrity.
If you have any questions, please feel free to reach me by email: saeedsatari93@gmail.com 
