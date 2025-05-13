# 📈 Invest – Sharia-Compliant Investment Management System

**Invest** is a Sharia-compliant investment management system designed specifically for Egyptian users. The platform enables ethical investment tracking, financial planning, and risk evaluation while ensuring compliance with Islamic finance principles.

---

## 🧾 Project Overview

Invest aims to simplify the investment process by integrating essential financial tools into one unified system. It enables users to manage assets, calculate zakat, evaluate risk, and link with banking services—all in accordance with Sharia law.

---

## 🧱 Architecture Overview

### 🔷 Architecture Style: Layered + Service-Oriented

- **API Gateway:** Entry point for all user requests.
- **Core Services:**
  - **Asset Management Service:** Tracks investments using the Asset Database.
  - **Financial Goals Service:** Stores and tracks user goals.
  - **User & Zakat Service:** Manages user profiles and zakat calculations.
  - **Risk Assessment Service:** Analyzes risk and stores outcomes in the Risk DB.
- **Integration Service:** Connects to banks via external Bank APIs for real-time updates.

---


## 🎯 Features

- **Asset Management**: Track, update, and analyze investment portfolios.
- **Risk Assessment**: Evaluate and manage risk with intelligent algorithms.
- **Financial Goal Planning**: Set and monitor personal financial goals.
- **Zakat Calculator**: Automatically calculates zakat based on user holdings.
- **Bank Integration**: Seamlessly connect with banks for real-time transactions.
- **Performance Tracking**: Monitor returns, volatility, and other key metrics.
- **Fraud Detection**: Identify suspicious behaviors and generate system alerts.
- **Reports and Insights**: Get detailed reports on investments and system activity.

---

## 🛠 System Components

| Module | Description |
|--------|-------------|
| **Register** | Handles user registration and login. |
| **Validation Service** | Ensures input and data integrity across the system. |
| **Database Connector** | Manages connections, queries, and database transactions. |
| **Dashboard** | Provides a centralized view of user activity and assets. |
| **User (Abstract)** | Base class defining core attributes and auth mechanisms. |
| **Investor** | Inherits from User to manage investments and zakat. |
| **Manage Asset** | Offers tools to modify and monitor asset data. |
| **Asset** | Represents individual investments (add/remove/update). |
| **Financial Goal** | Enables goal setting, progress tracking, and reminders. |
| **Bank Account** | Stores and links users’ financial institution accounts. |
| **Performance Metrics** | Tracks portfolio performance over time. |
| **Zakat Calculator** | Computes zakat obligations accurately. |
| **Stock Market Account** | Syncs with brokerage accounts to fetch holdings. |
| **Risk Assessment** | Analyzes risk levels and suggests actions. |
| **Admin** | Oversees reports, fraud detection, and user control. |
| **Fraudulent Activity** | Logs and analyzes suspicious transactions. |
| **Report** | Generates insights for user review and system monitoring. |

---

## 🔁 Sequence Diagrams – Key Workflows

### 1. Bank Account Linking
- **Steps**: Connect → Select Bank → Enter Card → Validate → OTP → Verify → Success  
- **System**: Validates card → Sends OTP → Verifies OTP → Confirms linkage

### 2. Financial Goal Creation
- **Steps**: Add Goal → Submit → DB Insert → Confirmation  
- **System**: Saves to DB using `addGoal()` method

### 3. Risk Assessment
- **Steps**: Assess Risk → Fetch Data → Calculate Score → Generate Strategy → Display  
- **System**: Computes score (0–100), suggests risk strategies

### 4. User Login
- **Steps**: Login → Validate → DB Query → Success/Failure

### 5. Set Financial Goal
- **Steps**: Set Goal → Evaluate Investments → Save Portfolio

### 6. User Sign-Up
- **Steps**: Sign Up → Validate → DB Insert → Commit → Success

---

## 🔄 State Diagram – Investor Lifecycle

```plaintext
[Registered] 
   ↓ 
[Logged In] 
   ↓ 
[Viewing Dashboard] 
   ↓ 
[Portfolio Created] 
   ↓ 
[Goals Defined] 
   ↓ 
[Risk Assessed] 
   ↓ 
[Zakat Calculated] 
   ↓ 
[Editing Profile] 
   ↓ 
[Logged Out]

---

🧠 SOLID Principles Applied
Single Responsibility: Each class has one role (e.g., ZakatCalculator only calculates zakat).
Open/Closed: Supports new features like CryptoAsset without modifying existing classes.

Dependency Inversion: Services depend on interfaces (e.g., Portfolio ↔ RiskAnalyzer).

Liskov Substitution: Investor replaces User wherever needed.

Interface Segregation: Fine-grained interfaces for services like Notifications, Reports, etc.

🛰 TechRadar (Task 5)
Code	Technology	Summary
20230391	Prompt Engineering	Optimizing AI interactions using structured prompting techniques
20230109	React Hook Form	Efficient form management in React with validation
20230244	.NET Core	Cross-platform backend framework with high performance and flexibility

📄 License
This project is licensed under the MIT License – see the LICENSE file for details.

🙋‍♂️ Contributors
[Contributor Name 1] - Role/Contribution

[Contributor Name 2] - Role/Contribution

[Contributor Name 3] - Role/Contribution

