# 🧪 JDBC SQL Query Execution – Test Automation Project

This project is a **test automation suite** designed to execute **SQL queries** using **JDBC** (Java Database Connectivity) over the standard [MySQL Employees Schema](https://dev.mysql.com/doc/employee/en/sakila-structure.html).  
It is aimed at automating and validating SQL queries through functional assertions using Java.

---

## 📊 Project Goals

- Execute provided SQL queries on the sample **Employees** database schema.
- Validate the accuracy of query results using **automated functional tests**.
- Display meaningful outputs on the console and ensure correct JDBC interactions.

---

## 📁 Database Schema

The schema used is based on **MySQL’s official Employees sample database**.

### 👤 Employees Table

| Column Name | Description      |
|-------------|------------------|
| emp_no      | Employee number  |
| first_name  | First name       |
| last_name   | Last name        |
| birth_date  | Birth date       |
| gender      | Gender           |
| hire_date   | Hire date        |

### 🏢 Departments Table

| Column Name | Description       |
|-------------|-------------------|
| dept_no     | Department number |
| dept_name   | Department name   |

### 👔 Titles Table

| Column Name | Description          |
|-------------|----------------------|
| emp_no      | Employee number      |
| title       | Job title            |
| from_date   | Title start date     |
| to_date     | Title end date       |

### 💰 Salaries Table

| Column Name | Description       |
|-------------|-------------------|
| emp_no      | Employee number   |
| salary      | Salary            |
| from_date   | Salary start date |
| to_date     | Salary end date   |

### 🧑‍💼 Dept_Manager Table

| Column Name | Description              |
|-------------|--------------------------|
| emp_no      | Employee number          |
| dept_no     | Department number        |
| from_date   | Management start date    |
| to_date     | Management end date      |

---

## ✅ Key Tasks & Functionality

> The project verifies SQL query results via **automated JDBC tests** and **assertions**.

- ✅ Establish JDBC connection to MySQL DB.
- ✅ Read and execute provided SQL scripts.
- ✅ Print results in readable format on console.
- ✅ Validate results using assertions.
- ✅ Organize reusable code with helper classes and SQL files.

---

## 🛠️ Technologies & Tools

- Java
- JDBC (Java Database Connectivity)
- MySQL
- TestNG (for assertions and test structure)
- Maven (Project & Dependency Management)
- Git + GitHub (Version Control)
- Page Object Pattern for Query Management
  

# 👨‍💻 QA Team

| İsim           | GitHub Profili                                      |
|----------------|------------------------------------------------------|
| Merve Kıtır     | [github.com/mervektr](https://github.com/mervektr)         |
| Mert Saraç      | [github.com/meertsarac](https://github.com/meertsarac)     |
| Barış Sancar    | [github.com/brssncr](https://github.com/brssncr)           |
| Tolga Aktaş     | [github.com/aktstlga](https://github.com/aktstlga)         |
| Mert Canat      | [github.com/MertCanat91](https://github.com/MertCanat91)   |
| Berk Gültekin   | [github.com/berkgltkn](https://github.com/berkgltkn)       |

> This project is part of a database test automation framework created to enhance backend verification skills in QA/SDET education and portfolio development.
