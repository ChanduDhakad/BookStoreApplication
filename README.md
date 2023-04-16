# BookStoreApplication
Masai Book Store Application is a web application for a book store that allows users to register, login, browse books, add books to their cart, and purchase books. The application also includes features like tracking popular authors, refreshing the cart, analyzing the most number of unique books that the user can buy, and deleting an author

Masai Book Store Application
This project is a RESTful web application for a book store that allows users to register, login, add books to their cart, purchase books from their cart, refresh their cart, delete an author (including all books by that author from the record and cart), and analyze the most number of unique books that the logged-in user can buy within their budget and add them all to the cart.

The project uses a MySQL database to store and retrieve user, book, author, and cart information. Spring Boot and Spring Data JPA are used to build and manage the APIs, while Spring Security is used to implement authentication for verifying user credentials.

#Getting Started

#Prerequisites
To run this application, you need to have the following installed on your machine:

Java 11 or higher
MySQL 8 or higher
Postman or a similar API development environment
Installation and Setup
Clone this repository to your local machine.
Create a new MySQL database called "masaibook".
Update the database properties in the application.properties file located in src/main/resources with your MySQL username and password.
Run the application using your IDE or by executing the following command in your terminal within the project directory:
arduino
Copy code
mvn spring-boot:run
Use Postman or a similar API development environment to send HTTP requests to the API endpoints.
API Endpoints
HTTP Method	URL Path	Description
POST	/masaibook/register	Register a new user, author, book, or cart.
POST	/masaibook/user/login	Login a user.
PUT	/masaibook/user/cart/{bookId}	Add a book to the logged-in user’s cart only if the book is not present already.
PUT	/masaibook/user/cart/purchase	Check if within the budget then purchase all the books and empty the cart (user should be able to purchase through their cart only).
GET	/masaibook/author	Return the most popular author (the author whose books have been purchased maximum number of times).
PUT	/masaibook/cart	Refresh the cart (


