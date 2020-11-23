package src.colaboradores;
import src.projetos.*;
import java.util.Vector;

public class AlunosDeGraduacao extends Colaboradores {
    Vector<Projeto> projG = new Vector<Projeto>();

    public void setProjeto(Projeto proj) {
        if(projG.size() == 2){
            System.out.println("## ***"+ getNome() +" ja atingiu a participacao maxima de 2 projetos.");
            return;
        }
        
        this.projG.add(proj);
    }
    
    public int getQntProjetos() {
        return projG.size();
    }
    
    public void projList() {

        for (int i = 0; i < projG.size(); i++) {
            Projeto projL = projG.get(i);
            System.out.println("## " + "["+(i+1)+"]" + projL.getTitulo());            
        }
    }
    
    public void mostrarProjetos() {

        System.out.println("## ********************* " + projG.size());
        
        // if(projG.size() >= 2) this.ordenar();
        
        for (int i = 0; i < projG.size(); i++) {
            Projeto proj = projG.get(i);

            if(i == 0) 
                System.out.println("##   Projetos em Elaboracao Cadastrados!             ##");
            if(proj.getEmElaboracao()) {
                System.out.println("## " + "["+(i+1)+"] - Titulo:" + proj.getTitulo() + "  *Status: " + proj.getStatus());
            }
        }

        System.out.println("## -----------------------------------");

        for (int i = 0; i < projG.size(); i++) {
            Projeto proj = projG.get(i);

            if(i == 0) 
                System.out.println("##   Projetos em Andamento Cadastrados!             ##");
            if(proj.getEmAndamento()) {
                System.out.println("## " + "["+(i+1)+"] - Titulo:" + proj.getTitulo() + "  *Status: " + proj.getStatus());
            }
        }

        System.out.println("## -----------------------------------");

        for (int i = 0; i < projG.size(); i++) {
            Projeto proj = projG.get(i);

            if(i == 0) 
                System.out.println("##   Projetos em Andamento Cadastrados!             ##");
            if(proj.getConcluido()) {
                System.out.println("## " + "["+(i+1)+"] - Titulo:" + proj.getTitulo() + "  *Status: " + proj.getStatus());
            }
        }

        
    }

    // public void ordenar() {
    //     for (int j = 0; j < projG.size(); j++) {
    //         for (int i = 0; i < (projG.size() - 1); i++) {
    //             Projeto proj1 = projG.get(i);
    //             Projeto proj2 = projG.get(i+1);
    //             Projeto proj3;
                
    //             if(proj1.getAnoEnd() < proj2.getAnoEnd()) {
    //                 proj3 = proj1;
    //                 projG.add(i, proj2);
    //                 projG.add(i+1, proj3);
    //             }
    //         }
    //     }
    // }
}