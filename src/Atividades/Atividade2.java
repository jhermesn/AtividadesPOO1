/* Atividade 2
* Um posto está vendendo combustíveis com a seguinte tabela de descontos:
* * álcool até 20 litros, desconto de 3% por litro.
* * álcool acima de 20 litros, desconto de 5% por litro.
* * gasolina até 20 litros, desconto de 4% por litro.
* * gasolina acima de 20 litros, desconto de 6% por litro.
*
* Escreva um programa que leia o número de litros vendidos e o tipo de combustível codificado da seguinte forma:
* * 1 - álcool,
* * 2 - gasolina.
* * Qualquer outro valor é inválido.
*
* O programa deve calcular e exibir o valor a ser pago pelo cliente sabendo-se que o preço do litro da gasolina é R$4,90 e o preço do litro do álcool é R$ 4,00.
*/

package Atividades;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Atividade2 {
    public static void run(Scanner scanner) {
      System.out.println("Um posto está vendendo combustíveis com a seguinte tabela de descontos:");
      System.out.println(" - álcool até 20 litros, desconto de 3% por litro.");
      System.out.println(" - álcool acima de 20 litros, desconto de 5% por litro.");
      System.out.println(" - gasolina até 20 litros, desconto de 4% por litro.");
      System.out.println(" - gasolina acima de 20 litros, desconto de 6% por litro.");
      System.out.println(" - preço do litro da gasolina é R$4,90 e o preço do litro do álcool é R$ 4,00.");
      System.out.println();

        Locale localeBR = Locale.forLanguageTag("pt-BR");
        NumberFormat moeda = NumberFormat.getCurrencyInstance(localeBR);

        double litros = lerDoubleNaoNegativo(scanner);
        int tipo = lerTipoCombustivel(scanner);

        final double PRECO_ALCOOL = 4.00;
        final double PRECO_GASOLINA = 4.90;

        double precoLitro = (tipo == 1) ? PRECO_ALCOOL : PRECO_GASOLINA;
        double totalBruto = litros * precoLitro;

        double percentualDesconto;
        if (tipo == 1) {
            percentualDesconto = (litros <= 20.0) ? 0.03 : 0.05;
        } else {
            percentualDesconto = (litros <= 20.0) ? 0.04 : 0.06;
        }

        double valorDesconto = totalBruto * percentualDesconto;
        double totalPagar = totalBruto - valorDesconto;

        System.out.println();
        System.out.println("Resumo do Cálculo:");
        System.out.println("- Tipo de combustível: " + (tipo == 1 ? "Álcool" : "Gasolina"));
        System.out.println("- Preço por litro: " + moeda.format(precoLitro));
        System.out.println("- Litros abastecidos: " + formatarNumero(litros));
        System.out.println("- Total bruto: " + moeda.format(totalBruto));
        System.out.println("- Desconto aplicado: " + formatarPercentual(percentualDesconto));
        System.out.println("- Valor do desconto: " + moeda.format(valorDesconto));
        System.out.println("= Total a pagar: " + moeda.format(totalPagar));
        System.out.println();
    }

    private static String formatarNumero(double valor) {
        return String.format(Locale.forLanguageTag("pt-BR"), "%.2f", valor);
    }

    private static String formatarPercentual(double valor) {
        return String.format(Locale.forLanguageTag("pt-BR"), "%.1f%%", valor * 100);
    }

    private static double lerDoubleNaoNegativo(Scanner scanner) {
        while (true) {
            System.out.print("Informe a quantidade de litros vendidos: ");
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
                System.out.println("Valor inválido. Use apenas números. Ex.: 12,5");
            }
        }
    }

    private static int lerTipoCombustivel(Scanner scanner) {
        while (true) {
            System.out.print("Informe o tipo de combustível (1-álcool, 2-gasolina): ");
            String entrada = scanner.nextLine().trim();
            try {
                int tipo = Integer.parseInt(entrada);
                if (tipo == 1 || tipo == 2) {
                    return tipo;
                }
                System.out.println("Tipo inválido. Digite 1 para álcool ou 2 para gasolina.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite 1 para álcool ou 2 para gasolina.");
            }
        }
    }
}
