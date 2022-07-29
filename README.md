# Tributario-API

API SOAP para integração com o Banco do Brasil para recebimento de pagamentos de tributos.

Exemplo desenvolvido no curso de Spring Boot
de [Michelli Brito](https://www.youtube.com/watch?v=LXRU-Z36GEU&ab_channel=MichelliBrito)

## Criando a imagem docker do projeto
Com o maven instalado, cria uma imagem nomeada springboot/parking-control no contexto atual e remove a imagem antiga.

```shell
  docker build -t springboot/parking-control . 
  docker image prune
```

## Executando o projeto

 ```shell
  docker run -p 8080:8080 springboot/parking-control
```
Teste se o projeto está executando acessando seu endpoint http://localhost:8080/message


## Referências
[Curso de Spring Boot 2022](https://www.youtube.com/watch?v=LXRU-Z36GEU&ab_channel=MichelliBrito) de Michelli Brito

[Dockerizing your Spring Boot Application](https://www.youtube.com/watch?v=e3YERpG2rMs&ab_channel=JavaTechie) by Java Techie
