
package dobackofront;

import java.util.Scanner;
import java.util.Locale;

public class Acaiteria {

    static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    static double[] coletar() {
        double[] dados = new double[4];

        for (int i = 0; i < 4; i++) {
            dados[i] = sc.nextDouble();
        }

        return dados;
    }

    static double calcular(double[] dados) {
        double total = dados[0] * 13.50
                     + dados[1] * 15.00
                     + dados[2] * 17.50;

        return total - (total * dados[3] / 100);
    }

    static void exibir(double[] dados, double total) {
        System.out.println("Seu pedido foi registrado.");
        System.out.printf("- Açaí P: %.0f%n", dados[0]);
        System.out.printf("- Açaí M: %.0f%n", dados[1]);
        System.out.printf("- Açaí G: %.0f%n", dados[2]);
        System.out.printf("Desconto de %.0f%% aplicado.%n", dados[3]);
        System.out.printf(Locale.US, "Total R$ %.2f%n", total);
    }

    public static void main(String[] args) {
        double[] dados = coletar();
        double total = calcular(dados);
        exibir(dados, total);
        sc.close();
    }
}
