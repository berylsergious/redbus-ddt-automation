# redbus-ddt-automation
Implements Data Driven Testing using selenium, testng in redbus ticket booking webapplication automation

# RedBus Data-Driven Automation Framework  
**Selenium WebDriver + TestNG | CSV Data-Driven Testing**  

![Selenium](https://img.shields.io/badge/-Selenium-43B02A?logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/-TestNG-DD0031?logo=testng&logoColor=white)
![Java](https://img.shields.io/badge/-Java-007396?logo=java&logoColor=white)

## 🚀 Overview  
Automated test framework for [RedBus.in](https://www.redbus.in) implementing **Data-Driven Testing (DDT)** using:  
- **Selenium WebDriver** (Browser automation)  
- **TestNG** (Test management & reporting)  
- **CSV files** (Input test data/output results)  

## 📦 Key Features  
✔️ **CSV-Driven Test Cases** - Separate test logic from data  
✔️ **Dynamic Test Execution** - Run tests with multiple datasets  
✔️ **Automated Reporting** - TestNG HTML reports + CSV outputs  
✔️ **Page Object Model** - Maintainable UI locators  

## 🛠️ Tech Stack  
| Component       | Technology |  
|----------------|------------|  
| Test Framework | TestNG     |  
| Browser Automation | Selenium WebDriver |  
| Language       | Java       |  
| Build Tool     | Maven/Gradle |  
| Data Format    | CSV        |  

## ⚙️ Setup  
1. **Prerequisites**:  
   - Java JDK 8+  
   - Maven/Gradle  
   - Chrome/Firefox browser  

2. **Clone & Run**:  
   ```bash
   git clone https://github.com/your-username/redbus-ddt-automation.git
   cd redbus-ddt-automation
   mvn test
