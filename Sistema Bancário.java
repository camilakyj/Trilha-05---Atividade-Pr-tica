
package dobackofront;

import java.util.Scanner;
import java.util.Locale;

public class SistemaBancarioFuncoes {

    static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    static void exibirMenu() {
        System.out.println("Menu de Opções");
        System.out.println("1. Consultar Saldo");
        System.out.println("2. Realizar Depósito");
        System.out.println("3. Realizar Saque");
        System.out.println("0. Sair");
    }

    static int coletarOpcao() {
        return sc.nextInt();
    }

    static double coletarValor() {
        return sc.nextDouble();
    }

    static double processar(double saldo, int opcao, double valor) {
        if (valor < 0) {
            System.out.println("Valor inválido");
            return saldo;
        }

        if (opcao == 2) {
            saldo += valor;
        } else if (opcao == 3) {
            if (valor > saldo) {
                System.out.println("Saldo insuficiente");
            } else {
                saldo -= valor;
            }
        }

        return saldo;
    }

    static void exibirSaldo(double saldo) {
        System.out.printf(Locale.US,
                "Saldo atual: R$ %.2f%n", saldo);
    }

    static void executarSistema() {
        double saldo = 0;
        int opcao;

        do {
            exibirMenu();
            opcao = coletarOpcao();

            switch (opcao) {
                case 1:
                    exibirSaldo(saldo);
                    break;

                case 2:
                case 3:
                    double valor = coletarValor();
                    saldo = processar(saldo, opcao, valor);
                    break;

                case 0:
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
