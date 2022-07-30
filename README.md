# Tributario-API

API SOAP para integração com o Banco do Brasil para recebimento de pagamentos de tributos.

Exemplo desenvolvido no curso de Spring Boot
de [Michelli Brito](https://www.youtube.com/watch?v=LXRU-Z36GEU&ab_channel=MichelliBrito)

## Gerar o arquivo .jar da aplicação

Execute a fase maven package para gerar o snapshot da aplicação

## Executando o projeto com docker-compose
Para iniciar o container:
```shell
  docker compose up 
```
Se um novo arquivo jar da app foi gerado, a imagem também precisa ser recriada:
```shell
  docker compose up --build 
```
Para parar o container, removendo o que foi criado

```shell
  docker compose down --rmi all 
```

## Executando o projeto com Docker

Com o Maven instalado, crie uma imagem nomeada springboot/parking-control no contexto atual.
```shell
  docker build -t springboot/parking-control . 
```

Remova a imagem antiga, sem label.
```shell
  docker image prune
```

Inicie o container usando a imagem criada com a app instalada.
 ```shell
  docker run -p 8080:8080 springboot/parking-control
```

Teste se o projeto está executando acessando o endpoint criado na app.

http://localhost:8080/message

## Referências
[Curso de Spring Boot 2022](https://www.youtube.com/watch?v=LXRU-Z36GEU&ab_channel=MichelliBrito) de Michelli Brito

[Dockerizing your Spring Boot Application](https://www.youtube.com/watch?v=e3YERpG2rMs&ab_channel=JavaTechie) by Java Techie
