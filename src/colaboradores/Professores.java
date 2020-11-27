package src.colaboradores;
import src.producaoAcademica.*;
import src.projetos.*;
import java.util.Vector;

public class Professores extends Colaboradores {

    Vector<Orientacao> ConjOrientacao = new Vector<Orientacao>();

    public void setProjeto(Projeto proj) {
        this.projG.add(proj);
    }

    public void setOri(Orientacao orientacao) {
        ConjOrientacao.add(orientacao);
    }

    public void mostrarOrientacao() {
        System.out.println("## ORIENTACOES:");

        for(int i = 0; i < ConjOrientacao.size(); ++i) {
            Orientacao oriEsco = ConjOrientacao.get(i);
            System.out.println("## Orientacao " + "["+(i+1)+"] Projeto: " + oriEsco.getProj().getTitulo());
            System.out.println("## Nota:" + oriEsco.getOri());
        }
    }

}