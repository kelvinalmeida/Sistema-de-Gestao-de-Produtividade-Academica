package src.colaboradores;
import src.projetos.*;
import java.util.Vector;

public class Professores extends Colaboradores {
    Vector<Projeto> projG = new Vector<Projeto>();

    public void setProjeto(Projeto proj) {
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
}