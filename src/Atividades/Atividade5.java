/* Atividade 5
* Escreva um programa em Java que calcule o imposto de renda a partir da renda mensal informada pelo usuário.
*
* As regras são:
* * Renda mensal até R$ 1164,00: isento de imposto de Renda.
* * Renda mensal de R$ 1.164,00 a 2.326,00: 15% de imposto de renda.
* * Renda mensal superior R$ 2.326,00: 27,5 % de impostos de renda
*/

package Atividades;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Atividade5 {
    public static void run(Scanner scanner) {
        System.out.println("Cálculo do Imposto de Renda com base na renda mensal informada:");
        System.out.println(" - Renda mensal até R$ 1.164,00: isento de imposto de Renda.");
        System.out.println(" - Renda mensal de R$ 1.164,00 a 2.326,00: 15% de imposto de renda.");
        System.out.println(" - Renda mensal superior R$ 2.326,00: 27,5 % de impostos de renda.");
        System.out.println();

        Locale localeBR = Locale.forLanguageTag("pt-BR");
        NumberFormat moeda = NumberFormat.getCurrencyInstance(localeBR);

        double rendaMensal = lerDoubleNaoNegativo(scanner);

        double aliquota;
        if (rendaMensal <= 1164.00) {
            aliquota = 0.0;
        } else if (rendaMensal <= 2326.00) {
            aliquota = 0.15;
        } else {
            aliquota = 0.275;
        }

        double impostoDevido = rendaMensal * aliquota;

        System.out.println();
        System.out.println("Resumo do Cálculo:");
        System.out.println("- Renda mensal: " + moeda.format(rendaMensal));
        System.out.println("- Alíquota aplicada: " + formatarPercentual(aliquota));
        System.out.println("= Imposto devido: " + moeda.format(impostoDevido));
        System.out.println();
    }

    private static String formatarPercentual(double aliquota) {
        return String.format(Locale.forLanguageTag("pt-BR"), "%.1f%%", aliquota * 100);
    }

    private static double lerDoubleNaoNegativo(Scanner scanner) {
        while (true) {
            System.out.print("Informe a sua renda mensal: ");
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
                System.out.println("Valor inválido. Use apenas números. Ex.: 2500,75");
            }
        }
    }
}