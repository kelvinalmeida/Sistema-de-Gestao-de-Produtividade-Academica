package src.projetos.GerenProjetos;

import src.projetos.*;
import src.colaboradores.*;
import java.util.Vector;
import java.util.Scanner;


import src.projetos.*;

public class AdicionarProjetos {

    Scanner teclado = new Scanner(System.in);

    public Projeto adicionar(GerenciamentoColaboradores GerenColaboradores) {

        System.out.println("##          Digite as Informacoes do Projeto:        ##");

        Projeto projeto = new Projeto();

        System.out.print("## Titulo: ");
        projeto.setTitulo(teclado.nextLine());


        System.out.print("## Dia de Inicio: ");
        int diadeInicio = 0;
        boolean stop = true;
        while(stop) {
            try {
                diadeInicio = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setDiaStart(diadeInicio);
        

        System.out.print("## Mes de Inicio: ");
        int mesdeInicio = 0;
        stop = true;
        while(stop) {
            try {
                mesdeInicio = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setMesStart(mesdeInicio);


        System.out.print("## Ano de Inicio: ");
        int anodeInicio = 0;
        stop = true;
        while(stop) {
            try {
                anodeInicio = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setAnoStart(anodeInicio);

        System.out.print("## Dia do final: ");
        int diaFinal = 0;
        stop = true;
        while(stop) {
            try {
                diaFinal = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setDiaEnd(diaFinal);

        System.out.print("## Mes do final: ");
        int mesFinal = 0;
        stop = true;
        while(stop) {
            try {
                mesFinal = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setMesEnd(mesFinal);

        System.out.print("## Ano do final: ");
        int anoFinal = 0;
        stop = true;
        while(stop) {
            try {
                anoFinal = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setAnoEnd(anoFinal);

        System.out.print("## Agencia Financiadora: ");
        projeto.setAgenciaFinanciadora(teclado.nextLine());

        System.out.print("## Valor Financiado: ");
        int valorFinanciado = 0;
        stop = true;
        while(stop) {
            try {
                valorFinanciado = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setValorFinanciado(valorFinanciado);

        System.out.print("## Objetivo: ");
        projeto.setObjetivo(teclado.nextLine());

        System.out.print("## Descricao: ");
        projeto.setDescricao(teclado.nextLine());

        System.out.println("#######################################################");
        System.out.println("##      Qual professor vai particiar do projeto?     ##");

        this.adicionarProfessor(projeto, GerenColaboradores);

        projeto.setEmElaboracao(true);
        projeto.setEmAndamento(false);
        projeto.setConcluido(false);

        return projeto;
    }

    public void adicionarProfessor(Projeto projeto, GerenciamentoColaboradores GerenColaboradores) {
        System.out.println("#######################################################");

        System.out.println("##      Qual professor quer adicionar no projeto?    ##");
        Professores professor = GerenColaboradores.ReturnProf();

        // Projeto(ponteiro) criado no adicionar();
        projeto.addProf(professor);
        professor.setProjeto(projeto);

        System.out.println("## **Professor: " + professor.getNome() + "   **ADICIONADO!");

    }
}