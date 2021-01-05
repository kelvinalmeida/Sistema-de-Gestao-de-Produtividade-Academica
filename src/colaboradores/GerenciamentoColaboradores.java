package src.colaboradores;
import java.util.Scanner;
import java.util.Vector;

public class GerenciamentoColaboradores {

    Vector<Aluno> conjAlunosDeGraduacao = new Vector<Aluno>();
    Vector<Aluno> conjAlunosDeMestrado = new Vector<Aluno>();
    Vector<Aluno> conjAlunosDeDoutorado = new Vector<Aluno>();
    Vector<Professores> conjProfessores = new Vector<Professores>();
    Vector<Pesquisadores> conjPesquisadores = new Vector<Pesquisadores>();
    Scanner teclado = new Scanner(System.in);


    ///////////////////////////////////////////////////
    // Parte de cadastro!

    public void adicionar() {
        System.out.println("#######################################################");
        System.out.println("##              Quel o tipo de Colaborador?          ##");
        System.out.println("##  [1] alunos de graduacao  [2] alunos de mestrado   ##");
        System.out.println("##  [3] alunos de doutorado  [4] professores         ##");
        System.out.println("##                [5] pesquisadores                  ##");

        System.out.print("## ");

        int escolha = 0;
        boolean stop = true;
        while(stop) {
            try {
                escolha = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }

        clearBuffer(teclado);

        // Cadastrando os aluno de graduacao!
        if(escolha == 1) casdAlunosDeGraduacao();
        if(escolha == 2) casdAlunosDeMestrado();
        if(escolha == 3) casdAlunosDeDoutorado();
        if(escolha == 4) casdProfessores();
        if(escolha == 5) casdPesquisadores();

    }

    public void casdAlunosDeGraduacao() {
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

        // Foi para a ultima posicao do array.
        conjAlunosDeGraduacao.add(aluno);

        System.out.println("## **Adicionado! ");
        System.out.println("## press[ENTER]... ");
        teclado.nextLine();
        System.out.println("#######################################################");
    }

    public void casdAlunosDeMestrado() {
        Aluno alunoM = new Aluno();

        System.out.print("## Informe o nome: ");
        String nome = teclado.nextLine();
        alunoM.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = teclado.nextLine();
        alunoM.setEmail(email);

        // Foi para a ultima posicao do array.
        conjAlunosDeMestrado.add(alunoM);
        System.out.println("## **Adicionado! ");
        System.out.println("## press[ENTER]... ");
        teclado.nextLine();
        System.out.println("#######################################################");
    }

    public void casdAlunosDeDoutorado() {
        Aluno alunoD = new Aluno();

        System.out.print("## Informe o nome: ");
        String nome = teclado.nextLine();
        alunoD.setNome(nome);

        System.out.print("## Informe o email: ");
        String email = teclado.nextLine();
        alunoD.setEmail(email);

        // Foi para a ultima posicao do array.
        conjAlunosDeDoutorado.add(alunoD);

        System.out.println("## **Adicionado! ");
        System.out.println("## press[ENTER]... ");
        teclado.nextLine();
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
        conjProfessores.add(alunoP);

        System.out.println("## **Adicionado! ");
        System.out.println("## press[ENTER]... ");
        teclado.nextLine();
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
        conjPesquisadores.add(alunoPes);

        System.out.println("## **Adicionado! ");
        System.out.println("## press[ENTER]... ");
        teclado.nextLine();
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

        int consulta = 0;
        boolean stop = true;
        while(stop) {
            try {
                consulta = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }

        clearBuffer(teclado);

        if(consulta == 1) listAlunosDeGraduacao();
        if(consulta == 2) listAlunosDeMestrado();
        if(consulta == 3) listAlunosDeDoutorado();
        if(consulta == 4) listProfessores();
        if(consulta == 5) listPesquisadores();
    }

    public void listAlunosDeGraduacao() {

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

    public void listAlunosDeMestrado() {

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

    public void listAlunosDeDoutorado() {

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

    public void listProfessores() {

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

    public void listPesquisadores() {

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

    //////////////////////////////////////
    // Parte de comunicacao com outro objetos.

    public void clearBuffer(Scanner teclado) {
        System.out.println("## press[ENTER]...");
        if(teclado.hasNextLine()) {
            teclado.nextLine();
        }
    }

    public Aluno ReturnAlunosGrad() {
        for(int i = 0; i < conjAlunosDeGraduacao.size(); ++i) {
            Aluno AlunosGrad = conjAlunosDeGraduacao.get(i);
            System.out.println("## " + "["+(i+1)+"]" + AlunosGrad.getNome());
        }

        // int escoAlunosGrad = Integer.parseInt(teclado.nextLine());
        int escoAlunosGrad = 0;
        boolean stop = true;
        while(stop) {
            try {
                escoAlunosGrad = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }

        return conjAlunosDeGraduacao.get(escoAlunosGrad - 1);
    }

    public Aluno ReturnAlunosMest() {
        for(int i = 0; i < conjAlunosDeMestrado.size(); ++i) {
            Aluno AlunosMest = conjAlunosDeMestrado.get(i);
            System.out.println("## " + "["+(i+1)+"]" + AlunosMest.getNome());
        }

        // int escoAlunosMest = Integer.parseInt(teclado.nextLine());
        int escoAlunosMest = 0;
        boolean stop = true;
        while(stop) {
            try {
                escoAlunosMest = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }


        return conjAlunosDeMestrado.get(escoAlunosMest - 1);
    }

    public Aluno ReturnAlunosDout() {
        for(int i = 0; i < conjAlunosDeDoutorado.size(); ++i) {
            Aluno AlunosDout = conjAlunosDeDoutorado.get(i);
            System.out.println("## " + "["+(i+1)+"]" + AlunosDout.getNome());
        }

        // int escoAlunosDout = Integer.parseInt(teclado.nextLine());
        int escoAlunosDout = 0;
        boolean stop = true;
        while(stop) {
            try {
                escoAlunosDout = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }


        return conjAlunosDeDoutorado.get(escoAlunosDout - 1);
    }

    public Professores ReturnProf() {
        for(int i = 0; i < conjProfessores.size(); ++i) {
            Professores prof = conjProfessores.get(i);
            System.out.println("## " + "["+(i+1)+"]" + prof.getNome());
        }

        // int escoProf = Integer.parseInt(teclado.nextLine());
        int escoProf = 0;
        boolean stop = true;
        while(stop) {
            try {
                escoProf = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }

        return conjProfessores.get(escoProf - 1);
    }

    public Pesquisadores ReturnPesq() {
        for(int i = 0; i < conjPesquisadores.size(); ++i) {
            Pesquisadores pesq = conjPesquisadores.get(i);
            System.out.println("## " + "["+(i+1)+"]" + pesq.getNome());
        }

        // int escoPesq = Integer.parseInt(teclado.nextLine());
        int escoPesq = 0;
        boolean stop = true;
        while(stop) {
            try {
                escoPesq = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }

        return conjPesquisadores.get(escoPesq - 1);
    }

    public boolean sizeProf() {
        if(conjProfessores.size() == 0) return true;
        else return false;
    }

    public int sizeAlunoGrad() {
        return conjAlunosDeGraduacao.size();
    }

    public int sizeAlunoMest() {
        return conjAlunosDeMestrado.size();
    }

    public int sizeAlunoDout() {
        return conjAlunosDeDoutorado.size();
    }

    public int sizeAlunoPesq() {
        return conjPesquisadores.size();
    }

    public int totalDeColaboradores() {
        int total = 0;
        total += conjAlunosDeGraduacao.size();
        total += conjAlunosDeDoutorado.size();
        total += conjAlunosDeMestrado.size();
        total += conjPesquisadores.size();
        total += conjProfessores.size();

        return total;
    }

}
