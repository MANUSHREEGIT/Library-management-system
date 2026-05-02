📚 Library Seat Reservation System (Swing + JDBC + MySQL)

1. 📌 Project Overview

The Library Seat Reservation System is a desktop-based application developed using Java Swing, JDBC, and MySQL. It allows users to reserve seats, manage bookings, and perform operations like viewing, updating, searching, and deleting reservations.

This project follows a 3-layer architecture:

Presentation Layer (Swing UI)

Business Logic Layer (Service)

Data Access Layer (DAO)



---

2. 🎯 Objectives

To provide a simple GUI-based reservation system

To implement CRUD operations using JDBC

To demonstrate separation of concerns using DAO pattern

To integrate Java application with MySQL database



---

3. 🛠️ Technologies Used

Java (Core Java + Swing)

JDBC (Java Database Connectivity)

MySQL Database

IDE: Eclipse / IntelliJ IDEA



---

4. 🏗️ System Architecture

Layers:

1. UI Layer (LibraryUI.java)

Handles user interaction using Swing components



2. Service Layer (OrderService.java)

Contains business logic

Acts as a bridge between UI and DAO



3. DAO Layer (OrderDAO & OrderDAOImpl)

Performs database operations



4. DTO Layer (OrderDTO.java)

Transfers data between layers



5. Database Connection (DBConnection.java)

Establishes connection with MySQL





---

5. 🗄️ Database Design

Database Name:

library_db

Table: orders

Column Name	Data Type	Description

order_id	INT (PK, AI)	Unique Order ID
customer_name	VARCHAR(100)	Name of the user
table_number	INT	Seat number
item_name	VARCHAR(100)	Book/Item name
quantity	INT	Quantity
total_amount	DOUBLE	Total cost
order_status	VARCHAR(50)	Status (Preparing/Completed)



---

6. ⚙️ Functional Requirements

Place a new reservation

View all reservations

Delete a reservation

Update reservation status

Search reservation by ID



---

7. 🔄 System Workflow

1. User enters details in GUI


2. Clicks button (Reserve/View/Delete/etc.)


3. UI sends request to Service layer


4. Service calls DAO methods


5. DAO interacts with database using JDBC


6. Result is returned and displayed in UI




---

8. 🧩 Module Description

8.1 DBConnection.java

Loads MySQL driver

Establishes database connection


8.2 OrderDTO.java

Represents reservation data

Contains getters and setters


8.3 OrderDAO.java

Interface defining CRUD operations


8.4 OrderDAOImpl.java

Implements database operations using SQL queries


8.5 OrderService.java

Handles business logic

Calculates total amount


8.6 LibraryUI.java

GUI built using Swing

Contains buttons and input fields

Handles user events



---

9. 🖥️ User Interface Components

JTextField (Input fields)

JButton (Actions)

JTextArea (Output display)

JFrame (Main window)

JPanel (Layout management)



---

10. 🚀 How to Run the Project

1. Install MySQL and create database


2. Run SQL script to create table


3. Add MySQL Connector JAR to project


4. Update DB username & password in DBConnection.java


5. Compile and run LibraryUI.java




---

11. ⚠️ Error Handling

Handles SQL exceptions using try-catch

Displays messages for success/failure

Validates user input (basic level)



---

12. 📈 Future Enhancements

Add login authentication system

Use JTable for better UI display

Add seat availability tracking

Improve UI with modern themes

Export data to PDF/Excel



---

13. ✅ Advantages

Simple and user-friendly

Modular and maintainable code

Easy database integration

Scalable for future upgrades



---

14. ❌ Limitations

Basic UI design

No advanced validation

Single-user system



---

15. 📌 Conclusion

The Library Seat Reservation System demonstrates how Java Swing can be integrated with JDBC and MySQL to build a functional desktop application. It provides a strong foundation for understanding real-world application development using layered architecture.


---

✨ End of Documentation
