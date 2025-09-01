/* Atividade 1
* Em uma revendedora de carros usados o salário dos vendedores é composto por:
* * salário fixo por mês;
* * comissâo também fixa para cada carro vendido;
* * 5% do valor total das vendas efetuadas pelo vendedor.
*
* Escreva um programa utilizando a linguagem Java onde o usuário irá informar:
* * salário fixo mensal do vendedor;
* * número de carros vendidos pelo vendedor;
* * valor da comissão fixa por carro vendido;
* * valor total das vendas efetuadas pelo vendedor;
*
* O programa deverá calcular e exibir o salário mensal do vendedor.
*/

package Atividades;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Atividade1 {
    public static void run(Scanner scanner) {
        System.out.println("Em uma revendedora de carros usados, o salário dos vendedores é composto por:");
        System.out.println(" - salário fixo por mês;");
        System.out.println(" - comissão fixa para cada carro vendido;");
        System.out.println(" - 5% do valor total das vendas efetuadas.");
        System.out.println();

        Locale localeBR = Locale.forLanguageTag("pt-BR");
        NumberFormat moeda = NumberFormat.getCurrencyInstance(localeBR);

        double salarioFixo = lerDoubleNaoNegativo(scanner, "Informe o salário fixo mensal do vendedor: ");
        int numeroCarrosVendidos = lerIntNaoNegativo(scanner);
        double comissaoPorCarro = lerDoubleNaoNegativo(scanner, "Informe o valor da comissão fixa por carro vendido: ");
        double valorTotalVendas = lerDoubleNaoNegativo(scanner, "Informe o valor total das vendas efetuadas: ");

        double totalComissoesFixas = numeroCarrosVendidos * comissaoPorCarro;
        double comissaoPercentual = valorTotalVendas * 0.05;
        double salarioTotal = salarioFixo + totalComissoesFixas + comissaoPercentual;

        System.out.println();
        System.out.println("Resumo do Cálculo:");
        System.out.println("- Salário fixo: " + moeda.format(salarioFixo));
        System.out.println("- Carros vendidos: " + numeroCarrosVendidos);
        System.out.println("- Comissão fixa por carro: " + moeda.format(comissaoPorCarro));
        System.out.println("- Total em comissões fixas: " + moeda.format(totalComissoesFixas));
        System.out.println("- Valor total das vendas: " + moeda.format(valorTotalVendas));
        System.out.println("- Comissão de 5% sobre vendas: " + moeda.format(comissaoPercentual));
        System.out.println("= Salário total do mês: " + moeda.format(salarioTotal));
        System.out.println();
    }

    private static double lerDoubleNaoNegativo(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Entrada vazia. Tente novamente.");
                continue;
            }
            try {
                double valor = Double.parseDouble(entrada.replace(',', '.'));
                if (valor < 0) {
                    System.out.println("O valor não pode ser negativo. Tente novamente.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Use apenas números. Ex.: 1234,56");
            }
        }
    }

    private static int lerIntNaoNegativo(Scanner scanner) {
        while (true) {
            System.out.print("Informe o número de carros vendidos: ");
            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Entrada vazia. Tente novamente.");
                continue;
            }
            try {
                int valor = Integer.parseInt(entrada);
                if (valor < 0) {
                    System.out.println("O valor não pode ser negativo. Tente novamente.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Use apenas números inteiros. Ex.: 10");
            }
        }
    }
}