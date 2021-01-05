package src.producaoAcademica;

import src.projetos.*;
import src.colaboradores.*;
import java.util.Vector;

public class Publicacao {
    private String titulo;
    private String conferenciaAondeFoiPublicada;
    private int anoAtual;
    Projeto projAssociado;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setConferenciaAondeFoiPublicada(String conferenciaAondeFoiPublicada) {
        this.conferenciaAondeFoiPublicada = conferenciaAondeFoiPublicada;
    }

    public String getConferenciaAondeFoiPublicada() {
        return this.conferenciaAondeFoiPublicada;
    }

    public void setAnoAtual(int anoAtual) {
        this.anoAtual = anoAtual;
    }

    public int getAnoAtual() {
        return this.anoAtual;
    }

    Vector<Aluno> conjAlunosDeGraduacao = new Vector<Aluno>();
    Vector<Aluno> conjAlunosDeMestrado = new Vector<Aluno>();
    Vector<Aluno> conjAlunosDeDoutorado = new Vector<Aluno>();
    Vector<Professores> conjProfessores = new Vector<Professores>();
    Vector<Pesquisadores> conjPesquisadores = new Vector<Pesquisadores>();

    public void addAlunoGrad(Aluno alunoG) {
        conjAlunosDeGraduacao.add(alunoG);
    }

    public void addAlunoMest(Aluno alunoM) {
        conjAlunosDeMestrado.add(alunoM);
    }

    public void addAlunoDout(Aluno alunoD) {
        conjAlunosDeDoutorado.add(alunoD);
    }

    public void addProfessor(Professores professor) {
        conjProfessores.add(professor);
    }

    public void addPesquisador(Pesquisadores Pesquisador) {
        conjPesquisadores.add(Pesquisador);
    }
}
