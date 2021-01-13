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
        else if(getEmAndamento()) return "Em Andamento";
        else if(getConcluido()) return "Concluido";

        return "Erro!";
    }
    
    public Vector<Aluno> conjAlunosDeGraduacao = new Vector<Aluno>();
    public Vector<Aluno> conjAlunosDeMestrado = new Vector<Aluno>();
    public Vector<Aluno> conjAlunosDeDoutorado = new Vector<Aluno>();
    public Vector<Professores> conjProfessores = new Vector<Professores>();
    public Vector<Pesquisadores> conjPesquisadores = new Vector<Pesquisadores>();

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

    public void addProf(Professores prof) {
        conjProfessores.add(prof);
    }

    Vector<Orientacao> ConjOrientacao = new Vector<Orientacao>();
    Vector<Publicacao> ConjPublicacoes = new Vector<Publicacao>();

    public void setPublicacao(Publicacao Publicacao) { 
        ConjPublicacoes.add(Publicacao); 
    }

    public void setOrientacoes(Orientacao orientacoes) { 
        ConjOrientacao.add(orientacoes); 
    }


    ///////////////////////
    // help

    public Professores profList() {
        for (int i = 0; i < conjProfessores.size(); i++) {
            Professores peofEscol = conjProfessores.get(i);
            System.out.println("## " + "["+(i+1)+"] - Nome:" + peofEscol.getNome());
        }

        int escolha = Integer.parseInt(teclado.nextLine());
        System.out.println("## ");
        return conjProfessores.get(escolha - 1);
    }

    public void publicacoesList() {

        if(ConjPublicacoes.size() >= 2) this.ordenarPublicacoes();

        for (int i = 0; i < ConjPublicacoes.size(); i++) {
            Publicacao publicEsco = ConjPublicacoes.get(i);
            System.out.println("## " + "["+(i+1)+"] - Nome:" + publicEsco.getTitulo() + " Ano: " + publicEsco.getAnoAtual());
        }
    }

    public void orientacoesList() {

        if(ConjOrientacao.size() >= 2) this.ordenarOrientacoes();

        for (int i = 0; i < ConjOrientacao.size(); i++) {
            Orientacao Orient = ConjOrientacao.get(i);
            Professores ProfEscolhido = Orient.getProf();
            System.out.println("## Orientacao" + "["+(i+1)+"] - Professor: " + ProfEscolhido.getNome() + " Ano: " + Orient.getAno());
            System.out.println("## Nota: " + Orient.getOri());
        }
    }

    public void ordenarPublicacoes() {
        for (int j = 0; j < ConjPublicacoes.size(); j++) {
            for (int i = 0; i < (ConjPublicacoes.size() - 1); i++) {
                Publicacao publi1 = ConjPublicacoes.get(i);
                Publicacao publi2 = ConjPublicacoes.get(i+1);
                Publicacao publi3;
                
                if(publi1.getAnoAtual() < publi2.getAnoAtual()) {
                    publi3 = publi1;
                    ConjPublicacoes.remove(i);
                    ConjPublicacoes.add(i, publi2);
                    ConjPublicacoes.remove(i+1);
                    ConjPublicacoes.add((i+1), publi3);
                }
            }
        }
    }

    public void ordenarOrientacoes() {
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

    public boolean publiacacoesSize() {
        if(ConjPublicacoes.size() == 0) return true;
        else return false;
    }
}