# Library Management System (LMS) 📚🔍

![Java Version](https://img.shields.io/badge/java-17-red.svg)

![Code Size](https://img.shields.io/github/languages/code-size/AvanAvi/libraryapp1)
![Issues](https://img.shields.io/github/issues/AvanAvi/libraryapp1)
![Forks](https://img.shields.io/github/forks/AvanAvi/libraryapp1)
![Stars](https://img.shields.io/github/stars/AvanAvi/libraryapp1)

The Library Management System (LMS) is a comprehensive web application designed to facilitate the efficient management of library resources, including books, users, and loan records. Utilizing a modern technology stack, this system is engineered for scalability, robustness, and a superior user experience, aiming to streamline the operations of libraries.

## Features 🌟

- **Book Management**: Implement full CRUD operations for library books. Advanced search capabilities enable quick book retrieval by title, author, or ISBN.
- **User Management**: Comprehensive handling of user profiles, including registration, authentication, and role-based access control.
- **Borrowing System**: A sophisticated system to track the loaning of books, including due dates, return processing, and overdue notifications.

## Technologies 🛠

- **Spring Boot**: Simplifies the development of stand-alone, production-grade Spring based Applications.
- **Hibernate ORM**: Provides a powerful, high-performance object/relational persistence and query service.
- **PostgreSQL**: Offers an advanced, open-source relational database system.
- **JUnit & Mockito**: Facilitates effective unit and integration testing.
- **Maven**: Manages dependencies, builds, and documentation from a central piece of information.

## Architecture Overview 🏗

LMS employs a clean, layered architecture to promote the separation of concerns, facilitating maintainability and ease of testing. The system's architecture comprises:

- **Controller Layer**: Manages HTTP request/response cycles, converting JSON payloads into domain objects and vice versa.
- **Service Layer**: Encapsulates the business logic, offering services to the controller layer.
- **Repository Layer**: Directly interacts with the database, utilizing Spring Data JPA for data persistence.
- **Model Layer**: Represents the application's domain model, including entities and their relationships.
- **Security Configuration**: Ensures secure access to the application's endpoints through authentication and authorization.

## Getting Started 🚀

### Prerequisites

- JDK 17 or newer
- Maven 3.6+
- PostgreSQL 12+

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/AvanAvi/libraryapp1.git
   ```
2. Configure the database in `src/main/resources/application.yml` with your PostgreSQL credentials.
3. Build the application:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```

## Testing 🧪

LMS includes a suite of unit and integration tests ensuring the reliability and functionality of the system. Execute the tests via:

```


mvn test
```

## Development Methodologies 🔄 (I'm ranting here 🗣️) 
### 

*While I fully acknowledge the benefits of **Test-Driven Development (TDD)**—its role in fostering tightly-coupled, secure software systems, and its esteemed position within numerous enterprises and top-tier firms—I must candidly share my personal stance. After diligently practicing TDD, gaining proficiency and even a natural fluency over time, I've come to a simple, personal conclusion: **it's just not my preference**. I find both **trunk-driven and compiler-driven development methodologies** to be more aligned with my understanding of modern, agile software practices—**quicker, more adaptable**, and, in my view, **more suited to the rapid pace of current development cycles**. This reflection is not a dismissal of TDD's value or a refusal to engage with it professionally. Instead, it's a transparent expression of my critical assessment of different methodologies. To potential recruiters reviewing this README: please see this as an honest disclosure of my development philosophy, **not as a limitation** in my ability to adapt and thrive within diverse technical environments.*


TDD? Nah, a straight-up time-suck. 🙅‍♂️ Planning and testing every single line before coding? Kills spontaneity faster than a bad stand-up routine. 💀

TDD is like those obnoxious road trip planners, mapping out every rest stop and playlist. 🧭🚗 News flash: sometimes winging it is better. That's trunk-driven development's charm. 🌳

With trunk-based dev, the main branch is sacred—only the finest code allowed. 💎 It's the VIP section; code reviews are the strict bouncers. 🚪👮‍♂️

But trunk-driven dev's real perk? Freedom to explore, experiment, even controlled mistakes—without wrecking the project. 🔥💣 Coding with a safety net. 🤸‍♂️

Ditch TDD's needless validation. 🗑️ Blasphemy? Maybe, but who cares? 😈 Trunk-driven dev is streamlined, adrenaline-pumping, no hand-holding required for kickass code delivery. 🚀💯

Time to leave outdated methodologies behind. 💨 We're coding fast and furious from now on. 🏎️💨



