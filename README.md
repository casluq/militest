<h1>Como Rodar</h1> 

## Como rodar a aplicação :arrow_forward:

No terminal, clone o projeto: 

```
git clone https://github.com/casluq/militest
```

Abra o terminal na pasta do projeto e utilize o comando:

```
./mvnw clean spring-boot:run
```

## Endpoints disponíveis :

GET:     localhost:8080/produto/produto-mais-caro \
GET:     localhost:8080/produto/media-preco-sem-desconto \
GET:     localhost:8080/produtos \
POST:    localhost:8080/produto \
PUT:     localhost:8080/produto/:ID \
DELETE:  localhost:8080/produto/:ID \