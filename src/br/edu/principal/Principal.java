package br.edu.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {


        List<String> nomes = new ArrayList<>();
        List<String> celulares = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        Persistencia.carregarContatos(nomes, celulares, emails);
        
        int opcao;
        boolean continuar = true;
        
        Scanner sc = new Scanner(System.in);
        
        uteis.mostraInicializacao(); 

        while (continuar) {
        	uteis.mostraMenu();
            opcao = uteis.selecionaOpcao(sc);

            switch (opcao) {
                case 1-> Agenda.adicionar(sc, nomes, celulares, emails);           	
                case 2-> Agenda.listar(nomes, celulares, emails);
                case 3-> Agenda.pesquisar(sc, nomes, celulares, emails);
                case 4-> Agenda.atualizar(sc, nomes, celulares, emails);           	
                case 5-> Agenda.excluir(sc, nomes, celulares, emails);          	
                case 6-> {
                	Persistencia.salvarContatos(nomes, celulares, emails);
                	continuar = uteis.sair();
                }
                case 7-> uteis.sobre();
                default -> System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }	
}