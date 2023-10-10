## Fuel Control

Essa API permite ao usuário o controle da sua frota e a previsão de gastos com combustível dos veículos cadastrados.

---
**Configurações para execução:**

- **Execução a partir do Docker**

  * Se posicionar na raiz do projeto e executar os comandos abaixo:
    * `mvn clean package`
    * `docker build --tag=fuel-control:latest .`
    * `docker run -p8080:8888 fuel-control:latest`

- **Execução a partir do Jar**
  * Se posicionar na raiz do projeto e executar os comandos abaixo:
  * `mvn clean package`
  * `java -jar target/fuel-control-0.0.1-SNAPSHOT.jar`
  
-----

* Todas os endpoints e payloads podem ser acessados
  1. Através do Swagger;
     * Com a aplicação em execução, acessar: `http://localhost:8080/swagger-ui/index.html`
  2. Através da importação via Postman do arquivo `fuel-control.postman_collection.json`, localizado na raiz do projeto.

----

**Características da API**

- Ela foi desenvolvida utilizando Java 17 e o framework Spring 3.1.4
- Entre as bibliotecas utilizadas estão
  * Lombok
  * Flyway 9.22.2
  * H2 2.2.224

- A versão atual possui o básico necessário para cumprir sua finalidade:
  * Possui um CRUD (Create, Read, Update, Delete) especializado para o controle da frota;
  * Possui um endpoint que entrega uma lista dos veículos ranqueados pela sua performace nos custos;
  * Possui uma estrutura básica de gravação em memória do banco de dados;
  * Possui migrations para o banco ser atualizado com 3 cadastros de veículos; 
  * Possui uma proposta para o tratamento de Exceptions;
  * Possui versionamento, permitindo que novos códigos sejam implementados sem prejudicar implementações anteriores;

