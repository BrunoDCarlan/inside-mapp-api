# InsideMapp - Backend

Este repositório contém o backend do projeto **InsideMapp**, construído com **Spring Boot** e **PostgreSQL**, com foco em acessibilidade, navegação e localização em ambientes internos (shoppings, eventos, faculdades etc.).

---

## 🛠️ Tecnologias utilizadas

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok
- Swagger / OpenAPI
- Postman

---

## 🧱 Estrutura do Projeto

```
com.insidemapp.backend
│
├── user/
│   ├── controller
│   ├── dto
│   ├── model
│   ├── repository
│   └── service
│
├── estabelecimento/
├── navegacao/
├── infra/
│   ├── config
│   ├── exception
│   ├── security
│   └── common
```

---

## 🧠 Funcionalidades até o momento

### ✅ Entidades implementadas:
- `User` (com criação e listagem)
- `Estabelecimento`
- `Andar`
- `Mapa`
- `Categoria`
- `PontoInteresse`
- `Rota`
- `Favorito`
- `Compartilhamento`

### ✅ Funcionalidades:
- Criação e listagem de usuários via API
- Mapeamento JPA de todas as entidades
- Conexão com PostgreSQL
- Testes via Postman
- Controle de tabelas e correções com pgAdmin
- Estrutura limpa e modularizada por domínio

---

## 💾 Conexão com PostgreSQL

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/insidemapp
    username: postgres
    password: admin
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

Banco: `insidemapp`  
Usuário: `postgres`  
Senha: `admin`

---

## 🔁 Requisição POST para criar usuário

```
POST /api/users
Content-Type: application/json
```

```json
{
  "username": "bruno",
  "email": "bruno@email.com",
  "senhaHash": "123456",
  "tipo": "usuario",
  "criadoEm": "2025-05-15T23:59:00"
}
```

---

## 🧪 Testes

Utilizado **Postman** para:

- Criar e listar usuários
- Verificar respostas da API
- Simular fluxos reais de uso

---

## 🐘 PostgreSQL e pgAdmin

- Banco criado manualmente via pgAdmin
- Corrigido uso da palavra reservada `user`
- Queries usadas:

```sql
ALTER TABLE "user" RENAME TO usuario;
DROP TABLE IF EXISTS "user";
```

---

## 🐳 Docker (início da preparação)

Criado `docker-compose.yml` para subir PostgreSQL com:

```yaml
image: postgres:16
environment:
  POSTGRES_DB: insidemapp
  POSTGRES_USER: postgres
  POSTGRES_PASSWORD: admin
```

Execução prevista: `docker compose up -d` (pendente instalação funcional no sistema).

---

## 📅 Última atualização

16/05/2025

---

## ✨ Próximos passos sugeridos

- Autenticação com JWT
- CRUD completo para todas as entidades
- Deploy com Docker + Render/Railway
- Integração com frontend (React/React Native)
