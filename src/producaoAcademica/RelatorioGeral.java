package src.producaoAcademica;

import src.projetos.*;
import src.colaboradores.*;
import java.util.Vector;

public class RelatorioGeral { 
        GerenciamentoColaboradores GereColaboradores;
        GerenciarProgetos GereProjetos;
        GerenProducaoAcad GereProdAcad;
        private int emElaboracao = 0;
        private int emAndamento = 0;
        private int concluido = 0;

    public RelatorioGeral(GerenciamentoColaboradores GereColaboradores, GerenciarProgetos GereProjetos, GerenProducaoAcad GereProdAcad) { 
        this.GereColaboradores = GereColaboradores;
        this.GereProjetos = GereProjetos;
        this.GereProdAcad = GereProdAcad;
    }

    public void show() {
        System.out.println("## ----------------------------------");

        System.out.println("## Numeros de Colaboradores: " + GereColaboradores.totalDeColaboradores());
        
        System.out.println("## ----------------------------------");
        
        Vector<Projeto> Projetos = GereProjetos.TodosProjetos();
        
        if(Projetos.size() == 0) System.out.println(" 0 Projetos");
        else {
            for(int i = 0; i < Projetos.size(); i++) {
                Projeto proj = Projetos.get(i);
                
                if(proj.getEmElaboracao())
                this.emElaboracao += 1;
                if(proj.getEmAndamento())
                this.emAndamento += 1;
                if(proj.getConcluido())
                this.concluido += 1;
            }
            
            System.out.println("## Projetos em Elaboracao: " + this.emElaboracao);
            System.out.println("## Projetos em Andamento: " + this.emAndamento);
            System.out.println("## Projetos Concluidos: " + this.concluido);
            System.out.println("## Total de Projetos: " + Projetos.size());
        }
        
        System.out.println("## ----------------------------------");
        
        System.out.println("## Total de Publicacoes: " + GereProdAcad.publicacaoQnt());
        System.out.println("## Total de Orientacoes: " + GereProdAcad.orientacaoQnt());

        System.out.println("## ----------------------------------");
        
    }
    
    
}

