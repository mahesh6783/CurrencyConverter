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

## 📂 Project Structure

CurrencyConverter │── src/main/java/com/mahesh/CurrencyConverter │ ├── controller │ │ ├── CurrencyConverterController.java │ ├── model │ │ ├── ExchangeRateResponse.java │ ├── service │ │ ├── CurrencyConversionService.java │── src/test/java/com/mahesh/CurrencyConverter │ ├── service │ │ ├── CurrencyConversionServiceTest.java │── src/main/resources │ ├── application.properties │── pom.xml │── README.md


---

## ⚙️ Configuration

### 1️⃣ **Setup ExchangeRate-API Key**
Sign up at [ExchangeRate-API](https://www.exchangerate-api.com/) and get a free API key.

Edit **`src/main/resources/application.properties`**:
##properties
spring.application.name=CurrencyConverter
api.currency.base-url=https://api.exchangerate-api.com/v4/latest/
api.currency.key=YOUR_API_KEY

##📌 Endpoints
###🔹 Fetch Exchange Rates
GET /api/rates?base=USD
{
  "EUR": 0.92,
  "GBP": 0.78,
  "INR": 83.52
}
###🔹 Convert Currency
POST /api/convert
{
  "from": "USD",
  "to": "INR",
  "amount": 100
}
Response
{
  "from": "USD",
  "to": "INR",
  "amount": 100,
  "convertedAmount": 8352
}

##🏗️ Build & Run the Project
###1️⃣ Clone the Repository
git clone https://github.com/yourusername/CurrencyConverter.git
cd CurrencyConverter
###2️⃣ Build with Maven
mvn clean install
###3️⃣ Run the Application
mvn spring-boot:run
###✅ Run Tests
mvn test
###📝 Author
####👤 Mahesh H
🔗 [Portfolio](https://maheshh.vercel.app/) 



