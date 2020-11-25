package src.projetos;

import java.util.Vector;
import src.colaboradores.*;
import src.producaoAcademica.*;
import java.util.Vector;
import java.util.Scanner;

public class Projeto {
    private String titulo;
    private int diaStart;
    private int mesStart;
    private int anoStart;
    private int diaEnd;
    private int mesEnd;
    private int anoEnd;
    private String agenciaFinanciadora;
    private float valorFinanciado;
    private String objetivo;
    private String descricao;

    Scanner teclado = new Scanner(System.in);

    private Boolean emElaboracao, emAndamento, concluido;

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getTitulo() { return this.titulo; }

    public void setDiaStart(int diaStart) { this.diaStart = diaStart; }
    public int getDiaStart() { return this.diaStart; }

    public void setMesStart(int mesStart) { this.mesStart = mesStart; }
    public int getMesStart() { return this.mesStart; }

    public void setAnoStart(int anoStart) { this.anoStart = anoStart; }
    public int getAnoStart() { return this.anoStart; }

    public void setDiaEnd(int diaEnd) { this.diaEnd = diaEnd; }
    public int getDiaEnd() { return this.diaEnd; }

    public void setMesEnd(int mesEnd) { this.mesEnd = mesEnd; }
    public int getMesEnd() { return this.mesEnd; }

    public void setAnoEnd(int anoEnd) { this.anoEnd = anoEnd; }
    public int getAnoEnd() { return this.anoEnd; }

    public void setAgenciaFinanciadora(String agenciaFinanciadora) 
            { this.agenciaFinanciadora = agenciaFinanciadora; }
    public String getAgenciaFinanciadora() { return this.agenciaFinanciadora; }

    public void setValorFinanciado(float valorFinanciado) 
            { this.valorFinanciado = valorFinanciado; }
    public float getValorFinanciado() { return this.valorFinanciado; }

    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }
    public String getObjetivo() { return this.objetivo; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getDescricao() { return this.descricao; }

    public void setEmElaboracao(Boolean emElaboracao) { this.emElaboracao = emElaboracao; }
    public Boolean getEmElaboracao() { return this.emElaboracao; }
    
    public void setEmAndamento(Boolean emAndamento) { this.emAndamento = emAndamento; }
    public Boolean getEmAndamento() { return this.emAndamento; }

    public void setConcluido(Boolean concluido) { this.concluido = concluido; }
    public Boolean getConcluido() { return this.concluido; }

    public String getStatus() {
        if(getEmElaboracao()) return "Em Elaboracao";
        if(getEmAndamento()) return "Em Andamento";
        if(getConcluido()) return "Concluido";

        return "ERRO!";
    }
    
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

    Vector<Orientacao> ConjOrientacao = new Vector<Orientacao>();
    Vector<Publicacao> ConjPublicacoes = new Vector<Publicacao>();

    public void setPublicacao(Publicacao Publicacao) { 
        ConjPublicacoes.add(Publicacao); 
    }


    ///////////////////////
    // help

    public Professores profList() {
        for (int i = 0; i < ConjProfessores.size(); i++) {
            Professores peofEscol = ConjProfessores.get(i);
            System.out.println("## " + "["+(i+1)+"] - Nome:" + peofEscol.getNome());
        }

        int escolha = Integer.parseInt(teclado.nextLine());
        System.out.println("## ");
        return ConjProfessores.get(escolha - 1);
    }

}