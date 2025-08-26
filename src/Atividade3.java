/* Atividade 3
* Faça um programa em Java que receba o preço líquido de um produto e o seu código de origem
* e mostre a sua procedência e o preço final,
* calculado pelo imposto relativo a sua procedência.
* A procedência obedece a tabela a seguir:
* * Código de origem  | Procedência   | % Imposto
* * 1                 | Sul           | 11%
* * 2                 | Norte         | 13%
* * 3                 | Nordeste      | 9%
* * 4                 | Centro-Oeste  | 12%
*/

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Atividade3 {
    public static void run(Scanner scanner) {
        System.out.println("O preço líquido do produto e o código de origem são inseridos e são recebidos a procedência e o preço final, calculado pelo imposto relativo à procedência.");
        System.out.println(" - Código de origem | Procedência   | % Imposto");
        System.out.println(" - 1                | Sul           | 11%");
        System.out.println(" - 2                | Norte         | 13%");
        System.out.println(" - 3                | Nordeste      | 9%");
        System.out.println(" - 4                | Centro-Oeste  | 12%");
        System.out.println();

        Locale localeBR = Locale.forLanguageTag("pt-BR");
        NumberFormat moeda = NumberFormat.getCurrencyInstance(localeBR);

        double precoLiquido = lerDoubleNaoNegativo(scanner);
        int codigo = lerCodigoOrigem(scanner);

        String procedencia;
        double percentualImposto;
        switch (codigo) {
            case 1 -> {
              procedencia = "Sul";
              percentualImposto = 0.11;
            }
            case 2 -> {
              procedencia = "Norte";
              percentualImposto = 0.13;
            }
            case 3 -> {
              procedencia = "Nordeste";
              percentualImposto = 0.09;
            }
            case 4 -> {
              procedencia = "Centro-Oeste";
              percentualImposto = 0.12;
            }
            default -> throw new IllegalStateException("Código de origem inválido: " + codigo);
        }

        double valorImposto = precoLiquido * percentualImposto;
        double precoFinal = precoLiquido + valorImposto;

        System.out.println();
        System.out.println("Resumo do Cálculo:");
        System.out.println("- Procedência: " + procedencia);
        System.out.println("- Preço líquido: " + moeda.format(precoLiquido));
        System.out.println("- Imposto aplicado: " + formatarPercentual(percentualImposto));
        System.out.println("- Valor do imposto: " + moeda.format(valorImposto));
        System.out.println("= Preço final: " + moeda.format(precoFinal));
        System.out.println();
    }

    private static String formatarPercentual(double valor) {
        return String.format(Locale.forLanguageTag("pt-BR"), "%.1f%%", valor * 100);
    }

    private static double lerDoubleNaoNegativo(Scanner scanner) {
        while (true) {
            System.out.print("Informe o preço líquido do produto: ");
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

    private static int lerCodigoOrigem(Scanner scanner) {
        while (true) {
            System.out.print("Informe o código de origem (1-Sul, 2-Norte, 3-Nordeste, 4-Centro-Oeste): ");
            String entrada = scanner.nextLine().trim();
            try {
                int codigo = Integer.parseInt(entrada);
                if (codigo >= 1 && codigo <= 4) {
                    return codigo;
                }
                System.out.println("Código inválido. Digite 1, 2, 3 ou 4.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro entre 1 e 4.");
            }
        }
    }
}