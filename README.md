Smart House Management System

The Smart House Management System is a backend web application developed in Java using the Spring Boot framework. The system exposes a REST-based interface that enables the management and interaction with smart house resources in a controlled and structured manner. The application is designed to support multiple user roles, each with clearly defined responsibilities and access levels.

The system distinguishes between visitors, registered users, and administrators. A visitor represents an unauthenticated client who can interact only with publicly accessible endpoints. Through the registration mechanism, a visitor can create an account and become a registered user. During this process, the system validates user input, securely stores credentials using password encryption, and automatically creates and associates a smart house instance with the newly registered user.

A registered user is associated with exactly one house and is permitted to interact only with resources belonging to that house. Users can retrieve information about their own house, including its current state, and can actively control specific smart features. These features include modifying the desired target temperature and toggling the lighting state on or off. All user-level operations are restricted to personal resources, ensuring isolation and preventing unauthorized access to other users’ data.

Administrative users are granted elevated privileges that allow full visibility and control over the system. Administrators can view all registered users and all existing houses, manage the lifecycle of these entities, and perform critical operations such as deleting users and their associated houses. In addition to management capabilities, administrators can directly control smart house features across the system, including switching lights on or off and adjusting target temperatures for any house. This centralized control enables system-wide supervision and maintenance.

From a technical perspective, the application is implemented using Java and the Spring Boot ecosystem. Spring Web is used to expose RESTful endpoints, Spring Data JPA is employed for persistence and database interaction, and Hibernate manages object-relational mapping. Domain entities are clearly defined and mapped using JPA annotations, reflecting real-world relationships between users and houses. Business logic is encapsulated within service classes, ensuring a clean separation between request handling and core functionality.

The application follows a modular and maintainable architecture, allowing for straightforward extension with additional smart home features, enhanced security mechanisms, or integration with frontend or mobile clients. Its REST-based design makes it suitable for consumption by external applications and facilitates easy testing and integration.

This project demonstrates proficiency in backend application development, REST API design, role-based access control, secure user management, and smart system modeling using Java and Spring Boot.

Author
Iacob Bianca
