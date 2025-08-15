# AluraForum

## Descrição

O **AluraForum** é uma aplicação backend desenvolvida como parte do desafio do ONE NEXT EDUCATION da Alura & Oracle. O objetivo deste projeto é implementar uma API RESTful que simula um fórum de discussões, permitindo que usuários criem tópicos, respondam a perguntas e interajam em um ambiente organizado por categorias e cursos.

## Funcionalidades

- **Cadastro de Usuários**: Permite que novos usuários se registrem no fórum.
- **Autenticação**: Implementação de login com autenticação baseada em JWT.
- **Gerenciamento de Tópicos**: Criação, listagem, atualização e exclusão de tópicos.
- **Respostas aos Tópicos**: Usuários podem responder aos tópicos criados.
- **Categorias e Cursos**: Organização dos tópicos por categorias e cursos específicos.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.3**
- **Spring Data JPA**
- **Spring Security**
- **JWT (JSON Web Token)**
- **PostgreSQL**
- **BCrypt para criptografia de senhas**
- **Maven como ferramenta de build**

## Como Executar Localmente

### Pré-requisitos

- Java 17 ou superior instalado.
- Maven instalado.
- Banco de dados PostgreSQL configurado.

### Passos

1. Clone este repositório:

   ```bash
   git clone https://github.com/isaacmnss/AluraForum.git
   cd AluraForum
   
2. Configure o banco de dados no arquivo `src/main/resources/application.properties`

    ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/forumalura
    spring.datasource.username=(seu username)
    spring.datasource.password=(sua senha)
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.properties.hibernate.format_sql=true
   ```
   
3. Execute a aplicação
   
    ```bash
   mvn spring-boot:run
   ```
   
4. A API estará disponível em http://localhost:8080.

Endpoints Principais

    * POST/login: Realiza o login e retorna um token JWT

      GET/topicos: Lista todos os tópicos.

      POST/topicos: Cria um novo tópico.

      PUT/topicos/{id}: Atualiza um tópico existente.

      DELETE/topicos/{id}: Deleta um tópico.

