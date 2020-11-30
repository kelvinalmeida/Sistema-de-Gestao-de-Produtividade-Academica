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

    // Ponteiro
    public void setar(GerenciamentoColaboradores gerencColab, GerenciarProgetos gerencProj) {
        this.gerencColab = gerencColab;
        this.gerencProj = gerencProj;
    }

    public void adicionar() {
        System.out.println("#######################################################");
        System.out.println("##           Qual tipo de producao academica?        ##");
        System.out.println("##           [1] Publicacao [2] Orientacao           ##");

        int escolha = Integer.parseInt(teclado.nextLine());
        System.out.println("## ");

        System.out.println("## press[ENTER]...");
        teclado.nextLine();

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
        clearBuffer(teclado);
    }

    public void addOrientacao() {

        Orientacao orientacao = new Orientacao();

        // if(gerencColab.sizeProf()) {
        //     System.out.println("## Por favor, adicione um professor antes!.");
        //     return;
        // }

        if(gerencProj.getSize()) {
            System.out.println("## Por favor, adicione um projeto antes!.");
            System.out.println("## press[ENTER]...");
            teclado.nextLine();
            return;
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
        orientacao.setProj(proj);
        prof.setOri(orientacao);
        ConjOrientacao.add(orientacao);

        System.out.println("## Nota do pefessor " + prof.getNome() + "  **ADICIONADO!");
        System.out.println("## press[ENTER]...");
        teclado.nextLine();
    }

    ////////////////////////
    // Alocar public. para algum projeto.

    public void alocar() {
        if(gerencProj.getSize()){
            System.out.println("## ** Por favor, adicione um projeto antes!");
            return;
        }

        if(ConjPublicacoes.size() == 0) {
            System.out.println("## ** Por favor, adicione uma publicacao antes!");
            return;
        }

        System.out.println("## Escolha a Publicacao:");
        Publicacao publicEscolhida = this.publicacaoList();

        System.out.println("## Escolha um projeto para Inserir a Publicacao:");
        Projeto projetoEscolhido = gerencProj.projetList();
        
        // REGRA!
        if(projetoEscolhido.getEmAndamento() == false) {
            System.out.println("## O projeto precisa está em andamento!");
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
        if(ConjPublicacoes.size() == 0) return true;
        else return false;
    }
    
    public int publicacaoQnt() {
        return ConjPublicacoes.size();
    }

    public int orientacaoQnt() {
        return ConjOrientacao.size();
    }

    public Publicacao publicacaoList() {
        for (int i = 0; i < ConjPublicacoes.size(); i++) {
            Publicacao proj = ConjPublicacoes.get(i);
            System.out.println("## " + "["+(i+1)+"] - Titulo:" + proj.getTitulo());
        }

        int escolha = Integer.parseInt(teclado.nextLine());
        System.out.println("## ");
        return ConjPublicacoes.get(escolha - 1);
    }

}
