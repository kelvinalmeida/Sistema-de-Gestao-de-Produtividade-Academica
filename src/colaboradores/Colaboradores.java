package src.colaboradores;
import src.projetos.*;
import java.util.Vector;
import src.producaoAcademica.*;

public class Colaboradores {
    private String name;
    private String email;

    Vector<Projeto> projG = new Vector<Projeto>();
    Vector<Publicacao> publicacaoG = new Vector<Publicacao>();

    public void setNome(String name) {
        this.name = name;
    }

    public String getNome() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void mostrarProjetos() {

        // System.out.println("## ********************* " + projG.size());
        
        if(projG.size() >= 2) this.ordenar();

        // projG.sort(o1 > o2 ,compare(getAnoEnd() o1, getAnoEnd() o2));
        
        for (int i = 0; i < projG.size(); i++) {
            Projeto proj = projG.get(i);

            if(i == 0) 
                System.out.println("##   Projetos em Elaboracao Cadastrados!             ##");
            if(proj.getEmElaboracao()) {
                System.out.println("## " + "["+(i+1)+"] - Titulo:" + proj.getTitulo() + "  *Status: " + proj.getStatus());
            }
        }

        System.out.println("## -----------------------------------");

        for (int j = 0; j < projG.size(); j++) {
            Projeto proj = projG.get(j);

            if(j == 0) 
                System.out.println("##   Projetos em Andamento Cadastrados!             ##");
            if(proj.getEmAndamento()) {
                System.out.println("## " + "["+(j+1)+"] - Titulo:" + proj.getTitulo() + "  *Status: " + proj.getStatus());
            }
        }

        System.out.println("## -----------------------------------");

        for (int l = 0; l < projG.size(); l++) {
            Projeto proj = projG.get(l);

            if(l == 0) 
                System.out.println("##   Projetos Concluidos!             ##");
            if(proj.getConcluido()) {
                System.out.println("## " + "["+(l+1)+"] - Titulo:" + proj.getTitulo() + "  *Status: " + proj.getStatus());
            }
        }
    }

    public void ordenar() {
        for (int j = 0; j < projG.size(); j++) {
            for (int i = 0; i < (projG.size() - 1); i++) {
                Projeto proj1 = projG.get(i);
                Projeto proj2 = projG.get(i+1);
                Projeto proj3;
                
                if(proj1.getAnoEnd() < proj2.getAnoEnd()) {
                    proj3 = proj1;
                    projG.remove(i);
                    projG.add(i, proj2);
                    projG.remove(i+1);
                    projG.add((i+1), proj3);
                }
            }
        }
    }

    public void projList() {

        for (int i = 0; i < projG.size(); i++) {
            Projeto projL = projG.get(i);
            System.out.println("## " + "["+(i+1)+"]" + projL.getTitulo());            
        }
    }

    public int getQntProjetos() {
        return projG.size();
    }
}