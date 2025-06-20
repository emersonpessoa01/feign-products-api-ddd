# Exercício Avaliativo 5: Arquitetura de Software (DDD - 2 Endpoint)


## Topo

## 📌 Tabela de Conteúdos


- [Testes com Insomnia](#testes-com-insomnia)
- [Objetivo](#objetivo)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Executar o Projeto](#como-executar-o-projeto)
- [Funcionalidades Implementadas](#funcionalidades-implementadas)
- [Validações e Tratamento de Erros](#validações-e-tratamento-de-erros)
- [Métricas e Logs](#métricas-e-logs)
- [Critérios de Avaliação](#critérios-de-avaliação)
- [Autor](#autor)
- [Requisitos](#requisitos)


## Testes com Insomnia

Esta API pode ser testada diretamente com o Insomnia. Importando a collection, você terá os endpoints `/ping` e `/products` já configurados com exemplos válidos e inválidos.

- ProductRequestDTO: `/products`
```
{
  "category": "smartphones",
  "price": 600,
  "stock": 20
}
```

- Endpoint de Pedido: `/order`
```
{
  "productId": 121,
  "quantity": 2,
  "category": "smartphones"
}
```
- Testar erros de validações (400 Bad Request): `/products`
```
{
  "category": "smartphones",
  "price": 100
}
```
- Testar erro de lógica (404 Not Found): `/products`
```
{
  "category": "smartphones",
  "price": 1,
  "stock": 1
}

```

[🔝 Voltar ao topo](#topo)

## Objetivo

Criar uma aplicação Spring Boot no padrão DDD que consuma o endpoint de produto por categoria da API DummyJSON, utilizando Feign Client, DTOs, validação de parâmetros e banco H2.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.2+
- Spring Data JPA
- H2 Database
- Spring Cloud OpenFeign
- Bean Validation
- SLF4J (Logger)
- Scheduler com `@Scheduled`

[🔝 Voltar ao topo](#topo)

## Estrutura do Projeto

```
src/main/java
├── api/            # Controllers e DTOs
├── application/    # Casos de uso e serviços
├── domain/         # Entidades (Order)
├── infrastructure/ # FeignClient, Repositórios e Scheduler
```

[🔝 Voltar ao topo](#topo)

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/emersonpessoa01/feign-products-api-ddd
   ```

2. Navegue até a pasta:
   ```bash
   cd feign-products-api-ddd
   ```

3. Execute:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse a H2 Console:
   ```
   http://localhost:8081/h2-console
   ```

[🔝 Voltar ao topo](#topo)

## Funcionalidades Implementadas

- `POST /products`: Retorna produtos da categoria filtrando por preço máximo e estoque mínimo.
- `POST /order`: Cria pedido validando existência do produto e estoque.
- Agendador que imprime o total de pedidos a cada 10 segundos.
- DTOs, validações e separação por camadas (DDD).

[🔝 Voltar ao topo](#topo)

## Validações e Tratamento de Erros

- Campos obrigatórios validados com `@NotNull` e `@Min`.
- Produto inexistente ou com estoque insuficiente retornam erro 400 com mensagem amigável.
- Lançamento de exceções customizadas.

[🔝 Voltar ao topo](#topo)

## Métricas e Logs

- Tempo de execução da busca de produtos é logado com precisão em milissegundos.
- Logs de agendamento são emitidos com o total de pedidos.
- Nível de log configurável via `application.properties`.

[🔝 Voltar ao topo](#topo)

## Critérios de Avaliação

| Critério                                 | Peso  |
|-------------------------------------------|-------|
| Estrutura do projeto (DDD)                | 40%   |
| Utilização correta do Feign e Controllers | 10%   |
| Criação e uso de DTO                      | 10%   |
| Aplicação de validações                   | 10%   |
| Tratamento de erros                       | 10%   |
| Utilização correta do schedule            | 20%   |

## Autor

Desenvolvido por **Emerson Pessoa**  
📧 emersonpessoa05102008@gmail.com  
🌐 [linkedin.com/in/emersonpessoa01](https://linkedin.com/in/emersonpessoa01)

[🔝 Voltar ao topo](#topo)


## Requisitos

1. **Feign Client**  
   Implemente um FeignClient para consumir:  

GET https://dummyjson.com/products/{category}

O cliente deve se chamar `ProductClient` e estar separado em um pacote apropriado.

2. **DTOs**  
- Crie um `ProductRequestDTO` com os campos de entrada:
  ```
  public class ProductRequestDTO {
      private double price;
      private int stock;
      private String category;
  }
  ```
- Crie uma lista de `PedidoRequestDTO` com os campos de entrada:
  ```
  public class PedidoRequestDTO {
      private int quantity;
      private int productId;
  }
  ```
- Crie um `ProductResponseDTO` com os campos relevantes do JSON retornado:
  ```
  public class ProductResponseDTO {
      private int id;
      private String title;
      private String description;
      private double price;
      private double rating;
      private int stock;
      private String brand;
      private String category;
  }
  ```

3. **Validação**  
- No endpoint de produtos, mantenha as validações do exercício anterior.
- No endpoint de pedidos, valide a quantidade, se o produto existe e se existe estoque suficiente para o pedido.

4. **Use Cases**  
- Crie use cases para buscar os produtos conforme o exercício anterior.
- Crie ao menos 2 UseCases para buscar o produto via POST e um para o novo POST de pedidos.
- O método deve chamar o FeignClient e repassar a categoria.
- Após buscar os produtos, filtre pelo preço máximo e pelo estoque.

5. **Repository**  
- Salve os pedidos gerados em um banco H2, com campos e formatos adequados.

6. **Schedule**  
- Crie um schedule que rode de 10 em 10 segundos, buscando no banco os pedidos e somando o total de todos os pedidos, printando esse total nos logs.

7. **Controller**  
- Endpoint:
  ```
  POST /products
  ```
  Retorna uma lista de `ProductResponseDTO` dos produtos correspondentes.
  Valide a entrada usando `@RequestBody` com validação.
  Exemplo de resposta:
  ```
  [
    {
      "id": 1,
      "title": "iPhone 9",
      "description": "An apple mobile which is nothing like apple",
      "price": 549,
      "rating": 4.69,
      "stock": 94,
      "brand": "Apple",
      "category": "smartphones"
    }
  ]
  ```
- Endpoint:
  ```
  POST /order
  ```
  Retorne confirmação de pedido criado com sucesso.
  Valide a entrada usando `@RequestBody` com validação.
  Exemplo de resposta:
  ```
  [
    { "orderId": 1 }
  ]
  ```

8. **Tratamento de Erros**  
- Mantenha o tratamento para produto.
- Para pedido, caso não haja estoque suficiente, retorne 400 com mensagem amigável.

9. **Logs**  
- Crie mecanismo para printar o tempo da requisição.

[🔝 Voltar ao topo](#topo)