package src.producaoAcademica;

import src.projetos.*;
import src.colaboradores.*;
import java.util.Vector;
import java.util.Scanner;

public class Orientacao {
    Vector<Professores> ConjProfessores = new Vector<Professores>();
    String orientacao;

    public void setProf(Professores prof) {
        ConjProfessores.add(prof);
    }

    public void setOri(String orientacao) {
        this.orientacao = orientacao;
    }
    public String getOri() {
        return this.orientacao;
    }



}