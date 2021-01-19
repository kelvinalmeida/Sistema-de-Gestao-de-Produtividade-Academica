package src.producaoAcademica.GerenProdAcad;

import src.projetos.*;
import src.colaboradores.*;
import java.util.Vector;
import java.util.Scanner;
import src.utilitarios.*;


import src.producaoAcademica.*;

public class AdOrientacao {

    Scanner teclado = new Scanner(System.in);
    EntradaTeclado entradaTeclado = new EntradaTeclado();

    public Orientacao adicionarOrientacao(GerenciarProgetos gerencProj) {

        Orientacao orientacao = new Orientacao();

        System.out.print("## Escreva a Orientacao: - ");
        String orient = entradaTeclado.entradaString();
        orientacao.setOri(orient);

        System.out.print("## Ano da Orientacao - ");
        int ano = 0;
        
        ano = entradaTeclado.entradaInt();

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
        System.out.println("## Nota do pefessor " + prof.getNome() + "  **ADICIONADO!");

        return orientacao;
    }
}