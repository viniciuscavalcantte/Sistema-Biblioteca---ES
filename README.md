# Sistema-Biblioteca---ES
Projeto final para disciplina de Engenharia de Software, do curso de Ciência da Computação, da Universidade Federal de Alagoas.
## Funcionalidades

O programa possui as seguintes funcionalidades:

1. **Cadastrar Estudantes**: Permite cadastrar estudantes com nome, CPF e senha.

2. **Cadastrar Livros**: Permite cadastrar livros com título e autor.

3. **Realizar Empréstimos**: Os estudantes podem emprestar livros. O empréstimo é registrado com a data de empréstimo.

4. **Listar Empréstimos**: Exibe uma lista de empréstimos de livros, incluindo informações sobre o livro, estudante e data de empréstimo.

5. **Gerar Relatório**: Gera um relatório que inclui informações sobre atrasos em empréstimos (aqueles com mais de 15 dias).

## Estrutura das Classes

O projeto é organizado em quatro classes principais:

- `Estudante`: Representa um estudante com atributos como ID, nome, CPF e senha.

- `Livro`: Representa um livro com atributos como ID, título e autor.

- `Emprestimo`: Representa um empréstimo de livro, relacionando um estudante, um livro e a data de empréstimo.

- `AppJava`: É a classe principal que contém a lógica do programa. Ela inclui funções para cadastrar estudantes, cadastrar livros, realizar empréstimos, listar empréstimos e gerar relatórios.
- ![Diagrama UML] (https://github.com/viniciuscavalcantte/Sistema-Biblioteca---ES/blob/main/Diagrama%20UML%20ES.png)
