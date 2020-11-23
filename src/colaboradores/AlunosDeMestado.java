package src.colaboradores;
import src.projetos.*;
import java.util.Vector;

public class AlunosDeMestado extends Colaboradores {   

    Vector<Projeto> projG = new Vector<Projeto>();

    public void setProjeto(Projeto proj) {
        if(projG.size() == 2){
            System.out.println("## ***"+ getNome() +" ja atingiu o maximo de 2 projetos.");
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

}