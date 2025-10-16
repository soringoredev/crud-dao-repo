🚀 Spring Boot DAO Project
📌 Overview

Spring Boot DAO Project is a modular Java backend application built with Spring Boot 3, following a clean layered architecture (Controller → Service → DAO → Entity).
It demonstrates proper separation of concerns for database access, maintainability, and scalability.

🧱 Architecture

Layers:

Controller — handles REST endpoints and incoming requests

Service — business logic layer

DAO (Data Access Object) — abstracts and encapsulates database operations

Entity — maps Java objects to database tables

This structure keeps the code testable, reusable, and easy to maintain.

⚙️ Tech Stack
Category	Technologies
Framework	Spring Boot 3.x
Database	PostgreSQL / MySQL (configurable)
Persistence	JDBC / Spring Data JPA
Migrations	Flyway
Documentation	OpenAPI / Swagger
Build Tool	Maven / Gradle
Testing	JUnit 5 / Testcontainers
Deployment	Docker & Docker Compose
📁 Project Structure
src/
 ├─ main/
 │   ├─ java/com/example/demo/
 │   │    ├─ controller/
 │   │    ├─ service/
 │   │    ├─ dao/
 │   │    ├─ model/
 │   │    └─ DemoApplication.java
 │   └─ resources/
 │        ├─ application.yml
 │        └─ db/migration/
 └─ test/
      └─ java/com/example/demo/

🚀 Quick Start
1️⃣ Clone the repository
git clone https://github.com/<your-username>/<repo-name>.git
cd <repo-name>

2️⃣ Configure the database

Edit your application.yml or application.properties:

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/demo
    username: postgres
    password: password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

3️⃣ Run the application
./mvnw spring-boot:run


Access the app at http://localhost:8080

🧩 DAO Example
public interface UserDao {
    List<User> findAll();
    Optional<User> findById(Long id);
    void save(User user);
    void delete(Long id);
}

@Repository
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users",
            new BeanPropertyRowMapper<>(User.class));
    }
}

🧪 Testing

Run all tests:

./mvnw test


For containerized tests:

./mvnw verify -Ptestcontainers

🐳 Docker

Build and run with Docker Compose:

docker-compose up --build

📖 API Documentation

Once the app is running, open:

http://localhost:8080/swagger-ui.html

🤝 Contributing

Pull requests are welcome!
For major changes, please open an issue first to discuss what you’d like to change.

🪪 License

This project is licensed under the MIT License
.
