# Tributario-API

API SOAP para integração com o Banco do Brasil para recebimento de pagamentos de tributos.

Exemplo desenvolvido no curso de Spring Boot
de [Michelli Brito](https://www.youtube.com/watch?v=LXRU-Z36GEU&ab_channel=MichelliBrito)

## Gerar o arquivo .jar da aplicação

Execute a fase maven `package` para gerar o snapshot da aplicação

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

## Testando a aplicação
Teste se o projeto REST está executando acessando o endpoint criado na app.

http://localhost:8080/message

Para testar a app SOAP, acesse

http://localhost:8080/ws/countries.wsdl

Para testar uma requisição SOAP, no Insomnia ou Postman

1. Crie uma nova requisição `POST` e insira a URL do serviço: `http://localhost:8080/ws`
2. Altere o tipo do Body para XML e insira a seguinte requisição:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:art="http://api.tributario.semef.manaus.am.gov.br/soap/ws">
    <soapenv:Header/>
    <soapenv:Body>
        <art:getAllArticlesRequest/>
    </soapenv:Body>
</soapenv:Envelope>
```
3. Defina o Content-Type para text/xml  no Header: 
`Content-Type: text/xml`

O serviço deverá retornar a response com todos os artigos
```xml
<SOAP-ENV:Envelope
        xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getAllArticlesResponse
                xmlns:ns2="http://api.tributario.semef.manaus.am.gov.br/soap/ws">
            <ns2:articleInfo>
                <ns2:articleId>5</ns2:articleId>
                <ns2:title>Update: Spring Boot Getting Started</ns2:title>
                <ns2:category>Update: Spring Boot</ns2:category>
            </ns2:articleInfo>
            <ns2:articleInfo>
                <ns2:articleId>4</ns2:articleId>
                <ns2:title>Angular Tutorial</ns2:title>
                <ns2:category>Angular</ns2:category>
            </ns2:articleInfo>
            <ns2:articleInfo>
                <ns2:articleId>1</ns2:articleId>
                <ns2:title>Java Concurrency</ns2:title>
                <ns2:category>Java</ns2:category>
            </ns2:articleInfo>
        </ns2:getAllArticlesResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

## Referências
[Curso de Spring Boot 2022](https://www.youtube.com/watch?v=LXRU-Z36GEU&ab_channel=MichelliBrito) de Michelli Brito

[Dockerizing your Spring Boot Application](https://www.youtube.com/watch?v=e3YERpG2rMs&ab_channel=JavaTechie) by Java Techie

[Creating a SOAP Web Service with Spring](https://www.baeldung.com/spring-boot-soap-web-service) by Baeldung

[Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/) by Spring

[Spring Boot SOAP Web Service Example](https://www.concretepage.com/spring-boot/spring-boot-soap-web-service-example) by Arvind Rai