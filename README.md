# MicroservicesCorretor
Microservico para gerenciamento de Corretor 
****
<h2 align="center"> Do Problema: </h2>
<p align="justify"> Para o processo de geração de uma nova oferta de seguros, é necessário verificar se o corretor existe e se ele está ativo. Ao gerar uma nova oferta o corretor informa o número do documento. 
Atualmente temos um serviço que faz a busca de corretor por documento, e retorna todos os seus dados pessoais e um segundo serviço que retorna os dados da situação cadastral do corretor. Precisamos construir uma única API que faça a busca desses dados e faça a validação da situação do corretor (ativo ou inativo) </p>

****
## **Atividades a serem implementadas:** </br>
**Criar uma nova API que:**
1.	Criar serviço que valide se ele está ativo;
2.	Cria um serviço que atualize o status do corretor (opcional).

Resposta da API </br>
Caso o corretor esteja ativo, retornar os seguintes dados: </br>
 •	nome </br>
 •	documento </br>
 •	código </br>
 •	data de criação </br>
 •	Taxa de comissão </br>
 •	Flag ativo </br>
Caso não esteja ativo, retornar uma mensagem de erro de negócio </br>
****

<h4> Rodar/Build via docker: </h4> 

```
docker pull lucianoromero/apimicroservicescrud
docker-compose up -d (Rodar comando na pasta onde o projeto foi clonado, possui o arquivo docker-compose.yml)

```
******
<h4> Documentação Swagger : </h4>

```
http://localhost:8080/v3/api-docs
http://localhost:8080/swagger-ui.html
```
