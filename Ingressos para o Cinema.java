
package dobackofront;

import java.util.Scanner;
import java.util.Locale;

public class IngressosCinemaFuncoes {

    static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    static int[] coletarQuantidades() {
        int inteiras = sc.nextInt();
        int meias = sc.nextInt();
        sc.nextLine();

        return new int[]{inteiras, meias};
    }

    static String[] coletarInformacoes() {
        String dia = sc.nextLine();
        String nacional = sc.nextLine();

        return new String[]{dia, nacional};
    }

    static double calcular(int[] quantidades, String[] informacoes) {
        int inteiras = quantidades[0];
        int meias = quantidades[1];

        String dia = informacoes[0];
        String nacional = informacoes[1];

        if (nacional.equalsIgnoreCase("Sim")) {
            return (inteiras + meias) * 5.00;
        }

        if (dia.equalsIgnoreCase("Quarta-feira")) {
            return (inteiras + meias) * 14.50;
        }

        return inteiras * 28.50 + meias * 14.25;
    }

    static void exibir(double total) {
        System.out.printf(Locale.US,
                "Total à pagar: R$ %.2f%n", total);
    }

    public static void main(String[] args) {
        int[] quantidades = coletarQuantidades();
        String[] informacoes = coletarInformacoes();

        double total = calcular(quantidades, informacoes);

        exibir(total);
        sc.close();
    }
}
