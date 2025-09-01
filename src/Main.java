public class Main {
    public static void main(String[] args) {
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            while (true) {
                System.out.println("===== Menu de Atividades =====");
                System.out.println("1. Atividade 1");
                System.out.println("2. Atividade 2");
                System.out.println("3. Atividade 3");
                System.out.println("4. Atividade 4");
                System.out.println("5. Atividade 5");
                System.out.println("6. Sair");
                System.out.print("Escolha uma atividade (1-6): ");

                String entrada = scanner.nextLine().trim();
                int escolha;
                try {
                    escolha = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número entre 1 e 6.\n");
                    continue;
                }

                switch (escolha) {
                    case 1:
                        System.out.println("===== Atividade 1 =====\n");
                      Atividades.Atividade1.run(scanner);
                        System.out.println("=======================\n");
                        pause(scanner);
                        break;
                    case 2:
                        System.out.println("===== Atividade 2 =====\n");
                        Atividades.Atividade2.run(scanner);
                        System.out.println("=======================\n");
                        pause(scanner);
                        break;
                    case 3:
                        System.out.println("===== Atividade 3 =====\n");
                        Atividades.Atividade3.run(scanner);
                        System.out.println("=======================\n");
                        pause(scanner);
                        break;
                    case 4:
                        System.out.println("===== Atividade 4 =====\n");
                        Atividades.Atividade4.run(scanner);
                        System.out.println("=======================\n");
                        pause(scanner);
                        break;
                    case 5:
                        System.out.println("===== Atividade 5 =====\n");
                        Atividades.Atividade5.run(scanner);
                        System.out.println("=======================\n");
                        pause(scanner);
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida. Escolha um número entre 1 e 6.\n");
                        break;
                }
            }
        }
    }

    private static void pause(java.util.Scanner scanner) {
        System.out.print("Pressione Enter para voltar ao menu...");
        scanner.nextLine();
        System.out.println();
    }
}