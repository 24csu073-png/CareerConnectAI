# CareerConnect - Placement Management System

A Spring Boot REST API project for managing campus placement activities. The application allows administrators to manage students, companies, placement drives, and job applications through RESTful APIs documented with Swagger.

---

## Features

- Student Management (CRUD)
- Company Management (CRUD)
- Placement Drive Management (CRUD)
- Job Application Management (CRUD)
- RESTful APIs
- Spring Data JPA
- Hibernate ORM
- Global Exception Handling
- Swagger API Documentation
- Unit Testing using JUnit 5 and Mockito

---

## Tech Stack

- Java 24
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Swagger / OpenAPI
- JUnit 5
- Mockito
- Lombok

---

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.careerconnect
│   │       ├── controller
│   │       ├── model
│   │       ├── repository
│   │       ├── service
│   │       ├── service.impl
│   │       ├── exception
│   │       └── CareerConnectApplication.java
│   └── resources
│       ├── application.properties
│
└── test
    └── java
        └── com.careerconnect
            └── service
```

---

## Modules

### Student

- Create Student
- Update Student
- Delete Student
- View Student
- View All Students

### Company

- Register Company
- Update Company
- Delete Company
- View Company
- View All Companies

### Placement Drive

- Create Placement Drive
- Update Placement Drive
- Delete Placement Drive
- View Placement Drives

### Application

- Apply for Job
- Update Application Status
- Delete Application
- View Applications

---

## REST API Endpoints

### Students

| Method | Endpoint |
|----------|----------------|
| POST | /students |
| GET | /students |
| GET | /students/{id} |
| PUT | /students/{id} |
| DELETE | /students/{id} |

---

### Companies

| Method | Endpoint |
|----------|----------------|
| POST | /companies |
| GET | /companies |
| GET | /companies/{id} |
| PUT | /companies/{id} |
| DELETE | /companies/{id} |

---

### Placement Drives

| Method | Endpoint |
|----------|----------------|
| POST | /placement-drives |
| GET | /placement-drives |
| GET | /placement-drives/{id} |
| PUT | /placement-drives/{id} |
| DELETE | /placement-drives/{id} |

---

### Applications

| Method | Endpoint |
|----------|----------------|
| POST | /applications |
| GET | /applications |
| GET | /applications/{id} |
| PUT | /applications/{id} |
| DELETE | /applications/{id} |

---

## API Documentation

Swagger UI

http://localhost:8080/swagger-ui/index.html

---

## Running the Project

Clone the repository

```bash
git clone https://github.com/your-username/CareerConnect.git
```

Navigate to project

```bash
cd CareerConnect
```

Run

```bash
mvn spring-boot:run
```

Open Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

## Testing

Unit testing is implemented using

- JUnit 5
- Mockito

Current test coverage includes service layer testing.

---

## Exception Handling

The project includes a centralized Global Exception Handler that returns meaningful HTTP responses for invalid requests and missing resources.

---

## Screenshots

Create a folder named **screenshots** and add images like:

```
screenshots/
│
├── 01_Swagger_UI.png
├── 02_Create_Student.png
├── 03_Get_All_Students.png
├── 04_Update_Student.png
├── 05_Delete_Student.png
├── 06_Create_Company.png
├── 07_Create_Placement_Drive.png
├── 08_Create_Application.png
├── 09_Exception_Handler.png
```

---

## Future Enhancements

- Spring Security with JWT Authentication
- Role-Based Access Control
- Email Notifications
- Student Resume Upload
- Placement Eligibility Checker
- Docker Deployment
- CI/CD Pipeline

---

## Author

**Harsh Pratap Singh**

B.Tech CSE

The NorthCap University
