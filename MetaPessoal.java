
package dobackofront;

import java.util.Scanner;
import java.util.Locale;

public class MetaPessoal {

    static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    static String coletarDescricao() {
        return sc.nextLine();
    }

    static double[] coletarValores() {
        double[] valores = new double[3];

        for (int i = 0; i < 3; i++) {
            valores[i] = sc.nextDouble();
        }

        return valores;
    }

    static double[] calcular(double[] valores) {
        double saldo = valores[1] - valores[2];
        double reserva = saldo * 0.30;
        double disponivel = saldo - reserva;

        double meses = 0;

        if (disponivel > 0) {
            meses = valores[0] / disponivel;
        }

        return new double[]{saldo, reserva, disponivel, meses};
    }

    static void exibir(String descricao, double[] valores,
                       double[] resultado) {

        System.out.printf(Locale.US,
                "Meta: %s (R$ %.2f)%n", descricao, valores[0]);

        System.out.printf(Locale.US,
                "Salário: R$ %.2f - Despesas: R$ %.2f%n",
                valores[1], valores[2]);

        System.out.printf(Locale.US,
                "Saldo após despesas: R$ %.2f%n", resultado[0]);

        System.out.printf(Locale.US,
                "Reserva fixa (30%%): R$ %.2f%n", resultado[1]);

        System.out.printf(Locale.US,
                "Valor disponível para a meta: R$ %.2f por mês%n",
                resultado[2]);

        if (resultado[2] > 0) {
            System.out.printf(Locale.US,
                    "Prazo estimado para atingir a meta: %.2f meses%n",
                    resultado[3]);
        } else {
            System.out.println("Não há valor disponível para a meta.");
        }
    }

    public static void main(String[] args) {
        String descricao = coletarDescricao();
        double[] valores = coletarValores();
        double[] resultado = calcular(valores);
        exibir(descricao, valores, resultado);
        sc.close();
    }
}

