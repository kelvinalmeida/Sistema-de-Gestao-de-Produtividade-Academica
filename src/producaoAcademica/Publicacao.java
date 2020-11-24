package src.producaoAcademica;

import src.projetos.*;
import src.colaboradores.*;
import java.util.Vector;

public class Publicacao { 
    private String titulo;
    private String conferenciaAondeFoiPublicada;
    private int anoAtual;
    Projeto projAssociado;

    Vector<AlunosDeGraduacao> ConjAlunosDeGraduacao = new Vector<AlunosDeGraduacao>();
    Vector<AlunosDeMestado> ConjAlunosDeMestrado = new Vector<AlunosDeMestado>();
    Vector<AlunosDeDoutorado> ConjAlunosDeDoutorado = new Vector<AlunosDeDoutorado>();
    Vector<Professores> ConjProfessores = new Vector<Professores>();
    Vector<Pesquisadores> ConjPesquisadores = new Vector<Pesquisadores>();
    
    public void addAlunoGrad(AlunosDeGraduacao alunoG) {
        ConjAlunosDeGraduacao.add(alunoG);
    }

    public void addAlunoMest(AlunosDeMestado alunoM) {
        ConjAlunosDeMestrado.add(alunoM);
    }

    public void addAlunoDout(AlunosDeDoutorado alunoD) {
        ConjAlunosDeDoutorado.add(alunoD);
    }

    public void addProfessor(Professores professor) {
        ConjProfessores.add(professor);
    }

    public void addPesquisador(Pesquisadores Pesquisador) {
        ConjPesquisadores.add(Pesquisador);
    }

    public void addProf(Professores prof) {
        ConjProfessores.add(prof);
    }
}
