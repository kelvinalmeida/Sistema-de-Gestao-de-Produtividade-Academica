package src.colaboradores;
import java.util.Scanner;
import java.util.Vector;

public class Cadastro {
    
    // Vai ficar todos os alunso da graduação!
    Vector<AlunosDeGraduacao> ConjAlunosDeGraduacao = new Vector<AlunosDeGraduacao>();
    Vector<AlunosDeMestado> ConjAlunosDeMestrado = new Vector<AlunosDeMestado>();
    Vector<AlunosDeDoutorado> ConjAlunosDeDoutorado = new Vector<AlunosDeDoutorado>();
    Vector<Professores> ConjProfessores = new Vector<Professores>();
    Vector<Pesquisadores> ConjPesquisadores = new Vector<Pesquisadores>();
    Scanner teclado = new Scanner(System.in);

    public void adicionar() {
        System.out.println("#######################################################");
        System.out.println("##              Quel o tipo de Colaborador?          ##");
        System.out.println("##  [1] alunos de graduacao  [2] alunosde mestrado   ##");
        System.out.println("##  [3] alunos de doutorado  [4] professores         ##");
        System.out.println("##                [5] pesquisadores                  ##");

        int escolha = Integer.parseInt(teclado.nextLine());

        // Cadastrando os alunos de graduacao!
        if(escolha == 1) casdAlunosDeGraduacao();
        if(escolha == 2) casdAlunosDeMestrado();
        if(escolha == 3) casdAlunosDeDoutorado();
        if(escolha == 4) casdProfessores();
        if(escolha == 5) casdPesquisadores();

    }

    public void casdAlunosDeGraduacao() {
        AlunosDeGraduacao aluno = new AlunosDeGraduacao();
        System.out.print("## Informe o nome: ");
        String nome = teclado.nextLine();
        aluno.setNome(nome);

        System.out.println("## Informe o email: ");
        String email = teclado.nextLine();
        aluno.setEmail(email);

        // Foi para a ultima posicao do array.
        ConjAlunosDeGraduacao.add(aluno);

        System.out.println("#######################################################");
    }

    public void casdAlunosDeMestrado() {
        AlunosDeMestado alunoM = new AlunosDeMestado();

        System.out.print("## Informe o nome: ");
        String nome = teclado.nextLine();
        alunoM.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = teclado.nextLine();
        alunoM.setEmail(email);

        // Foi para a ultima posicao do array.
        ConjAlunosDeMestrado.add(alunoM);

        System.out.println("#######################################################");
    }

    public void casdAlunosDeDoutorado() {
        AlunosDeDoutorado alunoD = new AlunosDeDoutorado();

        System.out.print("## Informe o nome: ");
        String nome = teclado.nextLine();
        alunoD.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = teclado.nextLine();
        alunoD.setEmail(email);

        // Foi para a ultima posicao do array.
        ConjAlunosDeDoutorado.add(alunoD);

        System.out.println("#######################################################");
    }

    public void casdProfessores() {
        Professores alunoP = new Professores();

        System.out.print("## Informe o nome: ");
        String nome = teclado.nextLine();
        alunoP.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = teclado.nextLine();
        alunoP.setEmail(email);

        // Foi para a ultima posicao do array.
        ConjProfessores.add(alunoP);

        System.out.println("#######################################################");
    }

    public void casdPesquisadores() {
        Pesquisadores alunoPes = new Pesquisadores();

        System.out.print("## Informe o nome: ");
        String nome = teclado.nextLine();
        alunoPes.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = teclado.nextLine();
        alunoPes.setEmail(email);

        // Foi para a ultima posicao do array.
        ConjPesquisadores.add(alunoPes);

        System.out.println("#######################################################");
    }

    ///////////////////////////////////////////////////
    // Parte de consulta!
    public void consultar() {
        System.out.println("#######################################################");
        System.out.println("##       Quer consutar qual tipo de Colaborador?     ##");
        System.out.println("##  [1] alunos de graduacao  [2] alunosde mestrado   ##");
        System.out.println("##  [3] alunos de doutorado  [4] professores         ##");
        System.out.println("##                [5] pesquisadores                  ##");

        int consulta = Integer.parseInt(teclado.nextLine());

        if(consulta == 1) listAlunosDeGraduacao();
    }

    public void listAlunosDeGraduacao() {
        System.out.println("##              Qual aluno de graduacao?             ##");
        
        // Listando os alunos de graduação!
        for (int i = 0; i < ConjAlunosDeGraduacao.size(); i++) {
            AlunosDeGraduacao aluno = ConjAlunosDeGraduacao.get(i);
            System.out.println("##" + "["+(i+1)+"]" + aluno.getNome());
        }
        
        int AlunoEscolhido = Integer.parseInt(teclado.nextLine());
        

    }   
    
}