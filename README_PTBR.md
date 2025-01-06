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
 <a href="#iniciando">🚀 Iniciando</a> • 
  <a href="#rotas">📍 Endpoints da API</a> •
 <a href="#colaboradores">🤝 Colaboradores</a> •
</p>

<p align="center">
  <b>📰 InfoPulse - Seu Sistema de Notícias Web</b>
</p>

<h2>📖 Sobre</h2>

Este é um **Sistema de Notícias Web** que permite aos usuários **criar, ler, atualizar e deletar artigos de notícias** (CRUD), gerenciar categorias e acessar recursos adicionais. 📚 O projeto foi desenvolvido para aprimorar e demonstrar minhas habilidades como **Desenvolvedor Fullstack**. 🚀

Além disso, este sistema integra-se a uma API externa chamada <a href="https://worldnewsapi.com/" target="_blank">World News API</a>, permitindo que o sistema exiba notícias globais que não foram adicionadas por usuários da plataforma. Esse recurso garante que o sistema não esteja limitado a notícias locais cadastradas, mas também forneça aos usuários acesso a notícias do mundo todo. 🌍

<h2>🛠️ Desenvolvido com</h2>

Este projeto foi desenvolvido com as seguintes tecnologias:

- ☕ **Java** – Linguagem de programação principal usada para desenvolver a lógica do backend da aplicação, garantindo escalabilidade e robustez.  
- 🚀 **Spring Boot** – Framework utilizado para construir uma API RESTful, possibilitando o desenvolvimento rápido e seguro de operações no lado do servidor.  
- 🛠️ **JHipster** – Ferramenta usada para gerar e configurar rapidamente o projeto, agilizando a configuração inicial e oferecendo ferramentas poderosas para desenvolvimento.  
- 🗄️ **PostgreSQL** – Sistema de banco de dados relacional confiável usado para armazenar e gerenciar todos os dados da aplicação de forma eficiente.  
- 🔄 **Liquibase** – Facilita o controle de versão e gerenciamento do esquema do banco de dados, garantindo atualizações e migrações contínuas.  

<h3>📋 Pré-requisitos</h3>

🛠 Ferramentas necessárias:

- Java Development Kit (JDK) 17 <br>
- PostgreSQL 17  

<h2 id="iniciando">🚀 Iniciando</h2>

1️⃣ Clone o projeto:

```bash
git clone https://github.com/AbrahamLica/InfoPulse_Backend.git
```

2️⃣ Crie o banco de dados
Acesse o PostgreSQL pelo terminal e crie um banco de dados chamado infopulse:

```bash
CREATE DATABASE infopulse;
```

3️⃣ Configure as credenciais do banco de dados
Defina suas credenciais do PostgreSQL através de variáveis de ambiente (DB_USERNAME e DB_PASSWORD) ou atualize o arquivo application-dev.yml diretamente.

4️⃣ Compile o projeto
Na raiz do projeto (onde o arquivo pom.xml está localizado), execute:

```bash
mvn clean install
```

5️⃣ Inicie a aplicação
Execute a aplicação usando o Maven:

```bash
mvn spring-boot:run
```

<h2 id="routes">📍 Endpoints da API</h2>

| Route                             | Description                                                                |
| --------------------------------- | -------------------------------------------------------------------------- |
| <kbd>GET</kbd> /api/authenticate  | Recupera informações do usuário..                                          |
| <kbd>POST</kbd> /api/authenticate | Autentica o usuário na API.                                                |

**Exemplo (POST /api/authenticate):**

```json
{
  "username": "Usuário para autenticação",
  "password": "Senha do usuário"
}
```

---

### 👤 **Usuários**

| Route                                  | Description                  |
| -------------------------------------- | -------------------------    |
| <kbd>GET</kbd> /api/usuarios           | Recupera todos os usuários   |
| <kbd>POST</kbd> /api/v1/usuarios       | Cria um novo usuário         |
| <kbd>PATCH</kbd> /api/v1/usuarios/{id} | Atualiza um usuário existente|

**Exemplo (POST /api/v1/usuarios):**

```json
{
 "nome": "Nome do usuário",
  "login": "Login do usuário",
  "email": "Email do usuário",
  "senha": "Senha do usuário"
}
```

**Exemplo (PATCH /api/v1/usuarios/{id})::**

```json
{
   "id": 1,
  "nome": "Novo nome do usuário",
  "email": "novoemail@example.com",
  "login": "novo_login",
  "ativo": true
}
```

---

### 🗂 **Categories**

| Route                                  | Description                      |
| -------------------------------------- | -----------------------------    |
| <kbd>GET</kbd> /api/categorias         | Recupera todas as categorias.    |
| <kbd>POST</kbd> /api/categorias        | Cria uma nova categoria.         |
| <kbd>PUT</kbd> /api/categorias/{id}    | Atualiza uma categoria existente.|
| <kbd>DELETE</kbd> /api/categorias/{id} | Deleta uma categoria pelo ID.    |

**Exemplo (POST /api/categorias):**

```json
{
  "nome": "Nome da categoria",
  "descricao": "Descrição da categoria"
}
```

**Exemplo (PUT /api/categorias/{id}):**

```json
{
  "id": "ID da categoria a ser atualizada",
  "nome": "Novo nome da categoria",
  "descricao": "Nova descrição da categoria"
}
```

---

### 📰 **Notícias**

| Route                                | Description                       |
| ------------------------------------ | --------------------------------- |
| <kbd>GET</kbd> /api/noticias         | Recupera todas as notícias.       |
| <kbd>POST</kbd> /api/noticias        | Cria uma nova notícia.            |
| <kbd>PUT</kbd> /api/noticias/{id}    | Atualiza uma notícia existente.   |
| <kbd>DELETE</kbd> /api/noticias/{id} | Deleta uma notícia pelo ID.       |

**Exemplo (POST /api/noticias):**

```json
{
 "titulo": "Título da notícia",
  "conteudo": "Conteúdo completo da notícia",
  "resumo": "Resumo da notícia",
  "dataPublicacao": "Data no formato ISO 8601",
  "autor": "Autor da notícia",
  "ativo": true,
  "categoria": { "id": "ID da categoria" }
}
```

**Exemplo (PUT /api/noticias/{id}):**

```json
{
   "id": "ID da notícia a ser atualizada",
  "titulo": "Novo título da notícia",
  "conteudo": "Novo conteúdo completo",
  "resumo": "Novo resumo",
  "dataPublicacao": "Nova data no formato ISO 8601",
  "autor": "Novo autor",
  "ativo": true,
  "categoria": { "id": "ID da categoria" }
}
```

---

### 🔧 Observações

- Use os métodos HTTP corretos conforme especificado em cada rota.
- Substitua {id} pelo ID apropriado no URL.


<h2>👥 Autores & Colaboradores</h2>

O setup original deste repositório é de

<div align="center">
  <img src="src/assets/me.jpg" alt="Abraham Melquisedeque Pereira Licá" style="border-radius: 50%; width: 200px; object-fit: cover;">
  <br>
  Abraham Melquisedeque Pereira Licá
</div>

<h2>🔒 Segurança</h2>

InfoPulse segue boas práticas de segurança, mas não é possível garantir 100% de segurança.
InfoPulse é fornecido "como está" sem qualquer garantia. Use por sua conta e risco. ⚠️

Para mais informações e para reportar problemas de segurança, consulte nossa documentação de segurança.

<h2>📜 Licença</h2>

Este projeto está licenciado sob a licença MIT. 📜

Consulte [LICENSE](LICENSE) para mais informações.

