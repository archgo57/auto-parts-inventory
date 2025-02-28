# Automotive Parts Inventory Management System

This project is a simple automotive parts inventory management system built with a Java Spring Boot backend and a React frontend. It allows users to manage parts through a REST API and provides a user-friendly interface for inventory management.

## Project Structure

```
automotive-parts-inventory
├── backend                # Backend application
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── inventory
│   │   │   │               ├── InventoryApplication.java
│   │   │   │               ├── controller
│   │   │   │               │   └── PartController.java
│   │   │   │               ├── model
│   │   │   │               │   └── Part.java
│   │   │   │               ├── service
│   │   │   │               │   └── PartService.java
│   │   │   │               └── config
│   │   │   │                   └── SecurityConfig.java
│   │   │   ├── resources
│   │   │       ├── application.properties
│   │   │       └── inventory.json
│   │   └── test
│   │       └── java
│   │           └── com
│   │               └── example
│   │                   └── inventory
│   │                       └── PartControllerTest.java
│   ├── pom.xml
├── frontend               # Frontend application
│   ├── public
│   │   ├── index.html
│   └── src
│       ├── components
│       │   ├── AddPartForm.js
│       │   ├── InventoryDashboard.js
│       │   ├── PartList.js
│       │   ├── SearchFilter.js
│       ├── App.js
│       ├── index.js
│       ├── App.css
│       └── index.css
├── package.json           # Frontend dependencies and scripts
├── jest.config.js         # Jest configuration for UI tests
└── README.md              # Project documentation
```

## Features

- **Backend (Java with Spring Boot)**
  - REST API for managing parts (add, update, delete, view)
  - Basic authentication using an in-memory store
  - Search and filter functionality
  - JSON file storage for inventory data

- **Frontend (React)**
  - Simple inventory dashboard
  - Search and filter components
  - Forms for adding and updating parts
  - Fetch API for communication with the backend

## Getting Started

### Prerequisites

- Java 11 or higher
- Node.js and npm
- Maven

### Backend Setup

1. Navigate to the `backend` directory.
2. Build the project using Maven:
   ```
   mvn clean install
   ```
3. Run the Spring Boot application:
   ```
   mvn spring-boot:run
   ```

### Frontend Setup

1. Navigate to the `frontend` directory.
2. Install dependencies:
   ```
   npm install
   ```
3. Start the React application:
   ```
   npm start
   ```

### Testing

- **Backend Tests**: Run JUnit tests located in `backend/src/test/java/com/example/inventory/PartControllerTest.java`.
- **Frontend Tests**: Run Jest tests using:
  ```
  npm test
  ```

## License

This project is licensed under the MIT License.
