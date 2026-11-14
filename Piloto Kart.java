
package dobackofront;

import java.util.Scanner;
import java.util.Locale;

public class PilotoKart {

    static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    static double[] coletar() {
        double[] dados = new double[3];

        for (int i = 0; i < 3; i++) {
            dados[i] = sc.nextDouble();
        }

        return dados;
    }

    static double[] calcular(double[] dados) {
        double distancia = dados[0] * dados[1] / 1000;
        double tempo = dados[1] * dados[2] / 60;

        return new double[]{distancia, tempo};
    }

    static void exibir(double[] resultado) {
        System.out.println("Análise Preditiva Concluída");
        System.out.println("--");

        System.out.printf(Locale.US,
                "Distância total a ser percorrida: %.2f km.%n",
                resultado[0]);

        System.out.printf(Locale.US,
                "Previsão de conclusão: %.1f minutos.%n",
                resultado[1]);
    }

    public static void main(String[] args) {
        double[] dados = coletar();
        double[] resultado = calcular(dados);
        exibir(resultado);
        sc.close();
    }
}
