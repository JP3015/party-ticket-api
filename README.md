# 🎟️ Party Ticket API

API REST desenvolvida com Spring Boot para o gerenciamento de eventos, usuários, compras, etc, com autenticação e controle de acesso via JWT. O sistema permite o cadastro de usuários com diferentes papéis (ROLE_USER, ROLE_ADMIN) e oferece segurança nas operações de leitura e escrita.


## 🧰 Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Hibernate / JPA
* MySQL
* Maven


## 📦 Funcionalidades

- Cadastro e login de usuários com autenticação via JWT;
- Diferenciação de permissões por papel (Admin/User);
- Implementação de métodos RESTful (GET, POST, PUT, DELETE);
- CRUD de ingressos e convidados para eventos;
- Validação de capacidade máxima para eventos;
- Tratamento global de exceções (com respostas padronizadas);

## 🔐 Segurança

- Requisições protegidas por token JWT
- Endpoints públicos e protegidos:
- /auth/** → acesso público para login e cadastro
- Demais rotas → requerem autenticação com token
- Filtros personalizados para controle de acesso


## ▶️ Como rodar o projeto localmente

### 1 Clone o repositório:

git clone https://github.com/JP3015/party-ticket-api.git


### 2 Configure o banco de dados MySQL (ex: party_ticket)


### 3 Atualize o application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/party_ticket

spring.datasource.username=seu_usuario

spring.datasource.password=sua_senha

jwt.secret=umasecretkey


### 4 Build do projeto com Maven:

mvn clean install


### Rode o projeto:

```
mvn spring-boot:run

