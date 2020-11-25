package src.projetos;
import java.util.Scanner;
import java.util.Vector;
import src.colaboradores.*;

public class GerenciarProgetos {

    Vector<Projeto> TodosOsProjetos = new Vector<Projeto>();
    Scanner teclado = new Scanner(System.in);
    GerenciamentoColaboradores GerenColaboradores;
    
    // ponteiro
    public GerenciarProgetos(GerenciamentoColaboradores GerenColaboradores) {
        this.GerenColaboradores = GerenColaboradores;
    }
    
    ///////////////////////////////////////
    // Adicionar Projeto.
    public void adicionar() {
        System.out.println("#######################################################");

        if(GerenColaboradores.sizeProf()) {
            System.out.println("##     Por Favor Adicione um professor ao Sistema!   ##");
            return;
        } 

        System.out.println("##          Digite as Informacoes do Projeto:        ##");
        
        Projeto projeto = new Projeto();
        
        System.out.print("## Titulo: ");
        projeto.setTitulo(teclado.nextLine());
        
        System.out.print("## Dia de Inicio: ");
        projeto.setDiaStart(Integer.parseInt(teclado.nextLine()));
        System.out.print("## Mes de Inicio: ");
        projeto.setMesStart(Integer.parseInt(teclado.nextLine()));
        System.out.print("## Ano de Inicio: ");
        projeto.setAnoStart(Integer.parseInt(teclado.nextLine()));

        System.out.print("## Dia do final: ");
        projeto.setDiaEnd(Integer.parseInt(teclado.nextLine()));
        System.out.print("## Mes do final: ");
        projeto.setMesEnd(Integer.parseInt(teclado.nextLine()));
        System.out.print("## Ano do final: ");
        projeto.setAnoEnd(Integer.parseInt(teclado.nextLine()));
        
        System.out.print("## Agencia Financiadora: ");
        projeto.setAgenciaFinanciadora(teclado.nextLine());
        
        System.out.print("## Valor Financiado: ");
        projeto.setValorFinanciado(Integer.parseInt(teclado.nextLine()));
        
        System.out.print("## Objetivo: ");
        projeto.setObjetivo(teclado.nextLine());
        
        System.out.print("## Descricao: ");
        projeto.setDescricao(teclado.nextLine());
        
        System.out.println("#######################################################");
        System.out.println("##      Qual professor vai particiar do projeto?     ##");

        this.adicionarProfessor(projeto);

        projeto.setEmElaboracao(true);
        projeto.setEmAndamento(false);
        projeto.setConcluido(false);

        TodosOsProjetos.add(projeto);

        System.out.println("## **PROJETO ADICIONADO! ");
    }

    public void adicionarProfessor(Projeto projeto) {
        System.out.println("#######################################################");

        System.out.println("##      Qual professor quer adicionar no projeto?    ##");
        Professores professor = GerenColaboradores.ReturnProf();

        // Projeto(ponteiro) criado no adicionar();
        projeto.addProf(professor);
        professor.setProjeto(projeto);

        System.out.println("## **Professor: " + professor.getNome() + "   **ADICIONADO!");

    }

    /////////////////////////////
    // Consultando projetos

    public void consultar() {
        System.out.println("#######################################################");

        if(TodosOsProjetos.size() == 0) 
                    System.out.println("##               **Nao existe projetos!              ##");

        System.out.println("##               Qual projeto consultar?             ##");

        Projeto projetoConsulta = projetList();

        mostarPojeto(projetoConsulta);
    }

    public void mostarPojeto(Projeto projCons) {
        System.out.println("#######################################################");
        System.out.println("##            Dados do Projeto Escolhido:            ##");
        
        System.out.println("## ---------------------------");

        System.out.println("## Status: " + projCons.getStatus());
        
        System.out.println("## ---------------------------");
        
        System.out.println("## Titulo: " + projCons.getTitulo());
        
        System.out.println("## ---------------------------");
        
        System.out.println("## Data de Inicio: " + 
        projCons.getDiaStart() +"/"+ projCons.getMesStart() +"/"+ projCons.getAnoStart());
        
        System.out.println("## ---------------------------");
        
        System.out.println("## Data de Termino: " + 
        projCons.getDiaEnd() +"/"+ projCons.getMesEnd() +"/"+ projCons.getAnoEnd());
        
        System.out.println("## ---------------------------");
        
        System.out.println("## Agencia Financiadora: " + projCons.getAgenciaFinanciadora());
        
        System.out.println("## ---------------------------");
        
        System.out.println("## Valor Financiado: " + projCons.getValorFinanciado());
        
        System.out.println("## ---------------------------");
        
        System.out.println("## Objetivo: " + projCons.getObjetivo());
        
        System.out.println("## ---------------------------");
        
        System.out.println("## Descricao: " + projCons.getDescricao());
        
        System.out.println("## ---------------------------");
        
        mostrarAlunosDeGraduacao(projCons);
        System.out.println("## ---------------------------");
        mostrarAlunosDeMestrado(projCons);
        System.out.println("## ---------------------------");
        mostrarAlunosDeDoutorado(projCons);
        System.out.println("## ---------------------------");
        mostrarProfessores(projCons);
        System.out.println("## ---------------------------");
        mostrarPesquisadores(projCons);
        System.out.println("## ---------------------------");
    }
    
