# Email Microservice

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
[![GitHub license](https://img.shields.io/github/license/Naereen/StrapDown.js.svg)](https://github.com/Naereen/StrapDown.js/blob/master/LICENSE)



# Sobre o projeto

Inicialmente, o microsserviço foi configurado para operar com SMTP do Gmail, processando as requisições de forma síncrona por meio de uma API REST. Com o objetivo de expandir meus conhecimentos, ele foi evoluído para um modelo mais escalável, passando a utilizar AWS-SES para o envio de e-mails e RabbitMQ para o processamento assíncrono de mensagens.

Tive experiência prática nesse projeto de estudo, evoluindo o microsserviço de e-mail desde sua configuração inicial até sua evolução para um modelo escalável e orientado a eventos.

## Sumário 

- [Instalação](#instalação)
- [Como usar](#como-usar)
- [API Endpoints](#api-endpoints)

## Tecnologias usadas

- Java 21
- Sring boot
- API REST
- AWS SES
- RabbitMQ
- PostgreSQL
- Gmail SMTP
- Maven
- Swagger Documentation

## Instalação
1. Clone o repositório:

```bash
git clone https://github.com/geisonbruno/email-microservice
```

2. Execute o comando ```mvn clean install``` Na raiz do projeto, baixar dependências e compilar o código.

3. Execute o comando ```mvn spring-boot:run``` Para iniciar a aplicação.

## Como usar

1. Inicie a aplicação com o maven: ```mvn spring-boot:run```.
2. A _API_ estará disponivel em: http://localhost:8080

- 💡 Com a aplicação em execução, acesse a URL: http://localhost:8080/swagger-ui.html Para explorar a documentação gerada pela Spring Fox.

## API Endpoints

A _API_ fornece os seguintes endpoints:

```markdown
POST /sending-email - Envia um novo e-mail
```
```json
{
    "ownerRef": "guest",
    "emailFrom": "guest@example.com",
    "emailTo": "guest2@example.com",
    "subject": "Testing",
    "text": "Hello, Nice to Meet You! This is my Microservice Email Project."
}
```

```markdown
GET /emails - Lista todos os e-mails já enviados
```

```json
{
    "emailId": "76c6cc80-ea0e-4b46-8d59-45df9078be3f",
    "ownerRef": "Guest",
    "emailFrom": "guest@example.com",
    "emailTo": "guest@example.com",
    "subject": "Testing",
    "text": "Hello, Nice to Meet You! This is my Microservice Email Project.",
    "sendDateEmail": "2025-03-26T11:27:14.930458",
    "statusEmail": "SENT"
}
```