package br.edu.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		Contato contato1 = new Contato();
		contato1.nome = "Arthur Dent";
		contato1.celular = "4242-4242";
		contato1.email = "arthur@galaxy.com";
			
		
		Contato contato2 = new Contato();
		contato2.nome = "Ford Prefect";
		contato2.celular = "1234-5678";
		contato2.email = "ford@galaxy.com";
			
		
		Contato contato3 = new Contato();
		contato3.nome = "Trillian";
		contato3.celular = "9876-5432";
		contato3.email = "trillian@galaxy.com";

				
		List<Contato> contatos = new ArrayList<>();
		contatos.add(contato1);
		contatos.add(contato2);
		contatos.add(contato3);
		
		for (Contato contato : contatos) {
		    System.out.println("Nome: " + contato.nome);
		    System.out.println("Celular: " + contato.celular);
		    System.out.println("E-mail: " + contato.email);
		    System.out.println("-------------------------");
		}
		
		for (int i = 0; i < contatos.size(); i++) {

		    Contato contato = contatos.get(i);

		    System.out.println("Contato " + i);
		    System.out.println("Nome: " + contato.nome);
		    System.out.println("Celular: " + contato.celular);
		    System.out.println("E-mail: " + contato.email);
		}
		
		Contato contato = contatos.get(0);
		System.out.println(contato.nome);
		System.out.println(contato.celular);
		System.out.println(contato.email);
		
		System.out.println(contatos.get(0).nome);
		

        List<String> nomes = new ArrayList<>();
        List<String> celulares = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        Persistencia.carregarContatos(nomes, celulares, emails);
        
        int opcao;
        boolean continuar = true;
        
        Scanner sc = new Scanner(System.in);
        
        Uteis.mostraInicializacao(); 

        while (continuar) {
        	Uteis.mostraMenu();
            opcao = Uteis.selecionaOpcao(sc);

            switch (opcao) {
                case 1-> Agenda.adicionar(sc, nomes, celulares, emails);           	
                case 2-> Agenda.listar(nomes, celulares, emails);
                case 3-> Agenda.pesquisar(sc, nomes, celulares, emails);
                case 4-> Agenda.atualizar(sc, nomes, celulares, emails);           	
                case 5-> Agenda.excluir(sc, nomes, celulares, emails);          	
                case 6-> {
                	Persistencia.salvarContatos(nomes, celulares, emails);
                	continuar = Uteis.sair();
                }
                case 7-> Uteis.sobre();
                default -> System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }	
}