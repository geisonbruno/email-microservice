# Email Microservice


***
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

This project is a Microservice built using **Java, Java Spring, MySQL as a database.**

# About the project

Este microsserviço foi desenvolvido para centralizar o envio de e-mails para qualquer serviço dentro de uma arquitetura de microsserviços. Utilizando o framework Spring Boot junto com Spring Email, ele oferece uma solução eficiente para o gerenciamento de comunicações por e-mail.

Inicialmente, o microsserviço foi configurado para operar com SMTP do Gmail, processando as requisições de forma síncrona por meio de uma API REST. Com o objetivo de aumentar expandir meus conhecimentos e suportar demandas escaláveis, ele foi evoluído para um modelo mais avançado, passando a utilizar AWS-SES para o envio de e-mails e RabbitMQ para o processamento assíncrono de mensagens.

Tive experiência prática nesse projeto de estudo, evoluindo o microsserviço de e-mail desde sua configuração inicial até sua evolução para um modelo escalável e orientado a eventos.

## Table of Contents
***
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)

## Technologies Used
***

- Java 17
- Sring boot
- Maven
- Spring Fox / Spring Doc (Swagger Documentation)

## Installation
***
1. Clone the repository:

```bash
git clone https://github.com/geisonbruno1/Email-Microservice
```

2. Run the command ```mvn clean install``` in the project root to download dependencies and compile the code.

3. Run the command ```mvn spring-boot:run``` to start the application.

## Usage
***

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080

- With the application running, access the URL http://localhost:8080/swagger-ui.html to explore the documentation generated by Spring Fox.

## API Endpoints
***
The API provides the following endpoints:

```markdown
POST /sending-email - Send a new email

GET /emails - Lists all emails already sent
```
