# 🚀 Spring Boot CRUD App – AWS Deployment (Elastic Beanstalk + RDS PostgreSQL)

This project demonstrates a **Spring Boot REST CRUD application** deployed on **AWS Elastic Beanstalk** with a **PostgreSQL database on AWS RDS**.

---

# 🧱 Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* AWS Elastic Beanstalk
* AWS RDS
* Maven

---

# 📌 Features

* Create, Read, Update, Delete (CRUD) APIs
* RESTful API design
* Database integration with PostgreSQL
* Cloud deployment using AWS
* Environment-based configuration

---

# 🏗️ Architecture

```text
Client → Elastic Beanstalk (Spring Boot App) → AWS RDS (PostgreSQL)
```

---

# ⚙️ Local Setup

## 1. Clone Repository

```bash
git clone <your-repo-url>
cd springboot-aws
```

---

## 2. Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/employee_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 3. Run Application

```bash
mvn clean package
java -jar target/app.jar
```

---

## 4. Access API

```text
http://localhost:8080/api/v1/users
```

---

# ☁️ AWS Deployment Guide

---

## ✅ Step 1: Create RDS (PostgreSQL)

* Engine: PostgreSQL
* Instance: `db.t3.micro` (Free Tier)
* DB Name: `user_db`
* Username: `postgres`
* Enable **Public Access (for testing)**

### 🔐 Security Group

Allow inbound:

| Type       | Port |
| ---------- | ---- |
| PostgreSQL | 5432 |

---

## ✅ Step 2: Update Application for AWS

```properties
spring.datasource.url=jdbc:postgresql://<RDS-ENDPOINT>:5432/employee_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
```

---

## ✅ Step 3: Package Application

```bash
mvn clean package
```

Output:

```text
target/app.jar
```

---

## ✅ Step 4: Deploy to Elastic Beanstalk

1. Go to AWS Console → Elastic Beanstalk
2. Create Application
3. Platform: **Java**
4. Upload JAR file

---

## ✅ Step 5: Configure Environment Variables (Recommended)

In Elastic Beanstalk:

```text
SPRING_DATASOURCE_URL=jdbc:postgresql://<RDS-ENDPOINT>:5432/user_db
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=yourpassword
```

---

## 🌐 Access Application

```text
http://<elastic-beanstalk-url>/api/v1/users
```

---

# 📡 API Endpoints

| Method | Endpoint               | Description        |
| ------ | ---------------------- | ------------------ |
| GET    | /api/v1/users          | Get all users      |
| GET    | /api/v1/users/{id}     | Get users by ID    |
| POST   | /api/v1/users          | Create users       |
| PUT    | /api/v1/users/{id}     | Update users       |
| DELETE | /api/v1/users/{id}     | Delete users       |

---

# 🧪 Sample Request

```json
POST /api/v1/users

{
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

---

# ⚠️ Important Notes

* Ensure RDS is accessible from Elastic Beanstalk
* Avoid hardcoding credentials in production
* Use environment variables for security
* Use `ddl-auto=update` for development only

---

# 🧠 Learning Outcomes

* Deploy Spring Boot apps on AWS
* Configure RDS database connectivity
* Understand cloud networking (Security Groups)
* Manage environment-specific configurations

---

# 🛑 Cleanup (Avoid Charges)

## Delete Resources:

* Elastic Beanstalk Environment
* RDS Instance
* Security Groups (if created manually)

---

# 🚀 Future Improvements

* Add Swagger (API documentation)
* Implement JWT Authentication
* Use Flyway for DB migrations
* CI/CD with GitHub Actions
* Dockerize application

---

# 👨‍💻 Author

CatMansCodes
---

# ⭐ If you found this useful, give it a star!
