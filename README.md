# API de Cursos

<div>
    <img alt="GitHub commit activity" src="https://img.shields.io/github/commit-activity/t/guilhermevnbraga/api_cursos">
    <img alt="Último commit" src="https://img.shields.io/github/last-commit/guilhermevnbraga/api_cursos">
    <img alt="Tamanho do repositório" src="https://img.shields.io/github/repo-size/guilhermevnbraga/api_cursos">
    <img alt="Github contributors" src="https://img.shields.io/github/contributors/guilhermevnbraga/api_cursos">
    <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/guilhermevnbraga/api_cursos">
    <img alt="License" src="https://img.shields.io/github/license/guilhermevnbraga/api_cursos">
</div>

## Sobre a API

Uma api fictícia para uma empresa de cursos de programação.

## Funcionalidades

- **CRUD de cursos:** Permite que a empresa liste, crie, atualize e delete cursos.
  
## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **PostgreSQL**

## Rotas

### POST - /cursos
    
    Cria um curso no banco de dados, enviando os campos name e category por meio do body da requisição.
    
### GET - /cursos
    
    Lista todos os cursos salvos no banco de dados.
    
    Também deve é possível realizar uma busca, filtrando os cursos pelo name e category usando query params.
    
### PUT - /cursos/:id
    
    Atualiza um curso pelo id.
    
    O body da requisição deve receber somente o name e/ou category para serem atualizados.
    
### DELETE - /cursos/:id
    
    Remove um curso pelo id.
    
### PATCH - /cursos/:id/active
    
    Essa rota serve para marcar se o curso está ativo ou não, ou seja, um toggle entre true or false.

## Como Executar o Projeto localmente

### Pré-requisitos

- Java Development Kit (JDK) (versão 17 ou superior)
- Maven
- PostgreSQL

### Passos para rodar o projeto localmente

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/guilhermevnbraga/api_cursos.git
   ```

2. **Crie o banco de dados:**

    ```bash
    psql -U postgres
    (sua senha)
    CREATE DATABASE api_cursos;
    ```

3. **Compile e rode a aplicação:**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. **Teste as rotas no postman**
