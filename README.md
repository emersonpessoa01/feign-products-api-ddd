# Exercício Avaliativo 5: Arquitetura de Software (DDD - 2 Endpoint)

## 🎯 Objetivo

Criar uma aplicação Spring Boot no padrão DDD que consuma o endpoint de produto por ID da API DummyJSON, utilizando Feign Client, DTOs e validação de parâmetros.

## 📋 Requisitos

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

## 🧪 Avaliação (Critérios)

| Critério                                 | Peso  |
|-------------------------------------------|-------|
| Estrutura do projeto (DDD)                | 40%   |
| Utilização correta do Feign e Controllers | 10%   |
| Criação e uso de DTO                      | 10%   |
| Aplicação de validações                   | 10%   |
| Tratamento de erros                       | 10%   |
| Utilização correta do schedule            | 20%   |

## 💡 Dicas

- Utilize as anotações do Spring e importe as dependências necessárias.
- Utilize o `findAll()` para trazer todos os pedidos do banco.

## Autor

Desenvolvido por **Emerson Pessoa**  
📧 emersonpessoa05102008@gmail.com  
🌐 [linkedin.com/in/emersonpessoa01](https://linkedin.com/in/emersonpessoa01)
