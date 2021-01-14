// Padrão de projeto Singleton e Low Coupling

package src.projetos;
import java.util.Scanner;
import java.util.Vector;
import src.colaboradores.*;
import src.producaoAcademica.*;

import src.projetos.GerenProjetos.*;
import src.*;

public class GerenciarProgetos {

    Vector<Projeto> todosOsProjetos = new Vector<Projeto>();
    Scanner teclado = new Scanner(System.in);
    GerenciamentoColaboradores GerenColaboradores;
    GerenProducaoAcad GerenProdAcademica;
    GerenciarProgetos gerenciarProgetos;

    public void setar(GerenciamentoColaboradores GerenColaboradores, GerenProducaoAcad GerenProdAcademica, GerenciarProgetos gerenciarProgetos) {
        this.GerenColaboradores = GerenColaboradores;
        this.GerenProdAcademica = GerenProdAcademica;
        this.gerenciarProgetos = gerenciarProgetos;
    }

    AdicionarProjetos adicionarProjetos = new AdicionarProjetos();
    ConsultarProjeto consultarProjeto = new ConsultarProjeto();
    AlocarColaProj alocarColaProj = new AlocarColaProj();

    ClearBuffer clearBuffer = new ClearBuffer();

    public void adicionar() {
        System.out.println("#######################################################");

        if(GerenColaboradores.sizeProf()) {
            System.out.println("##     Por Favor Adicione um professor ao Sistema!   ##");
            clearBuffer.clear();
            return;
        }

        Projeto projeto = adicionarProjetos.adicionar(GerenColaboradores);

        todosOsProjetos.add(projeto);

        System.out.println("## **PROJETO ADICIONADO! ");
        clearBuffer.clear();
    }

    public void consultar() {
        System.out.println("#######################################################");

        if(todosOsProjetos.size() == 0) {
            System.out.println("##               **Nao existe projetos!              ##");
            clearBuffer.clear();
            return;
        }

        System.out.println("##               Qual projeto consultar?             ##");

        Projeto projetoConsulta = projetList();

        consultarProjeto.consultar(projetoConsulta);
    }

    public void mudarStatus() {
        System.out.println("#######################################################");
        System.out.println("##                    Qual projeto?                  ##");
        Projeto proj = projetList();

        if(proj.getEmElaboracao() == true){
            System.out.println("## Este projeto esta em Elaboracao.");
            System.out.println("## Deseja mudar para Em Andamento?");
            System.out.println("## [1] SIM OU [2] NAO");
            int escolha = 0;
            boolean stop = true;
            while(stop) {
                try {
                    escolha = Integer.parseInt(teclado.nextLine());
                    stop = false;
                } catch(Exception erro) {
                    // System.out.println("Digite um valor válido!");
                }
            }
            
            if(escolha == 1) {
                proj.setEmElaboracao(false);
                proj.setEmAndamento(true);
                System.out.println("## **Mudado para Em Andamento!");
            }
            if(escolha == 2) {
                System.out.println("## **Continua em elaboracao!");
            }

            clearBuffer.clear();
        }
        else if(proj.getEmAndamento() == true){
            System.out.println("## Este projeto esta Em Andamento.");
            System.out.println("## Deseja mudar para Concluido?");
            System.out.println("## [1] SIM OU [2] NAO");

            // int escolha = Integer.parseInt(teclado.nextLine());
            int escolha = 0;
            boolean stop = true;
            while(stop) {
                try {
                    escolha = Integer.parseInt(teclado.nextLine());
                    stop = false;
                } catch(Exception erro) {
                    // System.out.println("Digite um valor válido!");
                }
            }

            if(proj.publiacacoesSize()) {
                System.out.println("## Adicione uma publicacao ao projeto antes!");
                clearBuffer.clear();
                return;
            }

            if(escolha == 1) {
                proj.setEmAndamento(false);
                proj.setConcluido(true);
                System.out.println("## **Mudado Para Concluido!");
            }
            if(escolha == 2) {
                System.out.println("## **Continua em andamento!");
            }

            clearBuffer.clear();
        }

    }

    public void alocar() {

        if(todosOsProjetos.size() == 0) {
            System.out.println("##  **Nao existe projeto Para alocar colaboradores!  ##");
            System.out.println("##  **Crie um.                                       ##");
            clearBuffer.clear();
            return;
        }

        int escolha = alocarColaProj.alocar();

        if(escolha == 1) {
            alocarColaProj.alocarAlunosGraduacao(GerenColaboradores, GerenProdAcademica, gerenciarProgetos);
        }
        if(escolha == 2) {
            alocarColaProj.alocarAlunosMestrado(GerenColaboradores, GerenProdAcademica, gerenciarProgetos);
        }
        if(escolha == 3) {
            alocarColaProj.alocarAlunosDoutorado(GerenColaboradores, GerenProdAcademica, gerenciarProgetos);
        }
        if(escolha == 4) {
            alocarColaProj.alocarProfessores(GerenColaboradores, GerenProdAcademica, gerenciarProgetos);
        }
        if(escolha == 5) {
            alocarColaProj.alocarPesquisadores(GerenColaboradores, GerenProdAcademica, gerenciarProgetos);
        }
    }

    public Projeto projetList() {
        for (int i = 0; i < todosOsProjetos.size(); i++) {
            Projeto proj = todosOsProjetos.get(i);
            System.out.println("## " + "["+(i+1)+"] - Titulo:" + proj.getTitulo() + "  *Status: " + proj.getStatus());
        }

        System.out.print("## ");
        // int escolha = Integer.parseInt(teclado.nextLine());
        int escolha = 0;
        boolean stop = true;
        while(stop) {
            try {
                escolha = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        
        clearBuffer.clear();
        return todosOsProjetos.get(escolha - 1);
    }

    public boolean getSize() {
        if(todosOsProjetos.size() == 0) return true;
        else return false;
    }

    public Vector<Projeto> TodosProjetos() {
        return todosOsProjetos;
    }
}
