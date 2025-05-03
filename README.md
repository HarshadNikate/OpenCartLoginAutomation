 OpenCart Login Automation Project

This is a basic Selenium automation framework created to test the **Login functionality** of the [OpenCart Demo Site](https://naveenautomationlabs.com/opencart/).  
The project follows the **Page Object Model (POM)** with **Page Factory**, and is executed using **TestNG** and **Maven**.

---

Tech Stack Used

- **Language**: Java  
- **Build Tool**: Maven  
- **Automation Tool**: Selenium WebDriver  
- **Test Framework**: TestNG  
- **Design Pattern**: Page Object Model with Page Factory  
- **IDE**: IntelliJ / Eclipse  
- **Version Control**: Git + GitHub

---

 📁 Project Structure
OpenCartProject │
├── src │
├── main │
│ └── java │ 
│ └── pages → Page classes using PageFactory 
│ └── test │ └── java │ └── tests → TestNG test class (LoginTest) │ ├── pom.xml → Maven dependencies ├── testng.xml → TestNG suite config └── README.md
 

---

 ✅ Features Covered

- Open OpenCart site
- Enter valid login credentials
- Click Login button
- Verify page title after login
- Multi-browser test execution (Chrome, Firefox, Edge)
- Page Object Model (POM) using Page Factory
- Simple and clean structure for learning and showcasing

---

 How to Run the Test

 Step 1: Clone the Repository
```bash
git clone https://github.com/your-username/OpenCartLoginAutomation.git
cd OpenCartLoginAutomation
mvn clean test
