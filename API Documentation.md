# API Documentation - Currency Converter

##### Base URL

```
http://localhost:8080/api
```
Replace localhost:8080 with your deployed server URL if hosting online.

---
 
## 1. Get Exchange Rates
- ### Endpoint
```
GET /api/rates?base={currency_code}
```

- ### Description
 Fetches real-time exchange rates for a given base currency.

- ### Query Parameters

| Parameter  | Type |Required|Default|Description|
| ------------- |:-------------:|:-------------:|:-------------:|:-------------:| 
| `base`      |string     |No|`USD`|The base currency (ISO 4217 code)|

- ### Example Request
```
GET /api/rates?base=EUR
```
- ### Example Response
```
{
  "USD": 1.08,
  "GBP": 0.85,
  "INR": 90.52
}
```
- ### Response Codes

| Status Code  | Description |
| ------------- |:-------------:|
| `200 OK`     |Successfully retrieved exchange rates.    |
| `400 Bad Request` | Invalid currency code provided.     |
| `503 Service Unavailable`  | External API is down.     |
---

## 2. Convert Currency

- ### Endpoint
```
POST /api/convert
```
- ### Description
Converts a given amount from one currency to another.

- ### Request Body (JSON)

| Parameter  | Type |Required t|Description|
| ------------- |:-------------:| :-------------:|:-------------:| 
| `from`      |string     |yes| Currency to convert from (ISO 4217 code)|
| `to`      |string     |yes| Currency to convert to (ISO 4217 code)|
| `Amount`      |double     |yes| Amount to be converted|

- ### Example Request

```
{
  "from": "USD",
  "to": "INR",
  "amount": 100
}
```
- ### Example Response
```
{
  "from": "USD",
  "to": "INR",
  "amount": 100,
  "convertedAmount": 8352
}
```
- ### Response Codes

| Status Code  | Description |
| ------------- |:-------------:|
| `200 OK`     |Successfully converted currency.    |
| `400 Bad Request` | Invalid currency code provided.    |
| `503 Service Unavailable`  | External API is down.     |
| `500 Internal Server Error`  | Unexpected error occurred.|

---
## Running API in Postman

- #### Start the Spring Boot application:
 ```
mvn spring-boot:run
```
- #### Open Postman and create a new request.
- #### Test the GET /api/rates endpoint by adding the base query parameter.
- #### Test the POST /api/convert endpoint by passing JSON data in the request body.

---
## Notes
- Ensure your API key in application.properties is valid and not expired.
- If the external API is down, the service will return a 503 Service Unavailable error.
- Always provide valid ISO 4217 currency codes to avoid 400 Bad Request errors.
---

## License
This project is licensed under the MIT License.

👤 Author: Mahesh H
🔗 Portfolio: maheshh.vercel.app
 