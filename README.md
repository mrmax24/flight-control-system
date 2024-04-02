# Flight Control Manager
## Project description:
```
Rest API service for managing information related to air companies, 
including flights, airplanes data, and air company details.
```
## Project structure

The application has a Three-Tier Architecture:
- **Presentation layer** (Controller) - accepts requests from clients and sends results back to them.
- **Application logic** layer (Service) - provide logic to operate on the data sent to and from the Repository and the client.
- **Data access layer** (Repository) - represents a bridge between the database and the application.

## Used technologies and libraries:
| Technology             | Version     |
|:-----------------------|:------------|
| `JDK`                  | `11`        |
| `Maven`                | `4.0.0`     |
| `Spring Boot`          | `2.2.0`     |
| `Spring Boot Data JPA` | `2.2.0`     |
| `Spring Boot Web`      | `2.2.0`     |
| `Hibernate validator`  | `6.0.17`    |
| `MySQL`                | `8.0.33`    |
| `Mapstruct`            | `1.5.5`     |
| `Lombok`               | `1.18.22`     |
| `Swagger`              | `2.3.0`  |
| `Log4j`                | `2.17.2`    |
| `Checkstyle`           | `3.3.0`     |
| `Docker`               | `24.0.6`    |

## Steps to run the program on your computer:
1. Clone the repo: https://github.com/mrmax24/flight-control-system
2. Install MySQL;
3. Create new schema in database (UTF-8 general-ci);
4. Add your DB properties to **application.properties** file;
5. Create connection to DB using Database option (Intellij Idea Ultimate);
6. Run AirCompaniesManagementSystemApplication class;
7. Set the value of spring.jpa.hibernate.ddl-auto to 'validate' and restart the app
8. Use prepared postman endpoints to test application; 

## Steps to dockerize services and database on your computer:
1. Add your DB properties from **application.properties** to .env file
2. Install Docker Desktop and run it;
3. Run ```docker build -t spring-boot-api .```
4. Run ```docker-compose up```



