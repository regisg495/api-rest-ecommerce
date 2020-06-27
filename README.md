# api-rest-ecommerce
Uma API rest de um e-commerce usando spring boot

1 - Configuração

Primeiro, importe o projeto usando sua IDE de preferência.
Você precisa setar suas credenciais do MySQL no arquivo /src/main/resources/application.properties.
Depois, faça o dump do banco de dados com os arquivos data.sql e insert.sql, que estão no root do projeto.

2 - Endpoints

Para melhor visualização de todos os endpoints do projeto, acesse http://localhost:8080/swagger-ui.html.

3 - Permissões

Para execução dos métodos de deletar Post e Put será necessário ter permissão de USER, DBA ou ADM. Para isso, faça login através do endpoint /login, utilizando alguma das credenciais de usuário que já estão salvas (no arquivo insert.sql), o sistema retornará um Token, e para fazer essas requisições de post e put, você precisará inserir o token.
Por fim, para as requisições de Delete é necessário ter permissão de ADMIN.
