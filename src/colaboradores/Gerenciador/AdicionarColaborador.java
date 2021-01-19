package src.colaboradores.Gerenciador;
import java.util.Scanner;
import java.util.Vector;

import src.colaboradores.*;
import src.utilitarios.*;


public class AdicionarColaborador {

    Scanner teclado = new Scanner(System.in);
    EntradaTeclado entradaTeclado = new EntradaTeclado();

    public int adicionar() {
        System.out.println("#######################################################");
        System.out.println("##              Quel o tipo de Colaborador?          ##");
        System.out.println("##  [1] alunos de graduacao  [2] alunos de mestrado  ##");
        System.out.println("##  [3] alunos de doutorado  [4] professores         ##");
        System.out.println("##           [5] pesquisadores [6]Voltar             ##");

        System.out.print("## ");

        int escolha = 0;

        escolha = entradaTeclado.entradaInt();  

        while(1 != 0) {

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
       
        nome = entradaTeclado.entradaString();  

        aluno.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = "email";

        email = entradaTeclado.entradaString(); 

        aluno.setEmail(email);

        aluno.tipoDeAluno = 1;

        return aluno;
    }

    public Aluno casdAlunosDeMestrado() {
        Aluno alunoM = new Aluno();

        System.out.print("## Informe o nome: ");
        String nome = entradaTeclado.entradaString(); 
        alunoM.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = entradaTeclado.entradaString(); 
        alunoM.setEmail(email);

        alunoM.tipoDeAluno = 2;
        return alunoM;
    }

    public Aluno casdAlunosDeDoutorado() {
        Aluno alunoD = new Aluno();

        System.out.print("## Informe o nome: ");
        String nome = entradaTeclado.entradaString(); 
        alunoD.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = entradaTeclado.entradaString(); 
        alunoD.setEmail(email);

        alunoD.tipoDeAluno = 3;
        return alunoD;
    }

    public Professores casdProfessores() {
        Professores alunoP = new Professores();

        System.out.print("## Informe o nome: ");
        String nome = entradaTeclado.entradaString(); 
        alunoP.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = entradaTeclado.entradaString(); 
        alunoP.setEmail(email);

        alunoP.tipoDeAluno = 4;
        return alunoP;
    }

    public Pesquisadores casdPesquisadores() {
        Pesquisadores alunoPes = new Pesquisadores();

        System.out.print("## Informe o nome: ");
        String nome = entradaTeclado.entradaString(); 
        alunoPes.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = entradaTeclado.entradaString(); 
        alunoPes.setEmail(email);

        alunoPes.tipoDeAluno = 5;
        return alunoPes;        
    }
    
}