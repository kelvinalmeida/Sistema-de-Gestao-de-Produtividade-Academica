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

    public void setPublicacao(Publicacao publicacaoIns) {
        publicacaoG.add(publicacaoIns);
    }

    public void mostrarPublic() {

        if(publicacaoG.size() >= 2) this.ordenarPublicacoes();

        System.out.println("## PUBLICACOES: ");

        for (int i = 0; i < publicacaoG.size(); i++) {
            Publicacao publicList = publicacaoG.get(i);
            System.out.println("## " + "["+(i+1)+"] - Titulo: " + publicList.getTitulo() + " Ano: " + publicList.getAnoAtual());
            // System.out.println("## ----------------------------- ");
        }
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
                System.out.println("## - Titulo: " + proj.getTitulo() + "  *Status: " + proj.getStatus() + "  Ano de Termino: " + proj.getAnoEnd());
            }
        }

        System.out.println("## -----------------------------------");

        for (int j = 0; j < projG.size(); j++) {
            Projeto proj = projG.get(j);

            if(j == 0)
                System.out.println("##   Projetos em Andamento Cadastrados!             ##");
            if(proj.getEmAndamento()) {
                System.out.println("## - Titulo: " + proj.getTitulo() + "  *Status: " + proj.getStatus() + "  Ano de Termino: " + proj.getAnoEnd());
            }
        }

        System.out.println("## -----------------------------------");

        for (int l = 0; l < projG.size(); l++) {
            Projeto proj = projG.get(l);

            if(l == 0)
                System.out.println("##   Projetos Concluidos!             ##");
            if(proj.getConcluido()) {
                System.out.println("## - Titulo: " + proj.getTitulo() + "  *Status: " + proj.getStatus() + "  Ano de Termino: " + proj.getAnoEnd());
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

    public void ordenarPublicacoes() {
        for (int j = 0; j < publicacaoG.size(); j++) {
            for (int i = 0; i < (publicacaoG.size() - 1); i++) {
                Publicacao publi1 = publicacaoG.get(i);
                Publicacao publi2 = publicacaoG.get(i+1);
                Publicacao publi3;

                if(publi1.getAnoAtual() < publi2.getAnoAtual()) {
                    publi3 = publi1;
                    publicacaoG.remove(i);
                    publicacaoG.add(i, publi2);
                    publicacaoG.remove(i+1);
                    publicacaoG.add((i+1), publi3);
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
