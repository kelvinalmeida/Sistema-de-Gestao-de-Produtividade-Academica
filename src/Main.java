package src;

import java.util.Scanner;
import src.colaboradores.*;
import src.projetos.*;
import src.producaoAcademica.*;

public class Main {

    public static void main(String args[]) {
        System.out.println("#######################################################");
        System.out.println("## Bem vindo, ao Sistema de Produtividade Academica! ##");
        System.out.println("#######################################################");

        // Instancias únicas que vão gerenciar! - Singleton
        GerenciamentoColaboradores gereColaboradores = new GerenciamentoColaboradores();
        GerenciarProgetos gereProjetos = new GerenciarProgetos();
        GerenProducaoAcad gereProdAcad = new GerenProducaoAcad();
        RelatorioGeral rg = new RelatorioGeral(gereColaboradores, gereProjetos, gereProdAcad);

        gereProjetos.setar(gereColaboradores, gereProdAcad, gereProjetos);
        gereProdAcad.setar(gereColaboradores, gereProjetos);

        ClearBuffer clearBuffer = new ClearBuffer();


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

            int escolha = 0;
            
            boolean stop = true;
            while(stop) {
                try {
                    escolha = Integer.parseInt(teclado.nextLine());
                    stop = false;
                } catch(Exception erro) {
                    // System.out.println("Digite um valor válido!");
                }
            }

            clearBuffer.clear();

            // Quer adicionar um colaborador!
            if (escolha == 1)
                gereColaboradores.adicionar();

            // Quer adicionar um Projeto!
            else if (escolha == 4)
                gereProjetos.adicionar();

            // Alocar colaborador!
            else if (escolha == 3)
                gereProjetos.alocar();

            // Quer consultar um colaborador!
            else if (escolha == 2)
                gereColaboradores.consultar();

            // Quer consultar um projeto!
            else if (escolha == 5)
                gereProjetos.consultar();

            // Mudar status projeto!
            else if (escolha == 6)
                gereProjetos.mudarStatus();

            // Cadastrar Prod. Acad.
            else if (escolha == 7)
                gereProdAcad.adicionar();
            
            // ALOCAR PUBLI. PRO PROJETO
            else if (escolha == 8)
                gereProdAcad.alocar();

            // Relatorio geral
            else if (escolha == 9)
                rg.show();

            else if (escolha == 0) {
                System.out.println("## **PROGRAMA FINALIZADO!");
                System.out.println("#######################################################");
                break;
            }
        }
    }
}