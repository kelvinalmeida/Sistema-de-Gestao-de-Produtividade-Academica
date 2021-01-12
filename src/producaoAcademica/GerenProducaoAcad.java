package src.producaoAcademica;

import src.projetos.*;
import src.colaboradores.*;
import java.util.Vector;
import java.util.Scanner;

import src.producaoAcademica.GerenProdAcad.*;

public class GerenProducaoAcad {

    
    Vector<Publicacao> conjPublicacoes = new Vector<Publicacao>();
    Vector<Orientacao> conjOrientacao = new Vector<Orientacao>();
    GerenciamentoColaboradores gerencColab;
    GerenciarProgetos gerencProj;
    Scanner teclado = new Scanner(System.in);

    AdPublicacao adPublicacao = new AdPublicacao();
    AdOrientacao adOrientacao = new AdOrientacao();

    // Ponteiro
    public void setar(GerenciamentoColaboradores gerencColab, GerenciarProgetos gerencProj) {
        this.gerencColab = gerencColab;
        this.gerencProj = gerencProj;
    }

    public void adicionar() {
        System.out.println("#######################################################");
        System.out.println("##           Qual tipo de producao academica?        ##");
        System.out.println("##           [1] Publicacao [2] Orientacao           ##");

        System.out.println("## ");
        int escolha = 0;
        boolean stop = true;
        while(stop) {
            try {
                escolha = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }

        System.out.println("## press[ENTER]...");
        teclado.nextLine();

        if (escolha == 1)
            this.addPublicacao();
        if (escolha == 2)
            this.addOrientacao();

    }

    public void addPublicacao() {
        Publicacao publicacao = adPublicacao.adicionarPublicacao();

        conjPublicacoes.add(publicacao);

        System.out.println("## **Adicionada! ");
        System.out.println("## press[ENTER]... ");
        teclado.nextLine();
        System.out.println("#######################################################"); 
    }

    public void addOrientacao() {
        
        if(gerencProj.getSize()) {
            System.out.println("## Por favor, adicione um projeto antes!.");
            System.out.println("## press[ENTER]...");
            teclado.nextLine();
            return;
        }

        Orientacao orientacao = adOrientacao.adicionarOrientacao(gerencProj);

        conjOrientacao.add(orientacao);

        System.out.println("## **ORIENTACAO ADICIONADA!");
        System.out.println("## press[ENTER]...");
        teclado.nextLine();
    }

    ////////////////////////
    // Alocar public. para algum projeto.

    public void alocar() {
        if(gerencProj.getSize()){
            System.out.println("## ** Por favor, adicione um projeto antes!");
            System.out.println("## press[ENTER]... ");
            teclado.nextLine();
            return;
        }

        if(conjPublicacoes.size() == 0) {
            System.out.println("## ** Por favor, adicione uma publicacao antes!");
            System.out.println("## press[ENTER]... ");
            teclado.nextLine();
            return;
        }

        System.out.println("## Escolha a Publicacao:");
        Publicacao publicEscolhida = this.publicacaoList();

        System.out.println("## Escolha um projeto para Inserir a Publicacao:");
        Projeto projetoEscolhido = gerencProj.projetList();
        
        // REGRA!
        if(projetoEscolhido.getEmAndamento() == false) {
            System.out.println("## O projeto precisa esta em andamento!");
            System.out.println("## press[ENTER]...");
            teclado.nextLine();
            return;
        } 
        
        projetoEscolhido.setPublicacao(publicEscolhida);
        System.out.println("## O Publicacao **" + publicEscolhida.getTitulo() + "  **ADICIONADA!");
        System.out.println("## press[ENTER]...");
        teclado.nextLine();
    } 

    //////////////////////////
    // help

    public void clearBuffer(Scanner scanner) {
        if(scanner.hasNextLine()) {
            // System.out.println("## ++");
            scanner.nextLine();
        }
    }

    public boolean publicacaoSize() {
        if(conjPublicacoes.size() == 0) return true;
        else return false;
    }
    
    public int publicacaoQnt() {
        return conjPublicacoes.size();
    }

    public int orientacaoQnt() {
        return conjOrientacao.size();
    }

    public Publicacao publicacaoList() {
        for (int i = 0; i < conjPublicacoes.size(); i++) {
            Publicacao proj = conjPublicacoes.get(i);
            System.out.println("## " + "["+(i+1)+"] - Titulo:" + proj.getTitulo());
        }

        System.out.println("## ");
        int escolha = 0;
        boolean stop = true;
        while(stop) {
            try {
                escolha = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }

        return conjPublicacoes.get(escolha - 1);
    }

}
