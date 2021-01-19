package src.projetos.GerenProjetos;

import src.projetos.*;
import src.colaboradores.*;
import src.*;
import src.utilitarios.*;
import java.util.Vector;
import java.util.Scanner;
import src.utilitarios.*;


import src.projetos.*;

public class ConsultarProjeto {

    ClearBuffer clearBuffer = new ClearBuffer();
    
    public void consultar(Projeto projetoConsulta) {

        try {
            mostrarPojeto(projetoConsulta);
        } catch (NumberFormatException nfe) {
            System.err.println("[" + nfe + "] is not an integer" + " and will not be included in the sum.");
        }
    }

    public void mostrarPojeto(Projeto projCons) {
        System.out.println("#######################################################");
        System.out.println("##            Dados do Projeto Escolhido:            ##");

        System.out.println("## ---------------------------");

        System.out.println("## Status: " + projCons.getStatus());

        System.out.println("## ---------------------------");

        System.out.println("## Titulo: " + projCons.getTitulo());

        System.out.println("## ---------------------------");

        System.out.println("## Data de Inicio: " +
        projCons.getDiaStart() +"/"+ projCons.getMesStart() +"/"+ projCons.getAnoStart());

        System.out.println("## ---------------------------");

        System.out.println("## Data de Termino: " +
        projCons.getDiaEnd() +"/"+ projCons.getMesEnd() +"/"+ projCons.getAnoEnd());

        System.out.println("## ---------------------------");

        System.out.println("## Agencia Financiadora: " + projCons.getAgenciaFinanciadora());

        System.out.println("## ---------------------------");

        System.out.println("## Valor Financiado: " + projCons.getValorFinanciado());

        System.out.println("## ---------------------------");

        System.out.println("## Objetivo: " + projCons.getObjetivo());

        System.out.println("## ---------------------------");

        System.out.println("## Descricao: " + projCons.getDescricao());

        System.out.println("## ---------------------------");

        mostrarProducaoAcademica(projCons);

        System.out.println("## ---------------------------");

        mostrarAlunosDeGraduacao(projCons);
        System.out.println("## ---------------------------");
        mostrarAlunosDeMestrado(projCons);
        System.out.println("## ---------------------------");
        mostrarAlunosDeDoutorado(projCons);
        System.out.println("## ---------------------------");
        mostrarProfessores(projCons);
        System.out.println("## ---------------------------");
        mostrarPesquisadores(projCons);
        System.out.println("## ---------------------------");

        clearBuffer.clear();
    }

    public void mostrarAlunosDeGraduacao(Projeto projCons) {

        if(projCons.conjAlunosDeGraduacao.size() == 0)
                System.out.println("## Alunos de graduacao: 0");

        else {
            System.out.println("## Alunos de graduacao:");
            for (int i = 0; i < projCons.conjAlunosDeGraduacao.size(); i++) {
                Aluno AlunosGrad = projCons.conjAlunosDeGraduacao.get(i);
                System.out.println("## " + (i+1) + "- " + AlunosGrad.getNome());
            }
        }
    }

    public void mostrarAlunosDeMestrado(Projeto projCons) {

        if(projCons.conjAlunosDeMestrado.size() == 0)
                System.out.println("## Alunos de mestrado: 0");

        else {
            System.out.println("## Alunos de mestrado:");
            for (int i = 0; i < projCons.conjAlunosDeMestrado.size(); i++) {
                Aluno AlunosMest = projCons.conjAlunosDeMestrado.get(i);
                System.out.println("## " + (i+1) + "- " + AlunosMest.getNome());
            }
        }
    }

    public void mostrarAlunosDeDoutorado(Projeto projCons) {

        if(projCons.conjAlunosDeDoutorado.size() == 0)
                System.out.println("## Alunos de doutorado: 0");

        else {
            System.out.println("## Alunos de doutorado:");
            for (int i = 0; i < projCons.conjAlunosDeDoutorado.size(); i++) {
                Aluno AlunosDout = projCons.conjAlunosDeDoutorado.get(i);
                System.out.println("## " + (i+1) + "- " + AlunosDout.getNome());
            }
        }
    }

    public void mostrarProfessores(Projeto projCons) {

        if(projCons.conjProfessores.size() == 0)
                System.out.println("## professores: 0");

        else {
            System.out.println("## professores:");
            for (int i = 0; i < projCons.conjProfessores.size(); i++) {
                Professores Prof = projCons.conjProfessores.get(i);
                System.out.println("## " + (i+1) + "- " + Prof.getNome());
            }
        }
    }

    public void mostrarPesquisadores(Projeto projCons) {

        if(projCons.conjPesquisadores.size() == 0)
                System.out.println("## Pesquisadores: 0");

        else {
            System.out.println("## Pesquisadores:");
            for (int i = 0; i < projCons.conjPesquisadores.size(); i++) {
                Pesquisadores pesq = projCons.conjPesquisadores.get(i);
                System.out.println("## " + (i+1) + "- " + pesq.getNome());
            }
        }
    }

    public void mostrarProducaoAcademica(Projeto projCons) {

        System.out.println("## PRODUCAO ACADEMICA DO PROJETO!");

        System.out.println("## PUBLICACOES");
        projCons.publicacoesList();

        System.out.println("## ---------------------------------");

        System.out.println("## ORIENTACOES");
        projCons.orientacoesList();

        System.out.println("## ---------------------------------");
    }
}