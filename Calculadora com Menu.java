
package dobackofront;

import java.util.Scanner;
import java.util.Locale;

public class CalculadoraFuncoes {

    static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    static double[] coletarNumeros() {
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();
        sc.nextLine();

        return new double[]{n1, n2};
    }

    static String coletarOperacao() {
        return sc.nextLine().trim().toLowerCase();
    }

    static String identificarOperacao(String op) {
        switch (op) {
            case "1":
            case "soma": return "+";

            case "2":
            case "subtração":
            case "subtracao": return "-";

            case "3":
            case "multiplicação":
            case "multiplicacao": return "*";

            case "4":
            case "divisão":
            case "divisao": return "/";

            case "5":
            case "resto": return "mod";

            case "6":
            case "potência":
            case "potencia": return "^";

            default: return "";
        }
    }

    static double calcular(double a, double b, String simbolo) {
        switch (simbolo) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            case "mod": return a % b;
            case "^": return Math.pow(a, b);
            default: return 0;
        }
    }

    static void exibir(double a, double b, String simbolo,
                       double resultado) {

        if (simbolo.isEmpty()) {
            System.out.println("Operação não suportada");
        } else if ((simbolo.equals("/") || simbolo.equals("mod"))
                   && b == 0) {
            System.out.println("Divisão por zero não permitida");
        } else {
            System.out.println(a + " " + simbolo + " " +
                    b + " = " + resultado);
        }
    }

    public static void main(String[] args) {
        double[] numeros = coletarNumeros();
        String operacao = coletarOperacao();

        String simbolo = identificarOperacao(operacao);
        double resultado = calcular(numeros[0], numeros[1], simbolo);

        exibir(numeros[0], numeros[1], simbolo, resultado);
        sc.close();
    }
}
