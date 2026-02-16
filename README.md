# 🧱 Hexagonal Architecture - Order API

Projeto de exemplo implementando **Arquitetura Hexagonal (Ports & Adapters)** com Spring Boot.

Este projeto demonstra:

- Separação clara entre Domain, Application e Adapters
- Uso de Input e Output Ports
- Isolamento do domínio de frameworks
- Mapeamento entre DTO, Domain e Entity
- Tratamento global de exceções
- Geração de UUID no domínio

---

## 🏗️ Arquitetura

Estrutura do projeto:

```
src/main/java/dev/nerdlab/hexagonal
│
├── domain
│ ├── model
│ ├── repository
│ └── enumerator
│
├── application
│ ├── port.in
│ ├── service
│ └── exception
│
└── adapters
├── inbound
│ ├── web
│ └── dto
└── outbound
└── persistence
```

### 🔄 Fluxo da Aplicação

```
HTTP Request
↓
Controller (Inbound Adapter)
↓
UseCase (Input Port)
↓
Application Service
↓
Domain
↓
Repository Port (Output Port)
↓
Persistence Adapter (JPA)
```

---

## 🚀 Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- Maven

---

## ▶️ Executando o Projeto

```bash
 ./mvnw spring-boot:run
```
Aplicação sobe em:
http://localhost:8080

## 📬 Endpoints
### Criar Pedido

#### POST /orders

```
{
  "total": 350,
  "status": "WAITING_PAYMENT"
}
```
### Exemplo via curl:

```
curl --location 'http://localhost:8080/orders' \
--header 'Content-Type: application/json' \
--data '{
  "total": 350,
  "status": "WAITING_PAYMENT"
}'

```

### Buscar Pedido por ID
#### GET /orders/{id}

```
curl --location 'http://localhost:8080/orders/a5265f91-aff2-4ccb-9791-bee9d564c2f4'
```

## 🧠 Conceitos Aplicados

- Arquitetura Hexagonal
- Separação de camadas 
- Ports & Adapters 
- Domain isolado de framework 
- DTO ↔ Domain ↔ Entity mappers 
- Exceptions específicas na Application
- Global Exception Handler no Adapter

## 📌 Melhorias Futuras

- Introduzir Value Objects
- Implementar testes unitários isolados do domínio
- Adicionar versionamento otimista (@Version)
- Implementar autenticação
- Evoluir para arquitetura orientada a eventos


# 👨‍💻 Autor
### [André Souza ↗](https://www.linkedin.com/in/andre-j-souza/)
### Backend Developer | Java | Spring | Clean Architecture