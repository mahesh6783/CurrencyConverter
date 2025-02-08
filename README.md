 # Currency Converter 🌍💰

A Spring Boot-based **Currency Converter** that fetches real-time exchange rates from [ExchangeRate-API](https://www.exchangerate-api.com/) and provides currency conversion functionalities.

## 🚀 Features
- Fetch **real-time exchange rates** for various currencies.
- Convert an amount from one currency to another.
- RESTful API with JSON responses.
- Exception handling for invalid inputs and external API failures.

---

## 🛠️ Technologies Used
- **Java 17**
- **Spring Boot**
- **Spring REST**
- **RestTemplate**
- **JUnit 5**
- **Maven**
- **ExchangeRate-API** (for real-time exchange rates)

---
## ⚙️ Configuration

### 1️⃣ **Setup ExchangeRate-API Key**
Sign up at [ExchangeRate-API](https://www.exchangerate-api.com/) and get a free API key.

Edit **`src/main/resources/application.properties`**:
```properties
spring.application.name=CurrencyConverter
api.currency.base-url=https://api.exchangerate-api.com/v4/latest/
api.currency.key=YOUR_API_KEY
```
----
### 📌 Endpoints
#### 🔹 Fetch Exchange Rates
GET /api/rates?base=USD
```
{
  "EUR": 0.92,
  "GBP": 0.78,
  "INR": 83.52
}
```
#### 🔹 Convert Currency
POST /api/convert
```
{
  "from": "USD",
  "to": "INR",
  "amount": 100
}
```
Response
```
{
  "from": "USD",
  "to": "INR",
  "amount": 100,
  "convertedAmount": 8352
}
```
---
## 🏗️ Build & Run the Project
### 1️⃣ Clone the Repository
```
git clone https://github.com/yourusername/CurrencyConverter.git
cd CurrencyConverter
```
### 2️⃣ Build with Maven
```
mvn clean install
```
### 3️⃣ Run the Application
```
mvn spring-boot:run
```
### ✅ Run Tests
 ```
mvn test
```
## 🔹 Steps to Test in Postman
### 1️⃣ Start Your Spring Boot Application
Make sure your project is running:
 ```
mvn spring-boot:run
```
This will start the server, typically at http://localhost:8080.
---

## 📌 Testing API Endpoints in Postman
### 🔹 Fetch Exchange Rates
```
Method: GET
URL: http://localhost:8080/api/rates?base=USD
```
Expected Response:
```
{
  "EUR": 0.92,
  "GBP": 0.78,
  "INR": 83.52
}
```
#### - Steps in Postman:
##### - Open Postman.
##### - Select GET method.
```
Enter URL: http://localhost:8080/api/rates?base=USD
```
##### - Click Send.
##### - Check the JSON response.
### 🔹 Convert Currency
- Method: POST
```
URL:http://localhost:8080/api/convert
Body (JSON format, select "raw" and type "JSON"):
 
 
{
  "from": "USD",
  "to": "INR",
  "amount": 100
}

```
-Expected Response:
``` 
{
  "from": "USD",
  "to": "INR",
  "amount": 100,
  "convertedAmount": 8352
}
```
#### Steps in Postman:
- Open Postman.
- Select POST method.
- Enter URL: http://localhost:8080/api/convert
- Go to Body > raw > Select JSON.
- Paste the above JSON request.
- Click Send.
- Check the JSON response.


---
## 📝 Author
### 👤 Mahesh H
🔗 [Portfolio](https://maheshh.vercel.app/) 
