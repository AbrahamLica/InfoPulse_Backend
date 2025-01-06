[JAVASCRIPT__BADGE]: https://img.shields.io/badge/Javascript-000?style=for-the-badge&logo=javascript
[TYPESCRIPT__BADGE]: https://img.shields.io/badge/typescript-D4FAFF?style=for-the-badge&logo=typescript
[EXPRESS__BADGE]: https://img.shields.io/badge/express-005CFE?style=for-the-badge&logo=express
[VUE__BADGE]: https://img.shields.io/badge/VueJS-fff?style=for-the-badge&logo=vue
[NEST__BADGE]: https://img.shields.io/badge/nest-7026b9?style=for-the-badge&logo=nest
[GRAPHQL__BADGE]: https://img.shields.io/badge/GraphQL-e10098?style=for-the-badge&logo=graphql
[JAVA_BADGE]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[MONGO_BADGE]: https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white
[AWS_BADGE]: https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white
[JHIPSTER_BADGE]: https://img.shields.io/badge/JHIPSTER-white?logo=jhipster
[POSTGRE_BADGE]: https://img.shields.io/badge/PostgreSQL-white?logo=postgresql
[SPRINGBOOT_BADGE]: https://img.shields.io/badge/SpringBoot-white?logo=springboot

<h1 align="center" style="font-weight: bold;">InfoPulse 💻</h1>

![java][JAVA_BADGE]
![spring][SPRING_BADGE]
![SPRINGBOOT][SPRINGBOOT_BADGE]
![JHIPSTER][JHIPSTER_BADGE]
![POSTGRESQL][POSTGRE_BADGE]

<p align="center">
 <a href="#started">🚀 Getting Started</a> • 
  <a href="#routes">📍 API Endpoints</a> •
 <a href="#colab">🤝 Collaborators</a> •
</p>

<p align="center">
  <b>📰 InfoPulse - Your Web News System</b>
</p>

<h3>Prerequisites</h3>

🛠 Required Tools:

Java Development Kit (JDK) 17
PostgreSQL 17

<h2 id="started">🚀 Getting started</h2>

1️⃣ Clone the Project

```bash
git clone https://github.com/AbrahamLica/InfoPulse_Backend.git
```

2️⃣ Create the Database
Log into PostgreSQL via the terminal and create a database named infopulse:

```bash
CREATE DATABASE infopulse;
```

3️⃣ Configure Database Credentials
Set your PostgreSQL credentials via environment variables (DB_USERNAME and DB_PASSWORD) or update application-dev.yml directly.

4️⃣ Build the Project
From the project root directory (where pom.xml is located), run:

```bash
mvn clean install
```

5️⃣ Start the Application
Run the application using Maven:

```bash
mvn spring-boot:run
```

<h2 id="routes">📍 API Endpoints</h2>

| Route                             | Description                                                                |
| --------------------------------- | -------------------------------------------------------------------------- |
| <kbd>GET</kbd> /api/authenticate  | Retrieves user info. See [response details](#get-auth-detail).             |
| <kbd>POST</kbd> /api/authenticate | Authenticates user into the API. See [request details](#post-auth-detail). |

**Example (POST /api/authenticate):**

```json
{
  "username": "User's username for authentication",
  "password": "User's password"
}
```

---

### 👤 **Users**

| Route                                  | Description               |
| -------------------------------------- | ------------------------- |
| <kbd>GET</kbd> /api/usuarios           | Retrieves all users.      |
| <kbd>POST</kbd> /api/v1/usuarios       | Creates a new user.       |
| <kbd>PATCH</kbd> /api/v1/usuarios/{id} | Updates an existing user. |

**Example (POST /api/v1/usuarios):**

```json
{
  "nome": "User's name",
  "login": "User's login",
  "email": "User's email (must match [^@\\s]+@[^@\\s]+\\.[^@\\s]+$)",
  "senha": "User's password"
}
```

**Example (PATCH /api/v1/usuarios/{id}):**

```json
{
  "id": 1,
  "nome": "New user name",
  "email": "newemail@example.com",
  "login": "new_user_login",
  "user": { "id": 1 },
  "ativo": true
}
```

---

### 🗂 **Categories**

| Route                                  | Description                   |
| -------------------------------------- | ----------------------------- |
| <kbd>GET</kbd> /api/categorias         | Retrieves all categories.     |
| <kbd>POST</kbd> /api/categorias        | Creates a new category.       |
| <kbd>PUT</kbd> /api/categorias/{id}    | Updates an existing category. |
| <kbd>DELETE</kbd> /api/categorias/{id} | Deletes a category by ID.     |

**Example (POST /api/categorias):**

```json
{
  "nome": "Category name",
  "descricao": "Category description"
}
```

**Example (PUT /api/categorias/{id}):**

```json
{
  "id": "Category ID to update",
  "nome": "Updated category name",
  "descricao": "Updated category description"
}
```

---

### 📰 **News**

| Route                                | Description                       |
| ------------------------------------ | --------------------------------- |
| <kbd>GET</kbd> /api/noticias         | Retrieves all news articles.      |
| <kbd>POST</kbd> /api/noticias        | Creates a new news article.       |
| <kbd>PUT</kbd> /api/noticias/{id}    | Updates an existing news article. |
| <kbd>DELETE</kbd> /api/noticias/{id} | Deletes a news article by ID.     |

**Example (POST /api/noticias):**

```json
{
  "titulo": "News title (min 5 characters)",
  "conteudo": "Full news content",
  "resumo": "News summary",
  "dataPublicacao": "ISO 8601 format date",
  "autor": "Author (min 2 characters)",
  "ativo": true,
  "categoria": { "id": "Category ID" }
}
```

**Example (PUT /api/noticias/{id}):**

```json
{
  "id": "News ID to update",
  "titulo": "Updated news title",
  "conteudo": "Updated full content",
  "resumo": "Updated summary",
  "dataPublicacao": "Updated ISO 8601 format date",
  "autor": "Updated author",
  "ativo": true,
  "categoria": { "id": "Category ID" }
}
```

---

### 🔧 Notes

- Use the correct HTTP methods as specified in each route.
- Replace `{id}` with the appropriate resource ID in the URL.