    public void mostrarAlunosDeGraduacao(Projeto projCons) {
        
        if(projCons.ConjAlunosDeGraduacao.size() == 0) 
                System.out.println("## Alunos de graduacao: 0");

        else {
            System.out.println("## Alunos de graduacao:");
            for (int i = 0; i < projCons.ConjAlunosDeGraduacao.size(); i++) {
                AlunosDeGraduacao AlunosGrad = projCons.ConjAlunosDeGraduacao.get(i);
                System.out.println("## " + (i+1) + "- " + AlunosGrad.getNome());
            }
        }
    }

    public void mostrarAlunosDeMestrado(Projeto projCons) {
        
        if(projCons.ConjAlunosDeMestrado.size() == 0) 
                System.out.println("## Alunos de mestrado: 0");

        else {
            System.out.println("## Alunos de mestrado:");
            for (int i = 0; i < projCons.ConjAlunosDeMestrado.size(); i++) {
                AlunosDeMestado AlunosMest = projCons.ConjAlunosDeMestrado.get(i);
                System.out.println("## " + (i+1) + "- " + AlunosMest.getNome());
            }
        }
    }

    public void mostrarAlunosDeDoutorado(Projeto projCons) {
        
        if(projCons.ConjAlunosDeDoutorado.size() == 0) 
                System.out.println("## Alunos de doutorado: 0");

        else {
            System.out.println("## Alunos de doutorado:");
            for (int i = 0; i < projCons.ConjAlunosDeDoutorado.size(); i++) {
                AlunosDeDoutorado AlunosDout = projCons.ConjAlunosDeDoutorado.get(i);
                System.out.println("## " + (i+1) + "- " + AlunosDout.getNome());
            }
        }
    }

    public void mostrarProfessores(Projeto projCons) {
        
        if(projCons.ConjProfessores.size() == 0) 
                System.out.println("## professores: 0");

        else {
            System.out.println("## professores:");
            for (int i = 0; i < projCons.ConjProfessores.size(); i++) {
                Professores Prof = projCons.ConjProfessores.get(i);
                System.out.println("## " + (i+1) + "- " + Prof.getNome());
            }
        }
    }

    public void mostrarPesquisadores(Projeto projCons) {
        
        if(projCons.ConjPesquisadores.size() == 0) 
                System.out.println("## Pesquisadores: 0");

        else {
            System.out.println("## Pesquisadores:");
            for (int i = 0; i < projCons.ConjPesquisadores.size(); i++) {
                Pesquisadores pesq = projCons.ConjPesquisadores.get(i);
                System.out.println("## " + (i+1) + "- " + pesq.getNome());
            }
        }
    }


    //////////////////////////////////
    // Mudar status de projetos

    public void mudarStatus() {
        System.out.println("#######################################################");
        System.out.println("##                    Qual projeto?                  ##");
        Projeto proj = projetList();

        if(proj.getEmElaboracao() == true){
            System.out.println("## Este projeto esta em Elaboracao.");
            System.out.println("## Deseja mudar para Em Andamento?");
            System.out.println("## [1] SIM OU [2] NAO");
            int escolha = Integer.parseInt(teclado.nextLine());
            if(escolha == 1) {
                proj.setEmElaboracao(false);
                proj.setEmAndamento(true);
                System.out.println("## **Mudado para Em Andamento!");
            }
        }
        // else if(proj.getEmAndamento() == true){
        //     System.out.print("## Este projeto esta Em Andamento.");
        //     System.out.println("## Deseja mudar para Concluido?");
        //     System.out.println("## [1] SIM OU [2] NAO");
        //     int escolha = Integer.parseInt(teclado.nextLine());
        //     if(escolha == 1) {
        //         proj.setEmElaboracao() = false;
        //         proj.getEmAndamento() = true;
        //         System.out.println("## **Mudado Em Andamento!");
        //     }
        // }
                
    }


    /////////////////////////////
    // Alucacao de Participantes!

    public void alocar() {
        
        if(TodosOsProjetos.size() == 0) {
            System.out.println("##  **Nao existe projeto Para alocar colaboradores!  ##");
            System.out.println("##  **Crie um.                                       ##");
            return;
        }

        System.out.println("#######################################################");
        System.out.println("##          Qual tipo de Colaborador Alocar?         ##");
        System.out.println("##  [1] alunos de graduacao  [2] alunosde mestrado   ##");
        System.out.println("##  [3] alunos de doutorado  [4] professores         ##");
        System.out.println("##                [5] pesquisadores                  ##");

        int escolha = Integer.parseInt(teclado.nextLine());

        if(escolha == 1) alocarAlunosGraduacao(); 
        if(escolha == 2) alocarAlunosMestrado(); 
        if(escolha == 3) alocarAlunosDoutorado(); 
        if(escolha == 4) alocarProfessores(); 
        if(escolha == 5) alocarPesquisadores(); 
    }

