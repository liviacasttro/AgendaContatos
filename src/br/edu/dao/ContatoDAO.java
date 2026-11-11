package br.edu.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.edu.modelo.Contato;

public class ContatoDAO {
	
	public static void salvarContatos(List<Contato> contatos) {

	    try (PrintWriter pw = new PrintWriter(new FileWriter("contatos.txt"))) {

	        for (Contato contato : contatos) {

	            String linha = contato.getNome() + ";"
	                         + contato.getCelular() + ";"
	                         + contato.getEmail();

	            pw.println(linha);
	        }

	        System.out.println("Contatos salvos com sucesso!");

	    } catch (IOException e) {

	        System.out.println("Erro ao salvar os contatos!");
	        System.out.println("Motivo: " + e.getMessage());
	    }
	}
	
	public static void carregarContatos(List<Contato> contatos) {

	    File arquivo = new File("contatos.txt");

	    if (!arquivo.exists()) return;

	    try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

	        String linha;

	        while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";", -1);
                if (dados.length == 3 
                        && !dados[0].trim().isEmpty() 
                        && !dados[1].trim().isEmpty() 
                        && !dados[2].trim().isEmpty()) {
                    Contato contato = new Contato(
                        dados[0].trim(), 
                        dados[1].trim(), 
                        dados[2].trim()
                    );
                    contatos.add(contato);

	            } else {
                    System.out.println("Registro inválido ignorado: " + linha);
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Erro ao carregar os contatos!");
	        System.out.println("Motivo: " + e.getMessage());
	    }
	}

}