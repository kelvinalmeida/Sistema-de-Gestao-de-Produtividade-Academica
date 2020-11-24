package src.colaboradores;
import java.util.Scanner;
import java.util.Vector;

public class GerenciamentoColaboradores {
    
    // Vai ficar todos os alunso da graduação!
    Vector<AlunosDeGraduacao> ConjAlunosDeGraduacao = new Vector<AlunosDeGraduacao>();
    Vector<AlunosDeMestado> ConjAlunosDeMestrado = new Vector<AlunosDeMestado>();
    Vector<AlunosDeDoutorado> ConjAlunosDeDoutorado = new Vector<AlunosDeDoutorado>();
    Vector<Professores> ConjProfessores = new Vector<Professores>();
    Vector<Pesquisadores> ConjPesquisadores = new Vector<Pesquisadores>();
    Scanner teclado = new Scanner(System.in);


    ///////////////////////////////////////////////////
    // Parte de cadastro!

    public void adicionar() {
        System.out.println("#######################################################");
        System.out.println("##              Quel o tipo de Colaborador?          ##");
        System.out.println("##  [1] alunos de graduacao  [2] alunosde mestrado   ##");
        System.out.println("##  [3] alunos de doutorado  [4] professores         ##");
        System.out.println("##                [5] pesquisadores                  ##");

        System.out.print("## ");
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

        System.out.print("## Informe o email: ");
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

        System.out.print("## ");
        int consulta = Integer.parseInt(teclado.nextLine());

        if(consulta == 1) listAlunosDeGraduacao();
        if(consulta == 2) listAlunosDeMestrado();
        if(consulta == 3) listAlunosDeDoutorado();
        if(consulta == 4) listProfessores();
        if(consulta == 5) listPesquisadores();
    }

    public void listAlunosDeGraduacao() {

        if(ConjAlunosDeGraduacao.size() == 0){
            System.out.println("## 0 Alunos de graduacao! Cadastre alguns!");
            return;
        }


        System.out.println("##              Qual aluno de graduacao?             ##");
        
        // Listando os alunos de graduação!
        for (int i = 0; i < ConjAlunosDeGraduacao.size(); i++) {
            AlunosDeGraduacao aluno = ConjAlunosDeGraduacao.get(i);
            System.out.println("##" + "["+(i+1)+"]" + aluno.getNome());
        }

        System.out.print("## ");
        int AlunoEscolhido = Integer.parseInt(teclado.nextLine());
        
        // Obtendo o aluno escolhido!
        AlunosDeGraduacao aluno = ConjAlunosDeGraduacao.get(AlunoEscolhido - 1);
        System.out.println("##  Nome: " + aluno.getNome());
        System.out.println("## Email: " + aluno.getEmail());

        // Mostrar os projetos deste aluno!
        aluno.mostrarProjetos();
    }  
    
    public void listAlunosDeMestrado() {

        if(ConjAlunosDeMestrado.size() == 0) {
            System.out.println("## 0 Alunos de Mestrado! Cadastre alguns!");
            return;
        }

        // System.out.println("#######################################################");
        System.out.println("##               Qual aluno de Mestrado?             ##");
        
        // Listando os alunos de Mestrado!
        for (int i = 0; i < ConjAlunosDeMestrado.size(); i++) {
            AlunosDeMestado alunoM = ConjAlunosDeMestrado.get(i);
            System.out.println("##" + "["+(i+1)+"]" + alunoM.getNome());
        }

        System.out.print("## ");
        int AlunoEscolhido = Integer.parseInt(teclado.nextLine());
        
        // Obtendo o aluno escolhido!
        AlunosDeMestado alunoM = ConjAlunosDeMestrado.get(AlunoEscolhido - 1);
        System.out.println("##  Nome: " + alunoM.getNome());
        System.out.println("## Email: " + alunoM.getEmail());  

        alunoM.mostrarProjetos();
    } 
    
    public void listAlunosDeDoutorado() {

        if(ConjAlunosDeDoutorado.size() == 0) {
            System.out.println("## 0 Alunos de Doutorado! Cadastre alguns!");
            return;
        }

        // System.out.println("#######################################################");
        System.out.println("##              Qual aluno de Doutorado?             ##");
        
        // Listando os alunos de Douturado!
        for (int i = 0; i < ConjAlunosDeDoutorado.size(); i++) {
            AlunosDeDoutorado alunoD = ConjAlunosDeDoutorado.get(i);
            System.out.println("##" + "["+(i+1)+"]" + alunoD.getNome());
        }

        System.out.print("## ");
        int AlunoEscolhido = Integer.parseInt(teclado.nextLine());
        
        // Obtendo o aluno escolhido!
        AlunosDeDoutorado alunoD = ConjAlunosDeDoutorado.get(AlunoEscolhido - 1);
        System.out.println("##  Nome: " + alunoD.getNome());
        System.out.println("## Email: " + alunoD.getEmail()); 
        
        alunoD.mostrarProjetos();

    }  

