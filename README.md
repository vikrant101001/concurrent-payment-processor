# 💸 Concurrent Payment Processor

> ⚙️ A multithreaded microservice built with **Java Spring Boot** that simulates a real-world payment processing system using custom thread pools, asynchronous execution, retry logic, and a fake database — all while being lightning-fast, scalable, and resilient.

---

## 📚 Table of Contents

- [🚀 Project Summary](#-project-summary)
- [🧠 Core Concepts Implemented](#-core-concepts-implemented)
- [🎯 Functional Highlights](#-functional-highlights)
- [📦 Tech Stack](#-tech-stack)
- [🌐 Sample Flow](#-sample-flow)
- [🎯 Use Cases & Why This Matters](#-use-cases--why-this-matters)
- [🤩 What Makes This Project Special?](#-what-makes-this-project-special)
- [📂 Project Structure](#-project-structure)
- [💼 For Resume / Portfolio](#-for-resume--portfolio)
- [🛠️ Future Enhancements](#️-future-enhancements)
- [🧑‍💻 Author](#-author)

---

## 🚀 Project Summary

`Concurrent Payment Processor` is an enterprise-grade simulation of how modern fintech applications handle high-throughput payment processing. Built with concurrency and microservice principles in mind, it demonstrates key concepts like **multithreading**, **custom thread pools**, **failure handling with retry mechanisms**, and a live **in-memory dashboard** to track each transaction's journey in real-time.

Designed to showcase strong Java backend development skills with clean code, solid architecture, and features relevant to technical interviews.

---

## 🧠 Core Concepts Implemented

-   ✅ **Custom ThreadPool:** Configuration using `ThreadPoolTaskExecutor`.
-   ✅ **Asynchronous Execution:** Leveraging Spring's `@Async` annotation for non-blocking operations.
-   ✅ **Failure Simulation & Retry Logic:** Mimicking real-world transient errors and implementing recovery strategies.
-   ✅ **In-Memory Concurrent DB:** Using `ConcurrentHashMap` for thread-safe storage and retrieval of payment states.
-   ✅ **Real-Time Status Tracking:** Monitoring the lifecycle of each payment (`PENDING`, `SUCCESS`, `FAILED`).
-   ✅ **RESTful APIs:** Endpoints provided for triggering payments and viewing their status.
-   ✅ **Modular Codebase:** Adhering to SOLID principles for maintainability and scalability.
-   ✅ **Microservice Ready:** Designed with principles that allow easy extension into a larger microservices ecosystem.

---

## 🎯 Functional Highlights

| Feature                  | Description                                                                 |
| :----------------------- | :-------------------------------------------------------------------------- |
| `POST /api/payment/process` | Triggers payment processing for one or more IDs concurrently.                 |
| `GET  /api/payment/all`   | Lists all payments with their current status: `PENDING`, `SUCCESS`, `FAILED`. |
| `Multithreaded Execution`  | Payments are processed in parallel using a configurable custom thread pool. |
| `Failure Simulation`     | Random failures are intentionally introduced during processing.             |
| `Auto Retry`             | Built-in logic attempts to reprocess failed payments (e.g., fixed delay).   |
| `Concurrency Safe Storage` | Payment states are managed safely in a thread-safe in-memory structure.     |
| `Logging & Monitoring`   | Detailed logs track thread activity and transaction lifecycle.              |

---

## 📦 Tech Stack

-   🧠 **Java 17:** Core programming language.
-   ☕ **Spring Boot 3:** Framework for building robust applications quickly.
-   🔄 **Spring Async + Executor:** For managing asynchronous tasks and thread pools.
-   🗃️ **ConcurrentHashMap:** Simple, thread-safe in-memory data store simulation.
-   ⏱️ **Spring Scheduler:** (Optional) Can be used for scheduled tasks like retry mechanisms.
-   🧪 **JUnit + Mockito:** For comprehensive unit and integration testing.
-   🚢 **Deployment:** Can be run locally, containerized with Docker, or deployed to platforms like Render.

---

## 🌐 Sample Flow

1.  User sends a `POST` request to `/api/payment/process` with a list of payment IDs.
2.  Each payment task is submitted to the custom `ThreadPoolTaskExecutor`.
3.  The `PaymentService` processes each payment asynchronously (`@Async`).
4.  During processing, a random failure might be simulated (`RuntimeException`).
5.  Successful payments are marked as `SUCCESS` in the `ConcurrentHashMap`.
6.  Failed payments are marked as `FAILED`. *Retry logic can be triggered here.*
7.  User sends a `GET` request to `/api/payment/all` to view the status and timestamps of all payments.

### 🔁 Retry Mechanism (Coming Soon)

We plan to enhance the retry logic with:

-   Configurable number of retry attempts.
-   Strategies like exponential backoff between retries using libraries like `Spring Retry`.

### 📊 Real-Time Dashboard (Coming Soon)

A simple frontend (e.g., using Thymeleaf or a separate ReactJS app) to:

-   Visualize current payment statuses (Success, Pending, Failed).
-   Potentially allow manual retries for failed payments.

---

## 🎯 Use Cases & Why This Matters

-   ✅ **Fintech Simulations:** Understand the core mechanics of high-volume transaction systems.
-   ✅ **Scalable Backend Systems:** Learn practical techniques for handling numerous asynchronous requests efficiently.
-   ✅ **Resilient Design:** Grasp the importance of retry patterns, error handling, and fault tolerance.
-   ✅ **Interview Ready:** Provides concrete examples to discuss system design, concurrency, and microservice concepts in interviews.

---

## 🤩 What Makes This Project Special?

> "Most payment demos just hit one API and stop. We went deeper: custom thread pools, failure simulation, retries, a concurrent fake DB, and observability hooks — simulating key aspects of a real-world system minus the actual bank integration."

-   **Clean Code:** Emphasis on readability, maintainability, and SOLID principles.
-   **Concurrency Focused:** Designed from the ground up to be asynchronous and leverage multithreading effectively.
-   **Scalable Architecture:** Modular design makes it easy to swap components or scale up.
-   **Interview-Worthy:** Demonstrates practical application of important backend engineering concepts.
-   **Extensible:** Easy foundation to upgrade with components like Redis (caching/locking), Kafka (queuing), or PostgreSQL (persistence).

---

## 📂 Project Structure

```bash
concurrent-payment-processor/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/paymentprocessor/
│       │       ├── config/         # Spring configurations (e.g., AsyncConfig.java)
│       │       ├── controller/     # REST API endpoints (e.g., PaymentController.java)
│       │       ├── model/          # Data objects (e.g., Payment.java, PaymentStatus.java)
│       │       ├── repository/     # Data access layer (e.g., InMemoryPaymentRepository.java)
│       │       ├── service/        # Business logic (e.g., PaymentService.java)
│       │       └── PaymentProcessorApplication.java # Main application entry point
│       └── resources/
│           └── application.properties # Application configuration
├── pom.xml                         # Maven project configuration
└── README.md                       # This file

```
# 🛠️ Future Enhancements
```bash
[ ] Integrate Spring Retry for robust, configurable retry logic with exponential backoff.
[ ] Introduce a Message Queue (e.g., Kafka, RabbitMQ) to decouple request ingestion from processing.
[ ] Replace ConcurrentHashMap with a persistent store like Redis (for caching/state) or a relational DB (H2, PostgreSQL).
[ ] Develop a simple UI Dashboard (e.g., React + Chart.js or Thymeleaf) for real-time monitoring.
[ ] Add Monitoring using Spring Boot Actuator, Prometheus, and Grafana.
[ ] Implement distributed tracing for better observability in a microservices context.
[ ] Enhance Unit and Integration Tests for better coverage.

```
# 🧑‍💻 Author
```bash
Built with ❤️ by Vikrant — A passionate Java fullstack developer and system design enthusiast.