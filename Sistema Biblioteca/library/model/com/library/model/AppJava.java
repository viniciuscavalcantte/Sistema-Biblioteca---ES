package com.library.model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AppJava {
    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<>();
        List<Estudante> estudantes = new ArrayList<>();
        List<Emprestimo> emprestimos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSistema de Biblioteca");
            System.out.println("1. Cadastrar Estudante");
            System.out.println("2. Listar Estudantes");
            System.out.println("3. Cadastrar Livro");
            System.out.println("4. Listar Livros");
            System.out.println("5. Listar Empréstimos");
            System.out.println("6. Gerar Relatório de Leituras e Atrasos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro válido.");
                scanner.next(); // Limpe a entrada inválida
                continue; // Volte ao início do loop
            }

            switch (opcao) {
                case 1:
                    // Cadastro de Estudante
                    System.out.print("Nome do estudante: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF do estudante (11 dígitos numéricos): ");
                    String cpf = scanner.nextLine();

                    System.out.print("Senha de 6 dígitos numéricos: ");
                    String senha = scanner.nextLine();

                    if (cpf.matches("\\d{11}") && senha.matches("\\d{6}")) {
                        int novoId = estudantes.size() + 1;
                        Estudante novoEstudante = new Estudante(novoId, nome, cpf, senha);
                        estudantes.add(novoEstudante);
                        System.out.println("Estudante cadastrado com sucesso.");
                    } else {
                        System.out.println("CPF e/ou senha inválidos. O CPF deve conter 11 dígitos e a senha deve conter 6 dígitos numéricos.");
                    }
                    break;

                    case 2:
                    // Listar Estudantes
                    System.out.println("\nLista de Estudantes:");
                    if (estudantes.isEmpty()) {
                        System.out.println("Nenhum estudante cadastrado.");
                    } else {
                        for (Estudante estudante : estudantes) {
                            System.out.println("ID: " + estudante.getId());
                            System.out.println("Nome: " + estudante.getNome());
                            System.out.println("CPF: " + estudante.getCpf());
                            System.out.println("Senha: " + estudante.getSenha());
                            System.out.println();
                        }
                    }
                    break;
                

                case 3:
                    // Cadastro de Livro
                    System.out.print("Título do livro: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor do livro: ");
                    String autor = scanner.nextLine();

                    int novoLivroId = livros.size() + 1;
                    Livro novoLivro = new Livro(novoLivroId, titulo, autor);
                    livros.add(novoLivro);
                    System.out.println("Livro cadastrado com sucesso.");
                    break;

                case 4:
                    // Listar Livros
                    System.out.println("\nLista de Livros:");
                    for (Livro livro : livros) {
                        System.out.println("ID: " + livro.getId());
                        System.out.println("Título: " + livro.getTitulo());
                        System.out.println("Autor: " + livro.getAutor());
                        System.out.println();
                    }
                    break;

                case 5:
                    // Listar Empréstimos
                    System.out.println("\nLista de Empréstimos:");
                    for (Emprestimo emprestimo : emprestimos) {
                        Livro livro = emprestimo.getLivro();
                        Estudante estudante = emprestimo.getEstudante();
                        Date dataEmprestimo = emprestimo.getDataEmprestimo();
                        System.out.println("Livro: " + livro.getTitulo());
                        System.out.println("Estudante: " + estudante.getNome());
                        System.out.println("Data de Empréstimo: " + new SimpleDateFormat("dd/MM/yyyy").format(dataEmprestimo));
                        System.out.println();
                    }
                    break;

                case 6:
                    // Gerar Relatório de Leituras e Atrasos
                    gerarRelatorio(emprestimos);
                    break;

                case 7:
                    System.out.println("Saindo do sistema.");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerarRelatorio(List<Emprestimo> emprestimos) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("\nRelatório de Leituras e Atrasos:");
        for (Emprestimo emp : emprestimos) {
            Livro livro = emp.getLivro();
            Estudante estudante = emp.getEstudante();
            Date dataEmprestimo = emp.getDataEmprestimo();
            Date dataAtual = new Date();
            long diasAtraso = calcularDiasAtraso(dataEmprestimo, dataAtual);

            System.out.println("Livro: " + livro.getTitulo());
            System.out.println("Estudante: " + estudante.getNome());
            System.out.println("Data de Empréstimo: " + sdf.format(dataEmprestimo));

            if (diasAtraso > 15) {
                System.out.println("Atraso: " + diasAtraso + " dias");
            } else {
                System.out.println("Dias de Empréstimo: " + diasAtraso + " dias");
            }

            System.out.println();
        }
    }

    private static long calcularDiasAtraso(Date dataEmprestimo, Date dataAtual) {
        long diferenca = dataAtual.getTime() - dataEmprestimo.getTime();
        return diferenca / (24 * 60 * 60 * 1000);
    }
}