    public void listProfessores() {

        if(ConjProfessores.size() == 0){
            System.out.println("## 0 Professores! Cadastre alguns!");
            return;
        } 

        System.out.println("#######################################################");
        System.out.println("##                   Qual Professor?                 ##");
        
        // Listando os alunos de Douturado!
        for (int i = 0; i < ConjProfessores.size(); i++) {
            Professores alunoP = ConjProfessores.get(i);
            System.out.println("##" + "["+(i+1)+"]" + alunoP.getNome());
        }

        System.out.print("## ");
        int AlunoEscolhido = Integer.parseInt(teclado.nextLine());
        
        // Obtendo o aluno escolhido!
        Professores alunoP = ConjProfessores.get(AlunoEscolhido - 1);
        System.out.println("##  Nome: " + alunoP.getNome());
        System.out.println("## Email: " + alunoP.getEmail());  

        alunoP.mostrarProjetos();
    }  

    public void listPesquisadores() {

        if(ConjPesquisadores.size() == 0){
            System.out.println("## 0 Pesquisadores! Cadastre alguns!");
            return;
        }

        // System.out.println("#######################################################");
        System.out.println("##                  Qual pesquisador?                ##");
        
        // Listando os alunos de Douturado!
        for (int i = 0; i < ConjPesquisadores.size(); i++) {
            Pesquisadores alunoPes = ConjPesquisadores.get(i);
            System.out.println("##" + "["+(i+1)+"]" + alunoPes.getNome());
        }

        System.out.print("## ");
        int AlunoEscolhido = Integer.parseInt(teclado.nextLine());
        
        // Obtendo o aluno escolhido!
        Pesquisadores alunoPes = ConjPesquisadores.get(AlunoEscolhido - 1);
        System.out.println("##  Nome: " + alunoPes.getNome());
        System.out.println("## Email: " + alunoPes.getEmail());  

        alunoPes.mostrarProjetos();
    } 

    //////////////////////////////////////
    // Parte de comunicacao com outro objetos.

    public AlunosDeGraduacao ReturnAlunosGrad() {
        for(int i = 0; i < ConjAlunosDeGraduacao.size(); ++i) {
            AlunosDeGraduacao AlunosGrad = ConjAlunosDeGraduacao.get(i);
            System.out.println("## " + "["+(i+1)+"]" + AlunosGrad.getNome());
        }

        int escoAlunosGrad = Integer.parseInt(teclado.nextLine());

        return ConjAlunosDeGraduacao.get(escoAlunosGrad - 1);
    }

    public AlunosDeMestado ReturnAlunosMest() {
        for(int i = 0; i < ConjAlunosDeMestrado.size(); ++i) {
            AlunosDeMestado AlunosMest = ConjAlunosDeMestrado.get(i);
            System.out.println("## " + "["+(i+1)+"]" + AlunosMest.getNome());
        }

        int escoAlunosMest = Integer.parseInt(teclado.nextLine());

        return ConjAlunosDeMestrado.get(escoAlunosMest - 1);
    }

    public AlunosDeDoutorado ReturnAlunosDout() {
        for(int i = 0; i < ConjAlunosDeDoutorado.size(); ++i) {
            AlunosDeDoutorado AlunosDout = ConjAlunosDeDoutorado.get(i);
            System.out.println("## " + "["+(i+1)+"]" + AlunosDout.getNome());
        }

        int escoAlunosDout = Integer.parseInt(teclado.nextLine());

        return ConjAlunosDeDoutorado.get(escoAlunosDout - 1);
    }

    public Professores ReturnProf() {
        for(int i = 0; i < ConjProfessores.size(); ++i) {
            Professores prof = ConjProfessores.get(i);
            System.out.println("## " + "["+(i+1)+"]" + prof.getNome());
        }

        int escoProf = Integer.parseInt(teclado.nextLine());

        return ConjProfessores.get(escoProf - 1);
    }

    public Pesquisadores ReturnPesq() {
        for(int i = 0; i < ConjPesquisadores.size(); ++i) {
            Pesquisadores pesq = ConjPesquisadores.get(i);
            System.out.println("## " + "["+(i+1)+"]" + pesq.getNome());
        }

        int escoPesq = Integer.parseInt(teclado.nextLine());

        return ConjPesquisadores.get(escoPesq - 1);
    }

    public boolean sizeProf() {
        if(ConjProfessores.size() == 0) return true;
        else return false;
    } 
    
}