
package dobackofront;

import java.util.Scanner;

public class ControleEstoqueFuncoes {

    static Scanner sc = new Scanner(System.in);

    static String[] produtos = new String[1000];
    static int[] quantidades = new int[1000];
    static int total = 0;

    static void exibirMenu() {
        System.out.println("Menu de Opções");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Realizar entrada no estoque");
        System.out.println("3. Realizar saída no estoque");
        System.out.println("4. Listar estoque");
        System.out.println("0. Sair");
    }

    static int coletarOpcao() {
        return sc.nextInt();
    }

    static String coletarNome() {
        sc.nextLine();
        return sc.nextLine();
    }

    static int coletarQuantidade() {
        return sc.nextInt();
    }

    static void adicionarProduto(String nome, int quantidade) {
        if (total >= 1000) {
            System.out.println("Limite de produtos atingido");
            return;
        }

        if (quantidade < 0) {
            System.out.println("Quantidade inválida");
            return;
        }

        produtos[total] = nome;
        quantidades[total] = quantidade;
        total++;

        System.out.println("Produto adicionado com sucesso!");
    }

    static void movimentarEstoque(int opcao, int produto, int quantidade) {
        if (produto < 1 || produto > total || quantidade <= 0) {
            System.out.println("Dados inválidos");
            return;
        }

        int indice = produto - 1;

        if (opcao == 2) {
            quantidades[indice] += quantidade;
            System.out.println("Entrada realizada com sucesso!");
        } else {
            if (quantidade > quantidades[indice]) {
                System.out.println("Estoque insuficiente");
            } else {
                quantidades[indice] -= quantidade;
                System.out.println("Saída realizada com sucesso!");
            }
        }
    }

    static void listarEstoque() {
        if (total == 0) {
            System.out.println("Nenhum produto cadastrado");
            return;
        }

        System.out.println("Estoque atual:");

        for (int i = 0; i < total; i++) {
            System.out.println("Produto " + (i + 1) + ": " +
                    produtos[i] + " - " + quantidades[i] + " unidades");
        }
    }

    static void executarSistema() {
        int opcao;

        do {
            exibirMenu();
            opcao = coletarOpcao();

            switch (opcao) {
                case 1:
                    if (total >= 1000) {
                        System.out.println("Limite de produtos atingido");
                    } else {
                        String nome = coletarNome();
                        int quantidade = coletarQuantidade();
                        adicionarProduto(nome, quantidade);
                    }
                    break;

                case 2:
                case 3:
                    if (total == 0) {
                        System.out.println("Nenhum produto cadastrado");
                    } else {
                        int produto = sc.nextInt();
                        int quantidade = coletarQuantidade();

                        movimentarEstoque(opcao, produto, quantidade);
                    }
                    break;

                case 4:
                    listarEstoque();
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 0);
    }

    public static void main(String[] args) {
        executarSistema();
        sc.close();
    }
}
