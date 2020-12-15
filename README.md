# Api de agenda de shows para assistir em casa

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://github.com/ajessikafernandes/agenda-de-shows-para-assistir-em-casa/blob/main/LICENSE)

A aplicação foi criada com o intuito de mostrar em tempo real os shows  que estão sendo transmitidos ao vivo nas redes sociais através de lives.

# Tecnologias utilizadas
## Back end
- Java 11
- Spring Boot
- JPA / Hibernate
- Maven

## Front end
- Angular 9
- TypeScript

## Modelo conceitual
![Modelo Conceitual Live](https://github.com/ajessikafernandes/agenda-de-shows-para-assistir-em-casa/blob/develop/assets/Modelo%20conceitual%20-%20Live.jpeg)
# Implantação em produção
- Back end: Heroku

# Como executar o projeto

## Back end
### Pré-requisitos:

  - Java 11
  - Maven
  
### Montando ambiente:

Baixar o projeto usando o comando git clone.

Executando pela linha de comando na pasta da raiz do projeto, crie o jar do projeto:

```
./mvnw clean install
```

Para executar o projeto via terminal, use o comando :

```
java -jar -Dspring.profiles.active=local target/agenda-de-shows-para-assistir-em-casa-0.0.1-SNAPSHOT.jar
```

Para executar os testes unitários, use o comando :

```
./mvnw test
```

### Acesso as collections usando o Postman:

Faça o download do arquivo na pasta resources :
```
API de lives.postman_collection.json
```
Import o arquivo no postman para acessar as collections.

# Autor

Jéssika Fernandes

https://www.linkedin.com/in/ajessikafernandes/


