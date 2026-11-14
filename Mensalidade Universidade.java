
package dobackofront;

import java.util.Scanner;
import java.util.Locale;

public class MensalidadeFuncoes {

    static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    static String[] coletar() {
        String curso = sc.nextLine().trim().toUpperCase();
        String isento = sc.nextLine().trim();
        String desconto = sc.nextLine().trim();

        return new String[]{curso, isento, desconto};
    }

    static double calcular(String[] dados) {
        double mensalidade;

        switch (dados[0]) {
            case "SI": mensalidade = 900; break;
            case "ADS": mensalidade = 750; break;
            case "CS": mensalidade = 1150; break;
            case "EC": mensalidade = 1300; break;
            case "ES": mensalidade = 950; break;
            default: return -1;
        }

        if (dados[1].equalsIgnoreCase("Sim")) {
            return 0;
        }

        double desconto = Double.parseDouble(dados[2]);
        return mensalidade * (1 - desconto / 100);
    }

    static void exibir(double mensalidade) {
        if (mensalidade < 0) {
            System.out.println("Curso não encontrado");
        } else {
            System.out.printf(Locale.US,
                    "Valor da mensalidade: R$ %.2f%n", mensalidade);
        }
    }

    public static void main(String[] args) {
        String[] dados = coletar();
        double mensalidade = calcular(dados);
        exibir(mensalidade);
        sc.close();
    }
}
