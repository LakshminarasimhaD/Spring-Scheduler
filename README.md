Project Description

This is a Spring Boot application that demonstrates the implementation of a scheduled task runner for a user management system. The application's core functionality is to periodically send automated emails to registered users using a background scheduler. It showcases how to use Spring's powerful scheduling features for time-based, automated tasks.

Key Features:

User Registration: An API endpoint to register new users, storing their details in a MySQL database. It prevents duplicate user registrations by checking for an existing email.

Spring Scheduler: The application uses the @Scheduled annotation to run two separate tasks at fixed intervals:

Welcome Emails: Sends a welcome email to all registered users every 60 seconds.

Promotional Emails: Sends a promotional email to all registered users every 120 seconds.

Asynchronous Execution: Both scheduled tasks are marked with the @Async annotation, allowing them to run concurrently on separate threads. This prevents one long-running task from blocking the other, ensuring efficient and non-blocking execution.

Email Service: An email service is implemented to handle the sending of emails using JavaMailSender. The application is configured to use an SMTP server (e.g., Gmail) to deliver the emails.

Data Persistence: Spring Data JPA is used for database interaction, with Hibernate as the ORM to manage user data in a MySQL database.

Technologies Used:

Java 17

Spring Boot 3.x

Spring Data JPA

Hibernate

MySQL

Lombok

Spring Mail

