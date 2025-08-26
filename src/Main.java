public class Main {
    public static void main(String[] args) {
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.println("===== Atividade 1 =====\n");
            Atividade1.run(scanner);
            System.out.println("=======================\n");
            System.out.println("===== Atividade 2 =====\n");
            Atividade2.run(scanner);
            System.out.println("=======================\n");
            System.out.println("===== Atividade 3 =====\n");
            Atividade3.run(scanner);
            System.out.println("=======================\n");
            System.out.println("===== Atividade 4 =====\n");
            Atividade4.run(scanner);
            System.out.println("=======================\n");
            System.out.println("===== Atividade 5 =====\n");
            Atividade5.run(scanner);
            System.out.println("=======================\n");
        }
    }
}