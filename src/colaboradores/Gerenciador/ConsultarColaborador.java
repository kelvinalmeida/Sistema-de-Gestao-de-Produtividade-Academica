package src.colaboradores.Gerenciador;
import java.util.Scanner;
import java.util.Vector;

import src.colaboradores.*;

public class ConsultarColaborador {

    Scanner teclado = new Scanner(System.in);

    public int consultar() {
        System.out.println("#######################################################");
        System.out.println("##       Quer consutar qual tipo de Colaborador?     ##");
        System.out.println("##  [1] alunos de graduacao  [2] alunosde mestrado   ##");
        System.out.println("##  [3] alunos de doutorado  [4] professores         ##");
        System.out.println("##  [5] pesquisadores        [6] VOLTAR              ##");

        System.out.print("## ");

        int escolha = 0;
        boolean stop = true;

        while(1 != 0) {
            while(stop) {
                try {
                    escolha = Integer.parseInt(teclado.nextLine());
                    stop = false;
                } catch(Exception erro) {
                    System.out.println("Digite um valor válido!");
                }
            }

            if(escolha == 1) return 1;
            else if(escolha == 2) return 2;
            else if(escolha == 3) return 3;
            else if(escolha == 4) return 4;
            else if(escolha == 5) return 5;
            else if(escolha == 6) return 0;

            System.out.println("Escolha um valor valido.");
        }
    }

