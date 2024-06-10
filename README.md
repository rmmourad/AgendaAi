# AgendaAi

## Microserviços usando Java 21 & Spring

### Depêndencias/Requisitos

- java 21

- Postgres

- Spring 3.3.0
  
  - Spring Web
  
  - PostgreSQL Driver
  
  - Spring Data JPA
  
  - Lombok
  
  - Validation
    
    

### Como rodar

##### vscode

Com jdk 21 instalado no sistema, instale as extensões [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

[Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) uma vez esses instalados é possivel executar o projeto clicando no ícone com titulo Run no canto superior do vscode. Caso não apareça tente reiniciar ou selecionar o arquivo Main, presente na root do pacote principal.



##### Conexão com o Postgres

Dentro da pasta _resources_ existe um arquivo chamado application.properties

configure ele para as informações presentes na sua máquina.

Informe seu nome de usuario do postgres e a senha para conectar com ele. Dentro do PGAdmin crie uma tabela com o nome _ms-customer_. Não é necessario adicionar nenhuma coluna ou propriedade já que isso é feito de forma automatica.

```java
spring.application.name=customer

server.port=8081

spring.datasource.url=jdbc:postgresql://localhost:5432/ms-customer 
spring.datasource.username=postgres
spring.datasource.password=senha123

spring.jpa.hibernate.ddl-auto=update
```

### Testes

É possível integrar o backend a algum front atráves de linguagens e fazer requisições usando fetch, entretanto
também é possivel usar o [Postman](https://www.postman.com/downloads/) (Baixe a versão para desktop para acessar localhost). 

- Selecione o método HTTP desejado (Apenas Post, Get, Put, Delete são suportados atualmente).
- Informe a url "http://localhost:808x/customers"
- Clique em Body e vá em Raw
- Escreva um json baseado no que deseja inserir ou alterar.

> Se tanto o cliente quanto o servidor estiverem rodando na mesma máquina, é possível que você enfrente erros de [CORS](https://pt.wikipedia.org/wiki/Cross-origin_resource_sharing).
> É possível contorna-los através de um novo tipo de arquivo [configuration](https://cursos.alura.com.br/forum/topico-cors-113963) e rodando o seu cliente em um servidor HTTP. Um jeito prático é em python:

```console
cd E:\MSAGENDAAI\html\
python -m http.server 3000
```