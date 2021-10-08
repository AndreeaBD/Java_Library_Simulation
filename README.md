# Java_Library_Simulation
This library management system simulation was implemented in Java using OOP concepts.
The library is a Singleton class which manages multiple books and users. 
The commands accepted are: add student/professor, search for books, list users, add books, list books, list unborrowed books, sort clients/books, 
filter books by genre, borrow/return book, show most loyal client, remove clients/books, show client penalties, show book history.
A second thread runs in parallel showing how many available books are in the library every 50 seconds.
A few exceptions were created for dealing with unavailable books trying to be accessed and borrowing more than one book per user.
The users and the books are kept in lists.
