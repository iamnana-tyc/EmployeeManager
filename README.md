# Employee Manager Backend API

A backend REST API for managing employee data, built with **Java**, **Spring Boot**, and **Spring Data JPA**.

This project demonstrates a simple and clean implementation of RESTful API endpoints for creating, reading, updating, and deleting employee records. It is designed to showcase backend fundamentals including API design, data persistence, and proper project structure.

## Features

- Create a new employee  
- Retrieve employee details  
- Update employee information  
- Delete an employee  
- Structured using layered architecture (Controller → Service → Repository)  
- Uses Spring Boot, Spring Data JPA, and PostgreSQL (or any relational database)

## Tech Stack

**Backend:**  
- Java  
- Spring Boot  
- Spring Data JPA  

**Database:**  
- PostgreSQL (recommended) / H2 (optional for testing)

**Tools:**  
- Maven (build)   
- GitHub (version control)

## Getting Started

Follow these steps to run the project locally on your machine.

### Prerequisites

Before you begin, ensure you have:

- Java 21 (or compatible JDK) installed  
- Maven installed  
- PostgreSQL database installed and running

### Setup & Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/iamnana-tyc/EmployeeManager.git
````

2. **Navigate to the backend project**

   ```bash
   cd EmployeeManager/EmployeeManagerBackend
   ```

3. **Configure the database**

   Open `src/main/resources/application.properties` and set your database connection, for example:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Build the project**

   ```bash
   mvn clean install
   ```

5. **Run the application**

   ```bash
   mvn spring-boot:run
   ```

   The backend API will start on `http://localhost:8080`.

## API Endpoints

| Method | Endpoint          | Description                 |
| ------ | ----------------- | --------------------------- |
| GET    | `/employees`      | Get all employees           |
| GET    | `/employees/{id}` | Get employee by ID          |
| POST   | `/employees`      | Create a new employee       |
| PUT    | `/employees/{id}` | Update an existing employee |
| DELETE | `/employees/{id}` | Delete an employee          |

## Example Requests

### Create Employee

```bash
POST /employees
Content-Type: application/json

{
  "name":"John Brain",
  "email":"brain@test.com",
  "phone":"+1223459565",
  "jobTitle":"CEO",
  "employeeCode":"123"

}
```

### Get All Employees

```bash
GET /employees
```

## Future Improvements

* Add authentication (JWT / Spring Security)
* Add automated tests (JUnit, MockMvc)
* Improve validation and error handling
* Add Swagger/OpenAPI documentation

## About Me

This project is part of my journey to become a professional backend engineer. It demonstrates my understanding of core backend development with Spring Boot and REST APIs.

You can find more projects on my GitHub:
[https://github.com/iamnana-tyc](https://github.com/iamnana-tyc)
