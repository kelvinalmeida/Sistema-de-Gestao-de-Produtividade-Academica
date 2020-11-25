package src.producaoAcademica;

import src.projetos.*;
import src.colaboradores.*;
import java.util.Vector;
import java.util.Scanner;

public class GerenProducaoAcad { 
    
    Vector<Publicacao> ConjPublicacoes = new Vector<Publicacao>();
    Scanner teclado = new Scanner(System.in);

    public void adicionar() {
        System.out.println("#######################################################");
        System.out.println("##           Qual tipo de producao academica?        ##");
        System.out.println("##           [1] Publicacao [2] Orientacao           ##");

        int escolha = Integer.parseInt(teclado.nextLine());
        System.out.println("## ");

        if(escolha == 1) this.addPublicacao();

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
}