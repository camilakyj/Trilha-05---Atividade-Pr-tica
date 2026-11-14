
package dobackofront;

import java.util.Scanner;
import java.util.Locale;

public class FaturamentoFuncoes {

    static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    static double[] coletar() {
        int meses = sc.nextInt();

        if (meses <= 0) {
            return new double[0];
        }

        double[] faturamento = new double[meses];

        for (int i = 0; i < meses; i++) {
            faturamento[i] = sc.nextDouble();
        }

        return faturamento;
    }

    static String analisar(double[] valores) {
        if (valores.length == 0) {
            return "Dados inválidos";
        }

        boolean crescimento = true;
        boolean queda = true;
        boolean constante = true;

        for (int i = 1; i < valores.length; i++) {
            if (valores[i] < valores[i - 1]) {
                crescimento = false;
            }

            if (valores[i] > valores[i - 1]) {
                queda = false;
            }

            if (valores[i] != valores[i - 1]) {
                constante = false;
            }
        }

        if (constante) {
            return "Constante";
        } else if (crescimento) {
            return "Crescimento";
        } else if (queda) {
            return "Queda";
        } else {
            return "Sem padrão";
        }
    }

    static void exibir(double[] valores, String situacao) {
        if (valores.length == 0) {
            System.out.println(situacao);
            return;
        }

        System.out.println(">> Análise de Faturamento <<");
        System.out.print("Faturamento informado: ");

        for (int i = 0; i < valores.length; i++) {
            System.out.printf(Locale.US, "%.0f", valores[i]);

            if (i < valores.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("Situação: " + situacao);
    }

    public static void main(String[] args) {
        double[] valores = coletar();
        String situacao = analisar(valores);
        exibir(valores, situacao);
        sc.close();
    }
}
