package src.projetos.GerenProjetos;

import src.projetos.*;
import src.colaboradores.*;
import java.util.Vector;
import java.util.Scanner;
import src.utilitarios.*;


import src.projetos.*;

public class AdicionarProjetos {

    Scanner teclado = new Scanner(System.in);
    EntradaTeclado entradaTeclado = new EntradaTeclado();

    public Projeto adicionar(GerenciamentoColaboradores GerenColaboradores) {

        System.out.println("##          Digite as Informacoes do Projeto:        ##");

        Projeto projeto = new Projeto();

        System.out.print("## Titulo: ");
        projeto.setTitulo(entradaTeclado.entradaString());


        System.out.print("## Dia de Inicio: ");
        int diadeInicio = 0;
        boolean stop = true;
        diadeInicio = entradaTeclado.entradaInt();     
        projeto.setDiaStart(diadeInicio);
        

        System.out.print("## Mes de Inicio: ");
        int mesdeInicio = 0;
        mesdeInicio = entradaTeclado.entradaInt();
        projeto.setMesStart(mesdeInicio);


        System.out.print("## Ano de Inicio: ");
        int anodeInicio = 0;
        anodeInicio = entradaTeclado.entradaInt();
        projeto.setAnoStart(anodeInicio);

        System.out.print("## Dia do final: ");
        int diaFinal = 0;
        diaFinal = entradaTeclado.entradaInt();
        projeto.setDiaEnd(diaFinal);

        System.out.print("## Mes do final: ");
        int mesFinal = 0;
        stop = true;
        mesFinal = entradaTeclado.entradaInt();
        projeto.setMesEnd(mesFinal);

        System.out.print("## Ano do final: ");
        int anoFinal = 0;
        anoFinal = entradaTeclado.entradaInt();
        projeto.setAnoEnd(anoFinal);

        System.out.print("## Agencia Financiadora: ");
        projeto.setAgenciaFinanciadora(entradaTeclado.entradaString());

        System.out.print("## Valor Financiado: ");
        int valorFinanciado = 0;
        valorFinanciado = entradaTeclado.entradaInt();
        projeto.setValorFinanciado(valorFinanciado);

        System.out.print("## Objetivo: ");
        projeto.setObjetivo(entradaTeclado.entradaString());

        System.out.print("## Descricao: ");
        projeto.setDescricao(entradaTeclado.entradaString());

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