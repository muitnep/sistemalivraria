# sistemalivraria
Sistema de gerenciamento e emprestimo de livros de biblioteca
# Sistema Livraria
## Descrição do Projeto
O **Sistema Livraria** é uma aplicação destinada ao gerenciamento de livrarias, oferecendo funcionalidades básicas como cadastro de livros, gerenciamento de clientes, venda de livros, e o gerenciamento de inventário. O objetivo é fornecer uma solução simples e eficiente para auxiliar na organização e operação de uma livraria.
## Funcionalidades Principais
- Cadastro de livros com informações detalhadas (título, autor, preço, estoque, etc.).
- Gerenciamento de clientes (informações pessoais e histórico de compras).
- Registro de vendas, com emissão de notas fiscais.
- Controle de inventário (consulta e atualização de estoque).
- Relatórios de vendas e desempenho.

## Tecnologias Utilizadas
Este projeto foi desenvolvido utilizando as seguintes tecnologias:
- **Java 17** (linguagem de programação principal)
- **Jakarta EE** (para APIs REST e funcionalidades empresariais)
- **Spring MVC** (arquitetura e gerenciamento de rotas)
- **Spring Data JPA** (persistência e gerenciamento de banco de dados)
- **Lombok** (para reduzir boilerplate no código)
- **Banco de Dados** (por exemplo: MySQL ou PostgreSQL - configure conforme necessário)

## Pré-requisitos
Para rodar o projeto, você precisará ter instalado:
1. **Java 17** (JDK)
2. **Maven** (gerenciamento de dependências)
3. Um banco de dados configurado (adicione as credenciais no arquivo `application.properties` em `src/main/resources`).
4. Uma IDE compatível com Java (por exemplo, IntelliJ IDEA).

## Como Executar
Siga os passos abaixo para rodar o projeto:
1. Clone este repositório em sua máquina local:
2.    git clone https://github.com/usuario/sistema-livraria.git
3. Configure as credenciais do banco de dados no arquivo `application.properties`:
4.    spring.datasource.url=jdbc:mysql://localhost:3306/sistema_livraria
      spring.datasource.username=SEU_USUARIO
      spring.datasource.password=SUA_SENHA
      spring.jpa.hibernate.ddl-auto=update
5. 1. Certifique-se de que todas as dependências estão instaladas com o Maven:
6.    mvn clean install
7. 1. Execute o projeto:
8. 1. A aplicação estará disponível em: [http://localhost:8080]()

## Estrutura do Projeto
- **Controller**: Contém os endpoints REST.
- **Service**: Contém a lógica de negócios do sistema.
- **Repository**: Gerencia a comunicação com o banco de dados via Spring Data JPA.
- **Model**: Representa as entidades do sistema.
- **Config**: Contém configurações adicionais (ex.: segurança, persistência).