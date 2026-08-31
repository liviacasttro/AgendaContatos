package br.edu.principal;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome = "";
        String celular = "";
        String email = "";
        boolean continuar = true;

        System.out.println("==========================");
        System.out.println("    AGENDA DE CONTATOS    ");
        System.out.println("         V.0.0.0          ");
        System.out.println("==========================");

        while (continuar) {
            System.out.println();
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Listar contato");
            System.out.println("3 - Procurar contato");
            System.out.println("4 - Excluir contato");
            System.out.println("5 - Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- ADICIONAR CONTATO ---");
                    System.out.print("Nome: ");
                    nome = scanner.nextLine();
                    System.out.print("Celular: ");
                    celular = scanner.nextLine();
                    System.out.print("E-mail: ");
                    email = scanner.nextLine();
                    System.out.println("Contato salvo com sucesso!");
                    break;

                case 2:
                    System.out.println("Listar contato");
                    break;

                case 3:
                    System.out.println("Procurar contato");
                    break;

                case 4:
                    System.out.println("Excluir contato");
                    break;

                case 5:
                    System.out.println("Saindo...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }
}