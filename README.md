# 🛒 Ecommerce-Backend Implementation

[![Java](https://img.shields.io/badge/Language-Java%2021-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Framework-Spring%20Boot%203.x-green)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

## 📌 Project Overview
A scalable, production-ready eCommerce Backend architecture designed to handle modern web traffic. This project is a deep dive into **Enterprise Java Development**, transitioning from core algorithmic logic to a fully distributed microservices system.

---

## 🚀 Development Roadmap & Progress

I am currently following a **6-Stage Engineering Path** to ensure each layer of the application meets industry standards for performance and security.

### 🏗️ Stage 1: Core Logic & Domain Foundations `(Current Focus)`
- [x] **Domain Models**: Implementing core entities (`Product`, `User`, `Order`) with OOP best practices.
- [x] **Custom Exception Handling**: Building a robust global exception handler for clean API responses.
- [ ] **Stream API Integration**: Utilizing Java Streams for high-performance data filtering and manipulation.

### 🌐 Stage 2: RESTful API Layer `(Next Step)`
- [ ] **Spring Boot Setup**: Initializing the micro-framework with specialized dependencies.
- [ ] **REST Controllers**: Mapping business logic to HTTP endpoints.
- [ ] **Data Transfer Objects (DTOs)**: Decoupling internal entities from public API responses.

### 🗄️ Stage 3: Data Persistence & ORM
- [ ] **Database Integration**: Connecting to PostgreSQL for reliable storage.
- [ ] **Spring Data JPA & Hibernate**: Managing complex entity relationships (`@OneToMany`, `@ManyToMany`).
- [ ] **Liquibase/Flyway**: Implementing database version control (Planned).

### 🔐 Stage 4: Security & Identity Management
- [ ] **Spring Security**: Implementing a robust security filter chain.
- [ ] **JWT Authentication**: Stateless session management for distributed systems.
- [ ] **RBAC**: Implementing Role-Based Access Control (Admin vs. User).

### 💳 Stage 5: Financial Transactions
- [ ] **Stripe/PayPal Integration**: Handling real-time payments through secure webhooks.
- [ ] **Transactional Integrity**: Ensuring ACID properties using `@Transactional`.

### ☁️ Stage 6: Scaling & Microservices Architecture
- [ ] **Decomposition**: Breaking the monolith into independent services.
- [ ] **API Gateway**: Centralized entry point for the microservices ecosystem.
- [ ] **Message Broker (Kafka)**: Implementing asynchronous event-driven communication.
- [ ] **Redis Caching**: Optimizing read-heavy operations for sub-millisecond latency.

---

## 🛠️ Technical Stack
* **Language:** Java 21 (LTS)
* **Framework:** Spring Boot 3.x
* **Persistence:** Spring Data JPA / Hibernate
* **Database:** PostgreSQL
* **Tools:** Maven, Git, IntelliJ IDEA, Docker

---

## 🎓 Academic Context
This project is developed alongside my **PhD research at Eötvös Loránd University (ELTE)**, focusing on bridging the gap between advanced algorithmic theory and practical software engineering.

---

## 📄 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
