
package dobackofront;

import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;

public class CaixaMercadoFuncoes {

    static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    static ArrayList<Double> coletarCompras() {
        ArrayList<Double> compras = new ArrayList<>();

        while (true) {
            double valor = sc.nextDouble();

            if (valor == 0) {
                break;
            }

            compras.add(valor);
        }

        return compras;
    }

    static int coletarParcelas() {
        return sc.nextInt();
    }

    static double calcularTotal(ArrayList<Double> compras) {
        double total = 0;

        for (double valor : compras) {
            if (valor < 0) {
                System.out.println("Valor inválido: " + valor);
            } else {
                total += valor;
            }
        }

        return total;
    }

    static double calcularParcela(double total, int parcelas) {
        if (parcelas <= 1) {
            return total;
        }

        return total / parcelas;
    }

    static void exibir(double total, int parcelas, double valorParcela) {
        if (parcelas <= 1) {
            System.out.printf(Locale.US,
                    "Pagamento à vista: R$ %.2f%n", total);
        } else {
            System.out.printf(Locale.US,
                    "Total da compra: R$ %.2f%n", total);

            System.out.printf(Locale.US,
                    "Parcelado em %dx de R$ %.2f%n",
                    parcelas, valorParcela);
        }
    }

    public static void main(String[] args) {
        ArrayList<Double> compras = coletarCompras();
        int parcelas = coletarParcelas();

        double total = calcularTotal(compras);
        double valorParcela = calcularParcela(total, parcelas);

        exibir(total, parcelas, valorParcela);
        sc.close();
    }
}
