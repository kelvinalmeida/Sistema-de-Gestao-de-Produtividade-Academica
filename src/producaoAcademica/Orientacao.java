package src.producaoAcademica;

import src.projetos.*;
import src.colaboradores.*;
import java.util.Vector;
import java.util.Scanner;

public class Orientacao {
    private Professores professor;
    private String orientacao;
    private int ano; 
    private Projeto proj;

    public void setProf(Professores professor) {
        this.professor = professor;
    }

    public void setProj(Projeto proj) {
        this.proj = proj;
    }

    public Projeto getProj() {
        return this.proj;
    }

    public Professores getProf() {
        return this.professor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAno() {
        return this.ano;
    }

    public void setOri(String orientacao) {
        this.orientacao = orientacao;
    }
    public String getOri() {
        return this.orientacao;
    }



}