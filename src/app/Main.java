package src.app;

import java.util.Scanner;
import src.colaboradores.*;
import src.projetos.*;
import src.producaoAcademica.*;

public class Main {

    public static void main(String args[]) {
        System.out.println("#######################################################");
        System.out.println("## Bem vindo, ao Sistema de Produtividade Academica! ##");
        System.out.println("#######################################################");

        // Instancias únicas que vão gerenciar!
        GerenciamentoColaboradores GereColaboradores = new GerenciamentoColaboradores();
        GerenciarProgetos GereProjetos = new GerenciarProgetos();
        GerenProducaoAcad GereProdAcad = new GerenProducaoAcad();
        RelatorioGeral RG = new RelatorioGeral(GereColaboradores, GereProjetos, GereProdAcad);

        GereProjetos.setar(GereColaboradores, GereProdAcad);
        GereProdAcad.setar(GereColaboradores, GereProjetos);


        while (0 != 1) {

            System.out.println("#######################################################");
            System.out.println("##             Escolha uma opcao abaixo!             ##");
            System.out.println("## ------------------------------------------------- ##");
            System.out.println("##             [1] Cadast. Colaboradores!            ##");
            System.out.println("##  [2] Consult. Colaborador! [3] Alocar Colaborador ##");
            System.out.println("## ------------------------------------------------- ##");
            System.out.println("##   [4] Cadast. Projeto!  [5] Consult. projeto!     ##");
            System.out.println("##            [6] Mudar status do projeto!           ##");
            System.out.println("## ------------------------------------------------- ##");
            System.out.println("##         [7] Cadastrar Producao Academica!         ##");
            System.out.println("##              [8] Alocar Publicacao!               ##");
            System.out.println("## ------------------------------------------------- ##");
            System.out.println("##            [9] Relatorio do laboratorio!          ##");
            System.out.println("##               [0] Finalizar Programa!             ##");
            System.out.println("#######################################################");

            System.out.print("## ");
            Scanner teclado = new Scanner(System.in);

            int escolha = Integer.parseInt(teclado.nextLine());
            clearBuffer(teclado);


            // Quer adicionar um colaborador!
            if (escolha == 1)
                GereColaboradores.adicionar();

            // Quer adicionar um Projeto!
            else if (escolha == 4)
                GereProjetos.adicionar();

            // Alocar colaborador!
            else if (escolha == 3)
                GereProjetos.alocar();

            // Quer consultar um colaborador!
            else if (escolha == 2)
                GereColaboradores.consultar();

            // Quer consultar um projeto!
            else if (escolha == 5)
                GereProjetos.consultar();

            // Mudar status projeto!
            else if (escolha == 6)
                GereProjetos.mudarStatus();

            // Cadastrar Prod. Acad.
            else if (escolha == 7)
                GereProdAcad.adicionar();
            
            // ALOCAR PUBLI. PRO PROJETO
            else if (escolha == 8)
                GereProdAcad.alocar();

            // Relatorio geral
            else if (escolha == 9)
                RG.show();

            else if (escolha == 0) {
                System.out.println("## **FINALIZADO!");
                System.out.println("#######################################################");
                break;
            }
        }
    }
    
    private static void clearBuffer(Scanner teclado) {
        System.out.println("## press[ENTER]...");
        if(teclado.hasNextLine()) {
            teclado.nextLine();
        }
    }
}