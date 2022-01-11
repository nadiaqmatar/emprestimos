# Emprestimos
## Avaliação Backend para TQI
### Motivação
Uma empresa de empréstimo precisa criar um sistema de análise de crédito para fornecer aos seus clientes as seguintes funcionalidades:
1. Cadastro de clientes
   O cliente pode cadastrar: nome, e-mail, CPF, RG, endereço completo, renda e senha.
2. Login
   A autenticação será realizada por e-mail e senha.
3. Solicitação de empréstimo
   Para solicitar um empréstimo, precisamos do valor do empréstimo, data da primeira parcela e quantidade de parcelas.
   O máximo de parcelas será 60 e a data da primeira parcela deve ser no máximo 3 meses após o dia atual.
4. Acompanhamento das solicitações de empréstimo
   O cliente pode visualizar a lista de empréstimos solicitados por ele mesmo e também os detalhes de um de seus empréstimos.
   Na listagem, devemos retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.
   No detalhe do empréstimo, devemos retornar: código do empréstimo, valor, quantidade de parcelas, data da primeira parcela, e-mail do cliente e renda do cliente.

### Stack escolhida:
* Java 11
* Gradle
* Spring Framework
* Spring Web
* Spring Data
* Docker
* Lombok

### Arquitetura
Escolhi a arquitetura MVC pela facilidade em organizar os arquivos e implementar o código.

### Como desenvolvi:
Comecei modelando o banco de dados, definindo as entidades: cliente e emprestimo e seu relacionamento. Após isso, escrevi as classes ORM que representam a camada de domínio e as tabelas. Em seguida, escrevi as classes que representam a camada de respositório que são responsáveis pelas operações com o banco de dados. Daí então, escrevi a camada de serviço e coloquei as regras de negócio (restrições de empréstimos) e finalmente escrevi os controllers, responsáveis por expor os endpoints da API.

### Dificuldades
Apesar de já ter ouvido falar do Spring Security, não consegui implementar a camada de segurança.

### Requisitos para executar o projeto
* Mysql
  Deixei na pasta docker um docker-compose com a imagem do mysql.
* Configurar o application.properties com o host user e password do banco.

### Para testar
Deixei na pasta postman a collection para testar a API.