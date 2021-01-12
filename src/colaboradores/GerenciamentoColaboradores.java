package src.colaboradores;
import java.util.Scanner;
import java.util.Vector;

import src.colaboradores.Gerenciador.*;

public class GerenciamentoColaboradores {

    Vector<Aluno> conjAlunosDeGraduacao = new Vector<Aluno>();
    Vector<Aluno> conjAlunosDeMestrado = new Vector<Aluno>();
    Vector<Aluno> conjAlunosDeDoutorado = new Vector<Aluno>();
    Vector<Professores> conjProfessores = new Vector<Professores>();
    Vector<Pesquisadores> conjPesquisadores = new Vector<Pesquisadores>();
    Scanner teclado = new Scanner(System.in);

    AdicionarColaborador adicionarColaborador = new AdicionarColaborador();
    ConsultarColaborador consultarColaborador = new ConsultarColaborador();


    ///////////////////////////////////////////////////
    // Parte de cadastro!

    public void adicionar() {
        int escolhaTipo = adicionarColaborador.adicionar();

        if(escolhaTipo == 1){
            Aluno alunoG = adicionarColaborador.casdAlunosDeGraduacao();
            conjAlunosDeGraduacao.add(alunoG);
        } 
        
        else if(escolhaTipo == 2) {
            Aluno alunoM = adicionarColaborador.casdAlunosDeMestrado();
            conjAlunosDeMestrado.add(alunoM);
        }

        else if(escolhaTipo == 3) {
            Aluno alunoD = adicionarColaborador.casdAlunosDeDoutorado();
            conjAlunosDeDoutorado.add(alunoD);
        }
        
        else if(escolhaTipo == 4){
            Professores alunoP = adicionarColaborador.casdProfessores();
            conjProfessores.add(alunoP);
        } 
        
        else if(escolhaTipo == 5){
            Pesquisadores alunoPes = adicionarColaborador.casdPesquisadores();
            conjPesquisadores.add(alunoPes);
        }
        
        if(escolhaTipo != 0) {
            System.out.println("## **Adicionado! ");
            System.out.println("## press[ENTER]... ");
            teclado.nextLine();
            System.out.println("#######################################################");  
        }
    }

    ///////////////////////////////////////////////////
    // Parte de consulta!

    public void consultar() {
        int escolhaAluno = consultarColaborador.consultar();

        if(escolhaAluno == 1){
            consultarColaborador.listAlunosDeGraduacao(conjAlunosDeGraduacao);
        } 
        
        else if(escolhaAluno == 2) {
            consultarColaborador.listAlunosDeMestrado(conjAlunosDeMestrado);
        }

        else if(escolhaAluno == 3) {
            consultarColaborador.listAlunosDeDoutorado(conjAlunosDeDoutorado);
        }
        
        else if(escolhaAluno == 4){
            consultarColaborador.listProfessores(conjProfessores);
        } 
        
        else if(escolhaAluno == 5){
            consultarColaborador.listPesquisadores(conjPesquisadores);
        } 
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
