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

API Endpoints
HTTP Method	URL Path	Description
POST	/masaibook/register	Register a new user, author, book, or cart.
POST	/masaibook/user/login	Login a user.
PUT	/masaibook/user/cart/{bookId}	Add a book to the logged-in user’s cart only if the book is not present already.
PUT	/masaibook/user/cart/purchase	Check if within the budget then purchase all the books and empty the cart (user should be able to purchase through their cart only).
GET	/masaibook/author	Return the most popular author (the author whose books have been purchased maximum number of times).
PUT	/masaibook/cart	Refresh the cart (any book which is present for more than 30 days will be removed).
DELETE	/masaibook/author	Delete an author (all books of the author from record and cart should get deleted).
PUT	/masaibook/user/cart/auto	Analyze the most number of unique books that the logged-in user can buy within their budget and add them all to the cart.
Exception Handling
The project implements custom exception handling to handle errors and exceptions in a consistent manner. The following custom exceptions are defined:

BookNotFoundException - thrown when a book with the specified ID is not found in the database
CartNotFoundException - thrown when a cart with the specified user ID is not found in the database
UserNotFoundException - thrown when a user with the specified ID is not found in the database
AuthorNotFoundException - thrown when an author with the specified ID is not found in the database
InvalidCredentialsException - thrown when the login credentials provided by the user are invalid
BadRequestException - thrown when a bad request is made to the API
NotAuthorizedException - thrown when a user is not authorized to perform a certain action

The project also defines a custom error response structure for clients to consume. The global exception handler is used to handle all exceptions and return a consistent error response to the client.


spring.datasource.url=jdbc:mysql://localhost:3306/masai_bookstore
spring.datasource.username=<your-database-username>
spring.datasource.password=<your-database-password>


Contributing
Contributions are welcome! If you find any issues or want to suggest improvements, please open an issue or submit a pull request.

License
This project is licensed under the MIT License. See the LICENSE file for details.

