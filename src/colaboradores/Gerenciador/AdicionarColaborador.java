package src.colaboradores.Gerenciador;
import java.util.Scanner;
import java.util.Vector;

import src.colaboradores.*;

public class AdicionarColaborador {

    Scanner teclado = new Scanner(System.in);

    public int adicionar() {
        System.out.println("#######################################################");
        System.out.println("##              Quel o tipo de Colaborador?          ##");
        System.out.println("##  [1] alunos de graduacao  [2] alunos de mestrado  ##");
        System.out.println("##  [3] alunos de doutorado  [4] professores         ##");
        System.out.println("##           [5] pesquisadores [6]Voltar             ##");

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

    public Aluno casdAlunosDeGraduacao() {
        Aluno aluno = new Aluno();

        System.out.print("## Informe o nome: ");
        String nome = "nome";
        boolean stop = true;
        while(stop) {
            try {
                nome = teclado.nextLine();
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }

        aluno.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = "email";
        stop = true;
        while(stop) {
            try {
                email = teclado.nextLine();
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }

        aluno.setEmail(email);

        aluno.tipoDeAluno = 1;

        return aluno;
    }

    public Aluno casdAlunosDeMestrado() {
        Aluno alunoM = new Aluno();

        System.out.print("## Informe o nome: ");
        String nome = teclado.nextLine();
        alunoM.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = teclado.nextLine();
        alunoM.setEmail(email);

        alunoM.tipoDeAluno = 2;
        return alunoM;
    }

    public Aluno casdAlunosDeDoutorado() {
        Aluno alunoD = new Aluno();

        System.out.print("## Informe o nome: ");
        String nome = teclado.nextLine();
        alunoD.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = teclado.nextLine();
        alunoD.setEmail(email);

        alunoD.tipoDeAluno = 3;
        return alunoD;
    }

    public Professores casdProfessores() {
        Professores alunoP = new Professores();

        System.out.print("## Informe o nome: ");
        String nome = teclado.nextLine();
        alunoP.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = teclado.nextLine();
        alunoP.setEmail(email);

        alunoP.tipoDeAluno = 4;
        return alunoP;
    }

    public Pesquisadores casdPesquisadores() {
        Pesquisadores alunoPes = new Pesquisadores();

        System.out.print("## Informe o nome: ");
        String nome = teclado.nextLine();
        alunoPes.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = teclado.nextLine();
        alunoPes.setEmail(email);

        alunoPes.tipoDeAluno = 5;
        return alunoPes;        
    }

    public void clearBuffer(Scanner teclado) {
        System.out.println("## press[ENTER]...");
        if(teclado.hasNextLine()) {
            teclado.nextLine();
        }
    }
    
}