    public void alocarAlunosGraduacao() {
        System.out.println("#######################################################");
        System.out.println("##             Qual Alu. de Grad. Alocar?            ##");
        
        AlunosDeGraduacao AlunoGraduacao = GerenColaboradores.ReturnAlunosGrad();

        System.out.println("##      Alocar Para [1]projeto ou [2]Publicacao?     ##");
        int escolha = Integer.parseInt(teclado.nextLine());

        if(escolha == 1) {

            System.out.println("##     Escolha o Projeto Para alocar o estudante!    ##");
            Projeto proj = this.projetList();
            
            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                return;   
            }
            
            proj.addAlunoGrad(AlunoGraduacao);
            AlunoGraduacao.setProjeto(proj);

            System.out.println("## Aluno: " + AlunoGraduacao.getNome() + "** AlOCADO!");
        }

        if(escolha == 2) {

            System.out.println("##     Escolha o Publicacao para alocar o estudante!    ##");
            // Projeto proj = this.projetList();
            
            // Regra!
            // if(proj.getEmElaboracao() == false) {
            //     System.out.println("## Pojeto Precisa esta em elaboracao! ##");
            //     return;   
            // }
            
            // proj.addAlunoGrad(AlunoGraduacao);
            // AlunoGraduacao.setProjeto(proj);

            // System.out.println("## Aluno: " + AlunoGraduacao.getNome() + "** AlOCADO!");
        }
    }

    public void alocarAlunosMestrado() {
        System.out.println("#######################################################");
        System.out.println("##             Qual Alu. de Mest. Alocar?            ##");
        
        AlunosDeMestado AlunoMestrado = GerenColaboradores.ReturnAlunosMest();

        System.out.println("##      Alocar Para [1]projeto ou [2]Publicacao?     ##");
        int escolha = Integer.parseInt(teclado.nextLine());

        if(escolha == 1) {
            System.out.println("##     Escolha o Projeto Para alocar o estudante!    ##");
            Projeto proj = this.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                return;   
            }
            
            proj.addAlunoMest(AlunoMestrado);
            AlunoMestrado.setProjeto(proj);
            System.out.println("## Aluno: " + AlunoMestrado.getNome() + "** AlOCADO!");
        }
    }

    public void alocarAlunosDoutorado() {
        System.out.println("#######################################################");
        System.out.println("##             Qual Alu. de Dout. Alocar?            ##");
        
        AlunosDeDoutorado AlunoDoutorado = GerenColaboradores.ReturnAlunosDout();

        System.out.println("##      Alocar Para [1]projeto ou [2]Publicacao?     ##");
        int escolha = Integer.parseInt(teclado.nextLine());

        if(escolha == 1) {
            System.out.println("##     Escolha o Projeto Para alocar o estudante!    ##");
            Projeto proj = this.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                return;   
            }
            
            proj.addAlunoDout(AlunoDoutorado);
            AlunoDoutorado.setProjeto(proj);
            
            System.out.println("## Aluno: " + AlunoDoutorado.getNome() + "** AlOCADO!");
        }
    }

    public void alocarProfessores() {
        System.out.println("#######################################################");
        System.out.println("##                  Qual Prof. Alocar?               ##");
        
        Professores professor = GerenColaboradores.ReturnProf();

        System.out.println("##      Alocar Para [1]projeto ou [2]Publicacao?     ##");
        int escolha = Integer.parseInt(teclado.nextLine());

        if(escolha == 1) {
            System.out.println("##     Escolha o Projeto Para alocar o estudante!    ##");
            Projeto proj = this.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                return;   
            }
            
            proj.addProfessor(professor);
            professor.setProjeto(proj);
            
            System.out.println("## Aluno: " + professor.getNome() + "** AlOCADO!");
        }
    }

    public void alocarPesquisadores() {
        System.out.println("#######################################################");
        System.out.println("##                  Qual Pesq. Alocar?               ##");
        
        // Escolhendo o colaborador
        Pesquisadores pesquisador = GerenColaboradores.ReturnPesq();

        System.out.println("##      Alocar Para [1]projeto ou [2]Publicacao?     ##");
        int escolha = Integer.parseInt(teclado.nextLine());

        if(escolha == 1) {
            System.out.println("##     Escolha o Projeto Para alocar o estudante!    ##");
            // Escolhendo o projeto.
            Projeto proj = this.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                return;   
            }
            
            proj.addPesquisador(pesquisador);
            pesquisador.setProjeto(proj);
            
            System.out.println("## Aluno: " + pesquisador.getNome() + "     ** AlOCADO!");
        }
    }

    //////////////////////////
    // Listando projetos

    public Projeto projetList() {
        for (int i = 0; i < TodosOsProjetos.size(); i++) {
            Projeto proj = TodosOsProjetos.get(i);
            System.out.println("## " + "["+(i+1)+"] - Titulo:" + proj.getTitulo() + "  *Status: " + proj.getStatus());
        }

        int escolha = Integer.parseInt(teclado.nextLine());
        System.out.println("## ");
        return TodosOsProjetos.get(escolha - 1);
    }

    public boolean getSize() {
        if(TodosOsProjetos.size() == 0) return true;
        else return false;
    }

}