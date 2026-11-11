package br.edu.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.controle.AgendaController;
import br.edu.dao.ContatoDAO;
import br.edu.modelo.Contato;
import br.edu.visao.AgendaView;

public class Principal {
	
	public static void main(String[] args) {

        List<Contato> contatos = new ArrayList<>();

        ContatoDAO dao = new ContatoDAO("contatos.txt");
        dao.carregarContatos(contatos);

        AgendaController controller =
                new AgendaController(contatos, dao);

        Scanner sc = new Scanner(System.in);
        AgendaView view = new AgendaView(sc, controller);

        view.iniciar();

        sc.close();
    }	
}