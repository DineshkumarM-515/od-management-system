# 🎓 On Duty (OD) Management System

A full-stack web application designed to streamline the **On Duty (OD) approval process** in educational institutions. The system eliminates manual paperwork and provides a structured workflow for students, Proctors, Academic Coordinators (AC), and Heads of Department (HoD) to manage OD requests efficiently.

## 🚀 Overview

In many colleges, students require permission to leave campus for events such as symposiums, workshops, internships, competitions, and academic activities. Traditional OD approval processes are often paper-based, time-consuming, and lack transparency.

This project digitizes the entire workflow by providing a centralized platform where students can submit OD requests and faculty members can review, approve, or reject them through a multi-level approval process.

---

## ✨ Features

### 👨‍🎓 Student Module

* Secure login system
* Submit Online Duty requests
* Provide reason for OD
* Track request status in real time
* View approval/rejection updates

### 👨‍🏫 Proctor Module

* View pending OD requests
* Approve or reject requests
* Provide rejection remarks
* Forward approved requests to AC

### 👨‍💼 Academic Coordinator (AC) Module

* Review requests approved by Proctors
* Approve or reject requests
* Forward approved requests to HoD

### 👨‍💼 Head of Department (HoD) Module

* Final approval authority
* Review and approve/reject requests
* Complete the OD approval workflow

### 📊 Dashboard Features

* Total requests count
* Approved requests count
* Rejected requests count
* Status tracking with visual indicators
* Responsive and user-friendly interface

---

## 🔄 Workflow

Student → Proctor → Academic Coordinator (AC) → HoD → Final Decision

### Approval Flow

1. Student submits OD request.
2. Proctor reviews and approves/rejects.
3. Approved requests are forwarded to AC.
4. AC reviews and approves/rejects.
5. Approved requests are forwarded to HoD.
6. HoD provides the final approval decision.
7. Students can track the request status at every stage.

---

## 🛠️ Tech Stack

### Frontend

* HTML5
* CSS3
* JavaScript
* Bootstrap 5

### Backend

* Spring Boot
* Spring Data JPA
* REST APIs

### Database

* MySQL

### Development Tools

* IntelliJ IDEA / VS Code
* Postman
* Git & GitHub
* MySQL Workbench

---

## 🏗️ System Architecture

Frontend (HTML/CSS/JS)
↓
REST APIs (Spring Boot)
↓
Service Layer
↓
JPA Repository
↓
MySQL Database

---

## 🔐 Authentication & Authorization

* Role-based login system
* Separate access levels for:

  * Student
  * Proctor
  * Academic Coordinator (AC)
  * Head of Department (HoD)
* Dashboard actions are displayed based on user roles

---

## 📌 Key Functionalities

* Multi-level approval workflow
* Role-based access control
* Request status management
* Rejection reason tracking
* Interactive dashboard
* Real-time request monitoring
* Responsive UI design

---

## 💡 Future Enhancements

* File upload for OD proof documents
* Email notifications for approvals/rejections
* AI-powered document verification
* Analytics dashboard for approval statistics
* Spring Security with JWT authentication
* Mobile application support
* PDF report generation
* Attendance integration

---

## 🎯 Learning Outcomes

Through this project, I gained hands-on experience in:

* Full-Stack Web Development
* REST API Development
* Spring Boot Framework
* MySQL Database Design
* Role-Based Authentication
* Workflow Automation
* Frontend-Backend Integration
* Software Project Development Lifecycle

---

## 📷 Screenshots

> Screenshots will be added soon.

---

## 👨‍💻 Author

**Dinesh Kumar**

A full-stack application developed to modernize and automate the Online Duty approval process in colleges while improving transparency, efficiency, and user experience.
