# Net Worth

A spring boot application that helps you to calculate your net wealth using MySQL database , Java and Swagger UI.

## Installation

•  Clone the repository: `git clone https://github.com/ZShajarkar/net-worth.git`

•  Navigate to the project directory: `cd net-worth`

•  Create a MySQL database named `snappay` and update the `application.properties` file with your database credentials.

•  Build the project: `mvn clean install`

•  Run the application: `mvn spring-boot:run`


## Usage

The application exposes a REST API that can be accessed using Swagger UI. To access the Swagger UI, open the following URL in your browser: http://localhost:9992/swagger-ui.html

The API consists of the following endpoints:

•  `/users`: Register a new user with an email and a password.

•  `/users/login`: Login with an existing user and get a JWT token.

•  `/liability`: Create liabilities for the logged in user.

•  `/asset`: Create assets for the logged in user.

•  `/report/net-worth`: Calculate and get the net worth for the logged in user.


To use the API, you need to follow these steps:

•  Register a new user using the `/users` endpoint.

•  Login with your email and password using the `/users/login` endpoint. You will receive a JWT token that you need to include in the header of your subsequent requests as `Authorization: Bearer &lt;token&gt;`.

•  Create liabilities using the `/liability` endpoint. You can specify  amount of each liability.

•  Create assets using the `/asset` endpoint. You can specify  amount of each asset.

•  Calculate your net worth using the `/report/net-worth` endpoint. You will receive the net worth.


## License



## Contact


•  Email: shajarkarz@gmail.com

•  GitHub: https://github.com/ZShajarkar
