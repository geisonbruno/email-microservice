# Email Microservice


***
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

# Sobre o projeto

Este microsserviço foi desenvolvido para centralizar o envio de e-mails para qualquer serviço dentro de uma arquitetura de microsserviços. Utilizando o framework Spring Boot junto com Spring Email, ele oferece uma solução eficiente para o gerenciamento de comunicações por e-mail.

Inicialmente, o microsserviço foi configurado para operar com SMTP do Gmail, processando as requisições de forma síncrona por meio de uma API REST. Com o objetivo de aumentar e expandir meus conhecimentos e suportar demandas escaláveis, ele foi evoluído para um modelo mais avançado, passando a utilizar AWS-SES para o envio de e-mails e RabbitMQ para o processamento assíncrono de mensagens.

Tive experiência prática nesse projeto de estudo, evoluindo o microsserviço de e-mail desde sua configuração inicial até sua evolução para um modelo escalável e orientado a eventos.

## Sumário 
***
- [Instalação](#instalação)
- [Como usar](#como-usar)
- [API Endpoints](#api-endpoints)

## Tecnologias usadas
***

- Java 17
- Sring boot
- AWS-SES
- RabbitMQ
- MySQL
- Gmail SMTP
- Maven
- Spring Fox / Spring Doc (Swagger Documentation)

## Instalação
***
1. Clone o repositório:

```bash
git clone https://github.com/geisonbruno/Email-Microservice
```

2. Execute o comando ```mvn clean install``` Na raiz do projeto, baixar dependências e compilar o código.

3. Execute o comando ```mvn spring-boot:run``` Para iniciar a aplicação.

## Como usar
***

1. Inicie a aplicação com o maven: ```mvn spring-boot:run```.
2. A _API_ estará disponivel em: http://localhost:8080

- 💡 Com a aplicação em execução, acesse a URL: http://localhost:8080/swagger-ui.html Para explorar a documentação gerada pela Spring Fox.

## API Endpoints
***
A _API_ fornece os seguintes endpoints:

```markdown
POST /sending-email - Envia um novo e-mail

GET /emails - Lista todos os e-mails já enviados
```