    public void listAlunosDeGraduacao(Vector<Aluno> conjAlunosDeGraduacao) {

        if(conjAlunosDeGraduacao.size() == 0){
            System.out.println("## 0 Alunos de graduacao! Cadastre alguns!");
            return;
        }


        System.out.println("##              Qual aluno de graduacao?             ##");

        // Listando os aluno de graduação!
        for (int i = 0; i < conjAlunosDeGraduacao.size(); i++) {
            Aluno aluno = conjAlunosDeGraduacao.get(i);
            System.out.println("## " + "["+(i+1)+"] - " + aluno.getNome());
        }

        System.out.print("## ");
        int AlunoEscolhido = 0;
        boolean stop = true;
        while(stop) {
            try {
                AlunoEscolhido = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }



        // Obtendo o aluno escolhido!
        Aluno aluno = conjAlunosDeGraduacao.get(AlunoEscolhido - 1);

        System.out.println("## ---------------------------------------");
        System.out.println("## Nome: " + aluno.getNome());
        System.out.println("## Email: " + aluno.getEmail());
        System.out.println("## ---------------------------------------");

        // Mostrar os projetos deste aluno!
        aluno.mostrarProjetos();
        System.out.println("## ---------------------------------------");
        aluno.mostrarPublic();
        System.out.println("## ---------------------------------------");

        System.out.println("## press[ENTER]... ");
        teclado.nextLine();
    }

    public void listAlunosDeMestrado(Vector<Aluno> conjAlunosDeMestrado) {

        if(conjAlunosDeMestrado.size() == 0) {
            System.out.println("## 0 Alunos de Mestrado! Cadastre alguns!");
            return;
        }

        // System.out.println("#######################################################");
        System.out.println("##               Qual aluno de Mestrado?             ##");

        // Listando os aluno de Mestrado!
        for (int i = 0; i < conjAlunosDeMestrado.size(); i++) {
            Aluno alunoM = conjAlunosDeMestrado.get(i);
            System.out.println("## " + "["+(i+1)+"] - " + alunoM.getNome());
        }

        System.out.print("## ");
        int AlunoEscolhido = 0;
        boolean stop = true;
        while(stop) {
            try {
                AlunoEscolhido = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }


        // Obtendo o aluno escolhido!
        Aluno alunoM = conjAlunosDeMestrado.get(AlunoEscolhido - 1);
        System.out.println("## Nome: " + alunoM.getNome());
        System.out.println("## Email: " + alunoM.getEmail());

        alunoM.mostrarProjetos();
        System.out.println("## -----------------------------------");
        alunoM.mostrarPublic();
        System.out.println("## -----------------------------------");

        System.out.println("## press[ENTER]... ");
        teclado.nextLine();
    }

    public void listAlunosDeDoutorado(Vector<Aluno> conjAlunosDeDoutorado) {

        if(conjAlunosDeDoutorado.size() == 0) {
            System.out.println("## 0 Aluno de Doutorado! Cadastre alguns!");
            return;
        }

        // System.out.println("#######################################################");
        System.out.println("##              Qual aluno de Doutorado?             ##");

        // Listando os aluno de Douturado!
        for (int i = 0; i < conjAlunosDeDoutorado.size(); i++) {
            Aluno alunoD = conjAlunosDeDoutorado.get(i);
            System.out.println("## " + "["+(i+1)+"] - " + alunoD.getNome());
        }

        System.out.print("## ");
        int AlunoEscolhido = 0;
        boolean stop = true;
        while(stop) {
            try {
                AlunoEscolhido = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }


        // Obtendo o aluno escolhido!
        Aluno alunoD = conjAlunosDeDoutorado.get(AlunoEscolhido - 1);
        System.out.println("## Nome: " + alunoD.getNome());
        System.out.println("## Email: " + alunoD.getEmail());

        alunoD.mostrarProjetos();
        System.out.println("## -----------------------------------");
        alunoD.mostrarPublic();
        System.out.println("## -----------------------------------");

        System.out.println("## press[ENTER]... ");
        teclado.nextLine();
    }

    public void listProfessores(Vector<Professores> conjProfessores) {

        if(conjProfessores.size() == 0){
            System.out.println("## 0 Professores! Cadastre alguns!");
            return;
        }

        System.out.println("#######################################################");
        System.out.println("##                   Qual Professor?                 ##");

        // Listando os aluno de Douturado!
        for (int i = 0; i < conjProfessores.size(); i++) {
            Professores alunoP = conjProfessores.get(i);
            System.out.println("## " + "["+(i+1)+"] - "+ alunoP.getNome());
        }

        System.out.print("## ");
        int AlunoEscolhido = 0;
        boolean stop = true;
        while(stop) {
            try {
                AlunoEscolhido = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }


        // Obtendo o aluno escolhido!
        Professores alunoP = conjProfessores.get(AlunoEscolhido - 1);
        System.out.println("## Nome: " + alunoP.getNome());
        System.out.println("## Email: " + alunoP.getEmail());

        alunoP.mostrarProjetos();
        System.out.println("## -----------------------------------");
        alunoP.mostrarPublic();
        System.out.println("## -----------------------------------");
        alunoP.mostrarOrientacao();
        System.out.println("## -----------------------------------");

        System.out.println("## press[ENTER]... ");
        teclado.nextLine();
    }

    public void listPesquisadores(Vector<Pesquisadores> conjPesquisadores) {

        if(conjPesquisadores.size() == 0){
            System.out.println("## 0 Pesquisadores! Cadastre alguns!");
            return;
        }

        // System.out.println("#######################################################");
        System.out.println("##                  Qual pesquisador?                ##");

        // Listando os aluno de Douturado!
        for (int i = 0; i < conjPesquisadores.size(); i++) {
            Pesquisadores alunoPes = conjPesquisadores.get(i);
            System.out.println("## " + "["+(i+1)+"] - " + alunoPes.getNome());
        }

        System.out.print("## ");
        int AlunoEscolhido = 0;
        boolean stop = true;
        while(stop) {
            try {
                AlunoEscolhido = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }


        // Obtendo o aluno escolhido!
        Pesquisadores alunoPes = conjPesquisadores.get(AlunoEscolhido - 1);
        System.out.println("## Nome: " + alunoPes.getNome());
        System.out.println("## Email: " + alunoPes.getEmail());

        alunoPes.mostrarProjetos();
        System.out.println("## -----------------------------------");
        alunoPes.mostrarPublic();
        System.out.println("## -----------------------------------");

        System.out.println("## press[ENTER]... ");
        teclado.nextLine();
    }

    public void clearBuffer(Scanner teclado) {
        System.out.println("## press[ENTER]...");
        if(teclado.hasNextLine()) {
            teclado.nextLine();
        }
    }
}