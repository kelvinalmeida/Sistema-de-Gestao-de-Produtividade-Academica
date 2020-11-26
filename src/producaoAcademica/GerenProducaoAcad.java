package src.producaoAcademica;

import src.projetos.*;
import src.colaboradores.*;
import java.util.Vector;
import java.util.Scanner;

public class GerenProducaoAcad {

    Vector<Publicacao> ConjPublicacoes = new Vector<Publicacao>();
    Vector<Orientacao> ConjOrientacao = new Vector<Orientacao>();
    GerenciamentoColaboradores gerencColab;
    GerenciarProgetos gerencProj;
    Scanner teclado = new Scanner(System.in);


    public GerenProducaoAcad(GerenciamentoColaboradores gerencColab, GerenciarProgetos gerencProj) {
        this.gerencColab = gerencColab;
        this.gerencProj = gerencProj;
    }

    public void adicionar() {
        System.out.println("#######################################################");
        System.out.println("##           Qual tipo de producao academica?        ##");
        System.out.println("##           [1] Publicacao [2] Orientacao           ##");

        int escolha = Integer.parseInt(teclado.nextLine());
        System.out.println("## ");

        if (escolha == 1)
            this.addPublicacao();
        if (escolha == 2)
            this.addOrientacao();

    }

    public void addPublicacao() {
        Publicacao publi = new Publicacao();

        System.out.print("## Titulo - ");
        String titulo = teclado.nextLine();
        publi.setTitulo(titulo);

        System.out.print("## Conferencia Aonde Foi Publicada - ");
        String Conf = teclado.nextLine();
        publi.setConferenciaAondeFoiPublicada(Conf);

        System.out.print("## Ano Atual - ");
        int anoAtual = Integer.parseInt(teclado.nextLine());
        publi.setAnoAtual(anoAtual);

        ConjPublicacoes.add(publi);
        System.out.println("## **PUBLICACAO ADICIONADA!");
    }

    public void addOrientacao() {

        Orientacao orientacao = new Orientacao();

        if(gerencColab.sizeProf()) {
            System.out.println("## Por favor, adicione um professor antes!.");
        }

        if(gerencProj.getSize()) {
            System.out.println("## Por favor, adicione um projeto antes!.");    
        }

        System.out.print("## Escreva a Orientacao: - ");
        String orient = teclado.nextLine();
        orientacao.setOri(orient);

        System.out.print("## Ano da Orientacao - ");
        int ano = Integer.parseInt(teclado.nextLine());
        orientacao.setAno(ano);
        
        System.out.println("## Qual projeto vai a orientacao?");
        Projeto proj = gerencProj.projetList();
        proj.setOrientacoes(orientacao);
        
        // Professor do projeto;
        System.out.println("## Qual Professor deste proj vai fazer a Orientacao?");
        Professores prof = proj.profList();
        orientacao.setProf(prof);
        prof.setOri(orientacao);

        System.out.println("## -" + prof.getNome() + " **ADICIONADO!");
    }


    ////////////////////////
    // Alocar public. para algum projeto.

    public void alocar() {

    }

}
