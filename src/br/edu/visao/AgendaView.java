package br.edu.visao;

import java.util.List;
import java.util.Scanner;

import br.edu.controle.AgendaController;
import br.edu.modelo.Contato;

public class AgendaView {

    private Scanner sc;
    private AgendaController controller;

    public AgendaView(Scanner sc) {
        this.sc = sc;
    }
    
    public AgendaView(Scanner sc, AgendaController controller) {
        this.sc = sc;
        this.controller = controller;
    }
    
    public void mostrarInicializacao() {

        System.out.println("================================");
        System.out.println("       AGENDA DE CONTATOS       ");
        System.out.println("================================");
        System.out.println("         Versão: V5.1.0          ");
    }

    public void mostrarMenu() {

        System.out.println();
        System.out.println("1 - Adicionar contato");
        System.out.println("2 - Listar contatos");
        System.out.println("3 - Procurar contato");
        System.out.println("4 - Alterar contato");
        System.out.println("5 - Excluir contato");
        System.out.println("6 - Sair");
        System.out.println("7 - Sobre");
    }

    public int selecionarOpcao() {

        System.out.print("Escolha uma opção: ");

        int opcao = sc.nextInt();
        sc.nextLine();

        return opcao;
    }
    
    public void iniciar() {

        mostrarInicializacao();
        int opcao;

        do {
            mostrarMenu();
            opcao = selecionarOpcao();

            switch (opcao) {

                case 1 -> executarInclusao();
                case 2 -> executarListagem();
                case 3 -> executarPesquisa();
                case 4 -> executarAtualizacao();
                case 5 -> executarExclusao();
                case 6 -> {if (executarSaida()) return;}
                case 7 -> mostrarSobre();
                default -> mostrarMensagem("Opção inválida!");
            }

        } while (true);
    }
    
    public void mostrarEncerramento() {

        System.out.println();
        System.out.println("Encerrando a Agenda de Contatos...");
        System.out.println("Até a próxima!");
    }
    
    public void mostrarSobre() {

        System.out.println();
        System.out.println("=== SOBRE O SISTEMA ===");
        System.out.println("Aplicação: Agenda de Contatos");
        System.out.println("Versão: V5.1.0");
        System.out.println("Linguagem: Java");
        System.out.println("Arquitetura: MVC");
        System.out.println("Persistência: DAO / Arquivo TXT");
    }
    
    public void executarInclusao() {

        Contato contato = lerContato();

        controller.adicionarContato(contato);

        mostrarMensagem("Contato adicionado com sucesso!");
    }
    
    public void executarListagem() {

        List<Contato> contatos = controller.listarContatos();

        mostrarContatos(contatos);
    }

    public void executarPesquisa() {

        String nome = lerNomePesquisa();

        Contato contato = controller.pesquisarContato(nome);

        mostrarResultadoPesquisa(contato);
    }
    
    public void executarAtualizacao() {

        String nome = lerNomePesquisa();

        Contato contato = controller.pesquisarContato(nome);

        if (contato == null) {
            mostrarMensagem("Contato não encontrado!");
            return;
        }

        mostrarResultadoPesquisa(contato);

        Contato novosDados = lerDadosAtualizacao();

        boolean atualizado = controller.atualizarContato(
                nome,
                novosDados.getNome(),
                novosDados.getCelular(),
                novosDados.getEmail()
        );

        if (atualizado) {
            mostrarMensagem("Contato atualizado com sucesso!");
        } else {
            mostrarMensagem("Não foi possível atualizar o contato.");
        }
    }
    
    public void executarExclusao() {

        String nome = lerNomePesquisa();

        Contato contato = controller.pesquisarContato(nome);

        if (contato == null) {
            mostrarMensagem("Contato não encontrado!");
            return;
        }

        mostrarResultadoPesquisa(contato);

        if (confirmarExclusao()) {

            boolean excluido = controller.excluirContato(nome);

            if (excluido) {
                mostrarMensagem("Contato excluído com sucesso!");
            } else {
                mostrarMensagem("Não foi possível excluir o contato.");
            }

        } else {
            mostrarMensagem("Exclusão cancelada.");
        }
    }
    
    public Contato lerContato() {

        System.out.println("=== ADICIONAR CONTATO ===");

        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite o celular: ");
        String celular = sc.nextLine();

        System.out.print("Digite o email: ");
        String email = sc.nextLine();

        return new Contato(nome, celular, email);
    }
    
    public String lerNomePesquisa() {

        System.out.println("\n=== PESQUISAR CONTATO ===");

        System.out.print("Digite o nome do contato: ");

        return sc.nextLine();
    }
    
    public Contato lerDadosAtualizacao() {

        System.out.println("\n=== NOVOS DADOS ===");

        System.out.print("Novo nome: ");
        String nome = sc.nextLine();

        System.out.print("Novo celular: ");
        String celular = sc.nextLine();

        System.out.print("Novo email: ");
        String email = sc.nextLine();

        return new Contato(nome, celular, email);
    }
    
    public void mostrarMensagem(String mensagem) {

        System.out.println(mensagem);
    }
    
    public void mostrarContatos(List<Contato> contatos) {

        System.out.println("\n=== LISTA DE CONTATOS ===");

        if (contatos.isEmpty()) {
            mostrarMensagem("Nenhum contato cadastrado.");
            return;
        }

        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }
    
    public void mostrarResultadoPesquisa(Contato contato) {

        if (contato == null) {

            mostrarMensagem("Contato não encontrado.");

        } else {

            System.out.println("\nContato encontrado:");
            System.out.println(contato);
        }
    }
    
    public boolean confirmarExclusao() {

        System.out.print("Deseja realmente excluir? (S/N): ");

        String resposta = sc.nextLine();

        return resposta.equalsIgnoreCase("S");
    }
    
    public boolean executarSaida() {

        boolean salvou = controller.salvarContatos();

        if (salvou) {
            mostrarEncerramento();
            return true;
        }

        mostrarMensagem("Erro ao salvar os contatos!");
        mostrarMensagem("A aplicação permanecerá em execução.");

        return false;
    }
}