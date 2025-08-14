#  Student Management System (JDBC)

A simple **Java console application** that performs **CRUD operations** (Create, Read, Update, Delete) on a student database using **JDBC** and **MySQL**.

##  Features
- **Add New Student** – Insert student details into the database.

  <img width="647" height="521" alt="Screenshot 2025-08-14 204359" src="https://github.com/user-attachments/assets/f8d528c5-6e85-4baf-b4f1-f6df28a4d9dc" />
  <img width="316" height="117" alt="Screenshot 2025-08-14 204510" src="https://github.com/user-attachments/assets/04ba3046-0368-4375-bd36-70e2c2eef4fb" />


- **View All Students** – Display all student records from the database.

<img width="539" height="273" alt="Screenshot 2025-08-14 204600" src="https://github.com/user-attachments/assets/1644676b-d13d-4979-9333-a770789f7e85" />
<img width="283" height="103" alt="Screenshot 2025-08-14 204635" src="https://github.com/user-attachments/assets/5276063d-1160-457a-90c1-8eedd127065a" />


- **Update Student** – Modify details of an existing student by ID.

  <img width="621" height="452" alt="Screenshot 2025-08-14 204710" src="https://github.com/user-attachments/assets/2cf11823-fe76-4ca1-8da8-fc0689754ba7" />
  <img width="275" height="99" alt="Screenshot 2025-08-14 204750" src="https://github.com/user-attachments/assets/076d4b8e-3dfd-47f3-a676-f0036190742f" />


- **Delete Student** – Remove a student record by ID.

  <img width="628" height="278" alt="Screenshot 2025-08-14 204816" src="https://github.com/user-attachments/assets/211e53c8-0af7-4810-9ebb-2f9df1cd21c7" />
  <img width="284" height="68" alt="Screenshot 2025-08-14 204828" src="https://github.com/user-attachments/assets/8adf85e1-23d3-4832-9a44-1ad76b1570db" />


- **Validation** – Ensures records exist before updating/deleting.

##  Technologies Used
- **Java** (JDK 8+)
- **MySQL** (Database)
- **JDBC** (Java Database Connectivity)

##  Database Setup
1. Create a MySQL database:
    ```sql
    CREATE DATABASE student_db;
    ```
2. Create the `student` table:
    ```sql
    CREATE TABLE student (
        id INT PRIMARY KEY,
        name VARCHAR(50),
        age INT,
        marks INT
    );
    ```

## ⚙️ Configuration
Update the database credentials in the code:
```java
String url = "jdbc:mysql://localhost:3306/student_db";
String username = "root";
String password = "your_password";
