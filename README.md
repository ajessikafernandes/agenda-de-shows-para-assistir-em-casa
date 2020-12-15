# Api para agenda de shows para assistir em casa

Os shows são transmitidos ao vivo através das redes sociais através de lives.

# Pré-requisitos:

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

### Acesso a cobertura de testes do Jacoco:

Acesse o arquivo ```index.html``` do Jacoco:
```
target/site/jacoco/index.html
```
Depois execute o arquivo em um browser de sua preferência.