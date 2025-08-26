/* Atividade 4
* Faça um programa em Java que leia o seu peso na terra e o numero de um planeta e
* calcule qual será o seu peso neste planeta.
*
* A relação de planetas é:
* * Número | Planeta | Gravidade Relativa
* * 1      | Mercúrio | 0.37
* * 2      | Vênus    | 0.88
* * 3      | Marte    | 0.38
* * 4      | Júpiter  | 2.64
* * 5      | Saturno  | 1.15
* * 6      | Urano    | 1.17
*
* A fórmula para o calculo do peso em outro planeta, considerando a gravidade relativa de cada um deles é:
* * Peso_no_Planeta = (Peso_na_Terra/10) * Gravidade
*/

import java.util.Locale;
import java.util.Scanner;

public class Atividade4 {
    public static void run(Scanner scanner) {
        System.out.println("O peso na Terra e o número de um planeta são inseridos e é calculado qual será o peso neste planeta.");
        System.out.println(" - Número | Planeta  | Gravidade Relativa");
        System.out.println(" - 1      | Mercúrio | 0.37");
        System.out.println(" - 2      | Vênus    | 0.88");
        System.out.println(" - 3      | Marte    | 0.38");
        System.out.println(" - 4      | Júpiter  | 2.64");
        System.out.println(" - 5      | Saturno  | 1.15");
        System.out.println(" - 6      | Urano    | 1.17");
        System.out.println();

        double pesoTerra = lerDoubleNaoNegativo(scanner);
        int codigoPlaneta = lerIntNoIntervalo(scanner);

        String nomePlaneta;
        double gravidadeRelativa;
        switch (codigoPlaneta) {
            case 1 -> { nomePlaneta = "Mercúrio"; gravidadeRelativa = 0.37; }
            case 2 -> { nomePlaneta = "Vênus"; gravidadeRelativa = 0.88; }
            case 3 -> { nomePlaneta = "Marte"; gravidadeRelativa = 0.38; }
            case 4 -> { nomePlaneta = "Júpiter"; gravidadeRelativa = 2.64; }
            case 5 -> { nomePlaneta = "Saturno"; gravidadeRelativa = 1.15; }
            case 6 -> { nomePlaneta = "Urano"; gravidadeRelativa = 1.17; }
            default -> throw new IllegalStateException("Código de planeta inválido: " + codigoPlaneta);
        }

        double pesoNoPlaneta = (pesoTerra / 10.0) * gravidadeRelativa;

        System.out.println();
        System.out.println("Resumo do Cálculo:");
        System.out.println("- Peso na Terra: " + formatarNumeroBR(pesoTerra) + " N");
        System.out.println("- Planeta: " + nomePlaneta + " (gravidade relativa: " + gravidadeRelativa + ")");
        System.out.println("= Peso no planeta: " + formatarNumeroBR(pesoNoPlaneta) + " N");
        System.out.println();
    }

    private static String formatarNumeroBR(double valor) {
        return String.format(Locale.forLanguageTag("pt-BR"), "%.2f", valor);
    }

    private static double lerDoubleNaoNegativo(Scanner scanner) {
        while (true) {
            System.out.print("Informe seu peso na Terra: ");
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
                System.out.println("Valor inválido. Use apenas números. Ex.: 70,5");
            }
        }
    }

    private static int lerIntNoIntervalo(Scanner scanner) {
        while (true) {
            System.out.print("Informe o número do planeta (1-Mercúrio, 2-Vênus, 3-Marte, 4-Júpiter, 5-Saturno, 6-Urano): ");
            String entrada = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor < 1 || valor > 6) {
                    System.out.println("Valor fora do intervalo. Digite entre " + 1 + " e " + 6 + ".");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro entre " + 1 + " e " + 6 + ".");
            }
        }
    }
}