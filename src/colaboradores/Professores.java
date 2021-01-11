package src.colaboradores;
import src.producaoAcademica.*;
import src.projetos.*;
import java.util.Vector;

public class Professores extends Colaboradores {

    public int tipoDeAluno = 0;
    Vector<Orientacao> ConjOrientacao = new Vector<Orientacao>();

    public void setProjeto(Projeto proj) {
        this.projG.add(proj);
    }

    public void setOri(Orientacao orientacao) {
        ConjOrientacao.add(orientacao);
    }

    public void mostrarOrientacao() {

        if(ConjOrientacao.size() > 1) this.ordenarOrientacao();

        System.out.println("## ORIENTACOES:");

        for(int i = 0; i < ConjOrientacao.size(); ++i) {
            Orientacao oriEsco = ConjOrientacao.get(i);
            System.out.println("## Orientacao " + "["+(i+1)+"] Projeto: " + oriEsco.getProj().getTitulo() + "  Ano: " + oriEsco.getAno());
            System.out.println("## Nota: " + oriEsco.getOri());
            System.out.println("## ----------------------------- ");
        }
    }

    public void ordenarOrientacao() {
        for (int j = 0; j < ConjOrientacao.size(); j++) {
            for (int i = 0; i < (ConjOrientacao.size() - 1); i++) {
                Orientacao ori1 = ConjOrientacao.get(i);
                Orientacao ori2 = ConjOrientacao.get(i+1);
                Orientacao ori3;
                
                if(ori1.getAno() < ori2.getAno()) {
                    ori3 = ori1;
                    ConjOrientacao.remove(i);
                    ConjOrientacao.add(i, ori2);
                    ConjOrientacao.remove(i+1);
                    ConjOrientacao.add((i+1), ori3);
                }
            }
        }
    }

}