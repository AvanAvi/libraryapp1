# Library Management System

![Java Version](https://img.shields.io/badge/java-17-red.svg)
![Code Size](https://img.shields.io/github/languages/code-size/AvanAvi/libraryapp1)
![Issues](https://img.shields.io/github/issues/AvanAvi/libraryapp1)
![Forks](https://img.shields.io/github/forks/AvanAvi/libraryapp1)
![Stars](https://img.shields.io/github/stars/AvanAvi/libraryapp1)

A Spring Boot application for managing library operations including books, users, and borrowing records.

## Technical Stack

- **Java 17**
- **Spring Boot 2.5.4**
- **Spring Data JPA**
- **Spring Security**
- **PostgreSQL**
- **Maven**
- **JUnit & Mockito**

## Project Structure

### Core Packages

**Controllers** (`src/main/java/com/avan/libraryapp1/controller/`)
- `BookController` - Book CRUD operations and borrowing
- `UserController` - User management
- `BorrowRecordController` - Borrowing history tracking

**Services** (`src/main/java/com/avan/libraryapp1/services/`)
- `BookService` - Business logic for book operations
- `UserService` - User management logic
- `BorrowRecordService` - Borrowing workflow management

**Models** (`src/main/java/com/avan/libraryapp1/model/`)
- `Book` - Book entity with validation
- `User` - User entity with role-based access
- `BorrowRecord` - Borrowing transaction records

**Repositories** (`src/main/java/com/avan/libraryapp1/repository/`)
- Spring Data JPA repositories for data persistence

**Security** (`src/main/java/com/avan/libraryapp1/security/`)
- Authentication and authorization configuration
- Custom user details service

**DTOs** (`src/main/java/com/avan/libraryapp1/dto/`)
- Data transfer objects with validation

**Exception Handling** (`src/main/java/com/avan/libraryapp1/exceptions/`)
- Global exception handler with custom exceptions

## Key Features

- Complete CRUD operations for books and users
- Book borrowing and return system
- Role-based security authentication
- RESTful API endpoints
- Input validation and error handling
- PostgreSQL database integration

## API Endpoints

### Books
- `GET /api/books` - List all books
- `GET /api/books/{id}` - Get book by ID
- `POST /api/books` - Create new book
- `PUT /api/books/{id}` - Update book
- `DELETE /api/books/{id}` - Delete book
- `POST /api/books/{bookId}/borrow/{userId}` - Borrow book
- `POST /api/books/{bookId}/return` - Return book

### Users
- `GET /api/users` - List all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create new user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

### Borrow Records
- `GET /api/borrow-records` - List all borrow records
- `GET /api/borrow-records/{id}` - Get borrow record by ID
- `POST /api/borrow-records` - Create borrow record
- `PUT /api/borrow-records/{id}` - Update borrow record
- `DELETE /api/borrow-records/{id}` - Delete borrow record

## Testing

The project includes comprehensive unit tests using JUnit and Mockito.

**Test Structure:**
- Unit tests: `src/test/java/com/avan/libraryapp1/unittests/`
- Integration tests: `src/test/java/com/avan/libraryapp1/integrationtests/`

**Run tests:**
```bash
mvn test
```

**Current test coverage includes:**
- BookService unit tests with mocking
- Application context loading tests
- Exception handling validation

## Setup and Installation

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- PostgreSQL 12+

### Database Configuration
Update `src/main/resources/application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/LibraryManagement
    username: your_username
    password: your_password
```

### Build and Run
```bash
# Clone repository
git clone [repository-url]

# Build application
mvn clean install

# Run application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Security

- Form-based authentication
- BCrypt password encoding
- Role-based access control
- Session management with CSRF protection

## Development Philosophy

I've deliberately chosen trunk-based development over TDD for this project. While I respect TDD's place in enterprise environments and have extensive experience with it, **I find compiler-driven development more efficient for rapid iteration**. My preference is trunk-based workflow with rigorous code reviews as quality gates rather than extensive upfront test coverage. **This approach delivers working software faster** while maintaining quality through systematic review processes. I adapt to team methodologies as needed, but this represents my preferred development philosophy.

## Database Schema

The application uses JPA with automatic DDL generation. Tables are created automatically on startup:
- `books` - Book information and availability
- `users` - User accounts and roles
- `borrow_record` - Borrowing transaction history
