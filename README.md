# 🚀 Spring Boot & RabbitMQ 

Este repositório contém um laboratório prático de arquitetura de microsserviços focada em **comunicação assíncrona** e **mensageria**, utilizando **Spring Boot**, **RabbitMQ** e **Docker Compose**.

O objetivo do projeto é demonstrar o desacoplamento entre o processo de registo de utilizadores e o envio de e-mails de boas-vindas/notificação.

---

## 🏗️ Arquitetura do Sistema

O fluxo da aplicação funciona da seguinte forma:

1. O cliente faz um pedido `POST` no **User Service** para registar um novo utilizador.
2. O **User Service** guarda o utilizador e publica um evento em JSON na fila do **RabbitMQ**.
3. O **Email Service** (que atua como consumidor autónomo) escuta a fila, recebe a mensagem e dispara o e-mail via SMTP do Gmail.
