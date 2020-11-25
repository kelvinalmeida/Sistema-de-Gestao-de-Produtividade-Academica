package src.colaboradores;
import src.producaoAcademica.*;
import src.projetos.*;
import java.util.Vector;

public class Professores extends Colaboradores {

    Vector<Orientacao> orientacoes = new Vector<Orientacao>();

    public void setProjeto(Projeto proj) {
        this.projG.add(proj);
    }

    public void setOri(Orientacao orientacao) {
        orientacoes.add(orientacao);
    }

}