package br.edu.uteis;

import javax.swing.JOptionPane;

public class Uteis {
	public static void mostraInicializacao() {
    	System.out.println("==========================");
        System.out.println("     AGENDA DE CONTATOS   ");
        System.out.println("          v5.0.0          ");
        System.out.println("==========================");
        System.out.println("Bem-vindo!");
    }
    
    
    public static void sair() {
    	System.out.println("Saindo da Agenda de Contatos...");
    }
    
    public static void sobre() {
    	JOptionPane.showMessageDialog(null, 
    			"Desenvolvido por Lívia Castro!");
    }
}