package src.colaboradores;
import src.projetos.*;
import java.util.Vector;


public class Pesquisadores extends Colaboradores {

    public int tipoDeAluno = 0;

    public void setProjeto(Projeto proj) {
        this.projG.add(proj);
    }
    
}