# BookStoreApplication
Masai Book Store Application is a web application for a book store that allows users to register, login, browse books, add books to their cart, and purchase books. The application also includes features like tracking popular authors, refreshing the cart, analyzing the most number of unique books that the user can buy, and deleting an author


# Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Lambok
- Maven


# Module
- User Module
- Book Module
- Author Module
- Cart Module

# Features
- User Authentication: Users can create an account and login to access the application's features.
- Book Search: Users can search for books by title, author, or ISBN.
- Book Details: Users can view details about a specific book, including the cover image, description, author, and price.
- Book Categories: Users can browse books by categories such as Fiction, Non-fiction, Romance, Thriller, etc.
- Book Reviews: Users can read reviews of books left by other users, and also leave their own reviews.
- Cart: Users can add books to their cart and view the total price before checking out.
- Checkout: Users can checkout their cart and pay for the books using a secure payment gateway.
- Order History: Users can view their order history, including order status and tracking information.







# Validation
- This project uses validation annotations to ensure that user input is in the correct format. The following validations are implemented:

- First Name: Must not contain numbers or special characters

- Last Name: Must not contain numbers or special characters

- Mobile Number: Must have 10 digits

- Password: Must be alphanumeric and contain 6-12 characters with at least one special character, one upper case, one lowercase, and one digit

- Age: Must be above 12 years

- Gender: Must be either male or female Enum

# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/BookStoreDB;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

# API Root Endpoint
```
https://localhost:8080/
```
```
http://localhost:8080/swagger-ui/
```

Authentication
The application uses Spring Security for authentication. Users can register and log in with their email and password.
