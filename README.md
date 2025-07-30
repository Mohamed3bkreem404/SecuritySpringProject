# SecuritySpringProject
A  Spring Security project demonstrating user authentication and authorization using Spring Security, integrated with a relational database (JPA). It supports user registration, password encryption with BCrypt , and secure access to protected endpoints .

## 📌 Project Notes 
- Configure your database credentials in the `application.properties` file.
- Add the application properties database dependency to the `pom.xml` file .
- Specify the database `URL` , `username` , `password` , accordingly .
- I've disabled `CSRF token` to do any APIs request while developing , if you wanna remove it go ahead to `Security  Config` and remove line 47 .
