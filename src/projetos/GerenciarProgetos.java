package src.projetos;
import java.util.Scanner;
import java.util.Vector;
import src.colaboradores.*;
import src.producaoAcademica.*;

public class GerenciarProgetos {

    Vector<Projeto> TodosOsProjetos = new Vector<Projeto>();
    Scanner teclado = new Scanner(System.in);
    GerenciamentoColaboradores GerenColaboradores;
    GerenProducaoAcad GerenProdAcademica;

    // ponteiro

    public void setar(GerenciamentoColaboradores GerenColaboradores, GerenProducaoAcad GerenProdAcademica) {
        this.GerenColaboradores = GerenColaboradores;
        this.GerenProdAcademica = GerenProdAcademica;
    }

    ///////////////////////////////////////
    // Adicionar Projeto.
    public void adicionar() {
        System.out.println("#######################################################");

        if(GerenColaboradores.sizeProf()) {
            System.out.println("##     Por Favor Adicione um professor ao Sistema!   ##");
            System.out.println("## press[ENTER]...");
            teclado.nextLine();
            return;
        }

        // clearBuffer(teclado);

        System.out.println("##          Digite as Informacoes do Projeto:        ##");

        Projeto projeto = new Projeto();

        System.out.print("## Titulo: ");
        projeto.setTitulo(teclado.nextLine());


        System.out.print("## Dia de Inicio: ");
        int diadeInicio = 0;
        boolean stop = true;
        while(stop) {
            try {
                diadeInicio = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setDiaStart(diadeInicio);
        

        System.out.print("## Mes de Inicio: ");
        int mesdeInicio = 0;
        stop = true;
        while(stop) {
            try {
                mesdeInicio = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setMesStart(mesdeInicio);


        System.out.print("## Ano de Inicio: ");
        int anodeInicio = 0;
        stop = true;
        while(stop) {
            try {
                anodeInicio = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setAnoStart(anodeInicio);

        System.out.print("## Dia do final: ");
        int diaFinal = 0;
        stop = true;
        while(stop) {
            try {
                diaFinal = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setDiaEnd(diaFinal);

        System.out.print("## Mes do final: ");
        int mesFinal = 0;
        stop = true;
        while(stop) {
            try {
                mesFinal = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setMesEnd(mesFinal);

        System.out.print("## Ano do final: ");
        int anoFinal = 0;
        stop = true;
        while(stop) {
            try {
                anoFinal = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setAnoEnd(anoFinal);

        System.out.print("## Agencia Financiadora: ");
        projeto.setAgenciaFinanciadora(teclado.nextLine());

        System.out.print("## Valor Financiado: ");
        int valorFinanciado = 0;
        stop = true;
        while(stop) {
            try {
                valorFinanciado = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                // System.out.println("Digite um valor válido!");
            }
        }
        projeto.setValorFinanciado(valorFinanciado);

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
        System.out.println("## press[ENTER]... ");
        teclado.nextLine();
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

        if(TodosOsProjetos.size() == 0) {
            System.out.println("##               **Nao existe projetos!              ##");
            System.out.println("## press[ENTER]...");
            teclado.nextLine();
            return;
        }

        System.out.println("##               Qual projeto consultar?             ##");

        Projeto projetoConsulta = projetList();
        // clearBuffer(teclado);

        try {
            mostrarPojeto(projetoConsulta);
        } catch (NumberFormatException nfe) {
            System.err.println("[" + nfe + "] is not an integer" + " and will not be included in the sum.");
        }
    }

    public void mostrarPojeto(Projeto projCons) {
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

        mostrarProducaoAcademica(projCons);

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

        System.out.println("## press[ENTER]...");
        teclado.nextLine();
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

    public void mostrarProducaoAcademica(Projeto projCons) {

        System.out.println("## PRODUCAO ACADEMICA DO PROJETO!");

        System.out.println("## PUBLICACOES");
        projCons.publicacoesList();

        System.out.println("## ---------------------------------");

        System.out.println("## ORIENTACOES");
        projCons.orientacoesList();

        System.out.println("## ---------------------------------");
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
            
            if(escolha == 1) {
                proj.setEmElaboracao(false);
                proj.setEmAndamento(true);
                System.out.println("## **Mudado para Em Andamento!");
            }
            if(escolha == 2) {
                System.out.println("## **Continua em elaboracao!");
            }

            System.out.println("## press[ENTER]...");
            teclado.nextLine();
        }
        else if(proj.getEmAndamento() == true){
            System.out.println("## Este projeto esta Em Andamento.");
            System.out.println("## Deseja mudar para Concluido?");
            System.out.println("## [1] SIM OU [2] NAO");

            // int escolha = Integer.parseInt(teclado.nextLine());
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

            if(proj.publiacacoesSize()) {
                System.out.println("## Adicione uma publicacao ao projeto antes!");
                System.out.println("## press[ENTER]... ");
                teclado.nextLine();
                return;
            }

            if(escolha == 1) {
                proj.setEmAndamento(false);
                proj.setConcluido(true);
                System.out.println("## **Mudado Para Concluido!");
            }
            if(escolha == 2) {
                System.out.println("## **Continua em andamento!");
            }

            System.out.println("## press[ENTER]...");
            teclado.nextLine();
        }

    }

    /////////////////////////////
    // Alucacao de Participantes para projetos!

    public void alocar() {

        if(TodosOsProjetos.size() == 0) {
            System.out.println("##  **Nao existe projeto Para alocar colaboradores!  ##");
            System.out.println("##  **Crie um.                                       ##");
            System.out.println("## press[ENTER]...");
            teclado.nextLine();
            return;
        }

        System.out.println("#######################################################");
        System.out.println("##          Qual tipo de Colaborador Alocar?         ##");
        System.out.println("##  [1] alunos de graduacao  [2] alunosde mestrado   ##");
        System.out.println("##  [3] alunos de doutorado  [4] professores         ##");
        System.out.println("##                [5] pesquisadores                  ##");

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

        if(escolha == 1) alocarAlunosGraduacao();
        if(escolha == 2) alocarAlunosMestrado();
        if(escolha == 3) alocarAlunosDoutorado();
        if(escolha == 4) alocarProfessores();
        if(escolha == 5) alocarPesquisadores();
    }

    public void alocarAlunosGraduacao() {

        if(GerenColaboradores.sizeAlunoGrad() == 0) {
            System.out.println("## **Adicine um aluno de Graduacao.");
            System.out.println("## press[ENTER]...");
            teclado.nextLine();
            return;
        }

        System.out.println("#######################################################");
        System.out.println("##             Qual Alu. de Grad. Alocar?            ##");

        AlunosDeGraduacao AlunoGraduacao = GerenColaboradores.ReturnAlunosGrad();

        System.out.println("##      Alocar Para [1]projeto ou [2]Publicacao?     ##");
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
        

        if(escolha == 1) {

            if(AlunoGraduacao.getQntProjetos() == 2) {
                System.out.println("## ***"+ AlunoGraduacao.getNome() +" ja atingiu a participacao maxima de 2 projetos.");

                System.out.println("## press[ENTER]... ");
                teclado.nextLine();
                return;
            }

            System.out.println("##     Escolha o Projeto Para alocar o estudante!    ##");
            Projeto proj = this.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                System.out.println("## press[ENTER]... ");
                teclado.nextLine();
                return;
            } else {
                proj.addAlunoGrad(AlunoGraduacao);
                AlunoGraduacao.setProjeto(proj);

                System.out.println("## Aluno: " + AlunoGraduacao.getNome() + "** AlOCADO!");
                System.out.println("## press[ENTER]... ");
                teclado.nextLine();
            }
        }

        if(escolha == 2) {

            if(GerenProdAcademica.publicacaoSize()) {
                System.out.println("##  Adicione uma publicacao antes!   ##");
                System.out.println("## press[ENTER]... ");
                teclado.nextLine();
                return;
            }

            System.out.println("##     Escolha o Publicacao para alocar o estudante!    ##");
            Publicacao pubEsco = GerenProdAcademica.publicacaoList();

            pubEsco.addAlunoGrad(AlunoGraduacao);
            AlunoGraduacao.setPublicacao(pubEsco);

            System.out.println("## Aluno: " + AlunoGraduacao.getNome() + "** AlOCADO!");
            System.out.println("## press[ENTER]... ");
            teclado.nextLine();
        }
    }

    public void alocarAlunosMestrado() {

        if(GerenColaboradores.sizeAlunoMest() == 0) {
            System.out.println("## **Adicine um aluno de Mestrado.");
            System.out.println("## press[ENTER]...");
            teclado.nextLine();
            return;
        }

        System.out.println("#######################################################");
        System.out.println("##             Qual Alu. de Mest. Alocar?            ##");

        AlunosDeMestado AlunoMestrado = GerenColaboradores.ReturnAlunosMest();

        System.out.println("##      Alocar Para [1]projeto ou [2]Publicacao?     ##");
        // int escolha = Integer.parseInt(teclado.nextLine());
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

        if(escolha == 1) {
            System.out.println("##     Escolha o Projeto Para alocar o estudante!    ##");
            Projeto proj = this.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                System.out.println("## press[ENTER]... ");
                teclado.nextLine();
                return;
            }

            proj.addAlunoMest(AlunoMestrado);
            AlunoMestrado.setProjeto(proj);
            System.out.println("## Aluno: " + AlunoMestrado.getNome() + "** AlOCADO!");
            System.out.println("## press[ENTER]... ");
            teclado.nextLine();
        }

        if(escolha == 2) {

            if(GerenProdAcademica.publicacaoSize()) {
                System.out.println("##  Adicione uma publicacao antes!   ##");
                System.out.println("## press[ENTER]... ");
                teclado.nextLine();
                return;
            }

            System.out.println("##     Escolha o Publicacao para alocar o estudante!    ##");
            Publicacao pubEsco = GerenProdAcademica.publicacaoList();

            pubEsco.addAlunoMest(AlunoMestrado);
            AlunoMestrado.setPublicacao(pubEsco);

            System.out.println("## Aluno: " + AlunoMestrado.getNome() + "** AlOCADO!");
            System.out.println("## press[ENTER]... ");
            teclado.nextLine();
        }
    }

    public void alocarAlunosDoutorado() {

        if(GerenColaboradores.sizeAlunoDout() == 0) {
            System.out.println("## **Adicine um aluno de Doutorado.");
            System.out.println("## press[ENTER]...");
            teclado.nextLine();
            return;
        }

        System.out.println("#######################################################");
        System.out.println("##             Qual Alu. de Dout. Alocar?            ##");

        AlunosDeDoutorado AlunoDoutorado = GerenColaboradores.ReturnAlunosDout();

        System.out.println("##      Alocar Para [1]projeto ou [2]Publicacao?     ##");
        // int escolha = Integer.parseInt(teclado.nextLine());
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

        if(escolha == 1) {
            System.out.println("##     Escolha o Projeto Para alocar o estudante!    ##");
            Projeto proj = this.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                System.out.println("## press[ENTER]... ");
                teclado.nextLine();
                return;
            }

            proj.addAlunoDout(AlunoDoutorado);
            AlunoDoutorado.setProjeto(proj);

            System.out.println("## Aluno: " + AlunoDoutorado.getNome() + "** AlOCADO!");
            System.out.println("## press[ENTER]... ");
            teclado.nextLine();
        }
        if(escolha == 2) {

            if(GerenProdAcademica.publicacaoSize()) {
                System.out.println("##  Adicione uma publicacao antes!   ##");
                System.out.println("## press[ENTER]... ");
                teclado.nextLine();
                return;
            }

            System.out.println("##     Escolha o Publicacao para alocar o estudante!    ##");
            Publicacao pubEsco = GerenProdAcademica.publicacaoList();

            pubEsco.addAlunoDout(AlunoDoutorado);
            AlunoDoutorado.setPublicacao(pubEsco);

            System.out.println("## Aluno: " + AlunoDoutorado.getNome() + "** AlOCADO!");
            System.out.println("## press[ENTER]... ");
            teclado.nextLine();
        }
    }

    public void alocarProfessores() {

        if(GerenColaboradores.sizeProf()) {
            System.out.println("## **Adicine um aluno um Professor.");
            System.out.println("## press[ENTER]...");
            teclado.nextLine();
            return;
        }

        System.out.println("#######################################################");
        System.out.println("##                  Qual Prof. Alocar?               ##");

        Professores professor = GerenColaboradores.ReturnProf();

        System.out.println("##      Alocar Para [1]projeto ou [2]Publicacao?     ##");
        // int escolha = Integer.parseInt(teclado.nextLine());
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

        if(escolha == 1) {
            System.out.println("##     Escolha o Projeto Para alocar o estudante!    ##");
            Projeto proj = this.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                System.out.println("## press[ENTER]... ");
                teclado.nextLine();
                return;
            }

            proj.addProfessor(professor);
            professor.setProjeto(proj);

            System.out.println("## Aluno: " + professor.getNome() + "** AlOCADO!");
            System.out.println("## press[ENTER]... ");
            teclado.nextLine();
        }
        if(escolha == 2) {

            if(GerenProdAcademica.publicacaoSize()) {
                System.out.println("##  Adicione uma publicacao antes!   ##");
                System.out.println("## press[ENTER]... ");
                teclado.nextLine();
                return;
            }

            System.out.println("##     Escolha o Publicacao para alocar o estudante!    ##");
            Publicacao pubEsco = GerenProdAcademica.publicacaoList();

            pubEsco.addProfessor(professor);
            professor.setPublicacao(pubEsco);

            System.out.println("## Aluno: " + professor.getNome() + "** AlOCADO!");
            System.out.println("## press[ENTER]... ");
            teclado.nextLine();
        }
    }

    public void alocarPesquisadores() {

        if(GerenColaboradores.sizeAlunoPesq() == 0) {
            System.out.println("## **Adicine um aluno um Pesquisador.");
            System.out.println("## press[ENTER]...");
            teclado.nextLine();
            return;
        }

        System.out.println("#######################################################");
        System.out.println("##                  Qual Pesq. Alocar?               ##");

        // Escolhendo o colaborador
        Pesquisadores pesquisador = GerenColaboradores.ReturnPesq();

        System.out.println("##      Alocar Para [1]projeto ou [2]Publicacao?     ##");
        // int escolha = Integer.parseInt(teclado.nextLine());
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

        if(escolha == 1) {
            System.out.println("##     Escolha o Projeto Para alocar o estudante!    ##");
            // Escolhendo o projeto.
            Projeto proj = this.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                System.out.println("## press[ENTER]... ");
                teclado.nextLine();
                return;
            }

            proj.addPesquisador(pesquisador);
            pesquisador.setProjeto(proj);

            System.out.println("## Aluno: " + pesquisador.getNome() + "     ** AlOCADO!");
            System.out.println("## press[ENTER]... ");
            teclado.nextLine();
        }
        if(escolha == 2) {

            if(GerenProdAcademica.publicacaoSize()) {
                System.out.println("##  Adicione uma publicacao antes!   ##");
                System.out.println("## press[ENTER]... ");
                teclado.nextLine();
                return;
            }

            System.out.println("##     Escolha o Publicacao para alocar o estudante!    ##");
            Publicacao pubEsco = GerenProdAcademica.publicacaoList();

            pubEsco.addPesquisador(pesquisador);
            pesquisador.setPublicacao(pubEsco);

            System.out.println("## Aluno: " + pesquisador.getNome() + "** AlOCADO!");
            System.out.println("## press[ENTER]... ");
            teclado.nextLine();
        }
    }

    //////////////////////////
    // Listando projetos

    public Projeto projetList() {
        for (int i = 0; i < TodosOsProjetos.size(); i++) {
            Projeto proj = TodosOsProjetos.get(i);
            System.out.println("## " + "["+(i+1)+"] - Titulo:" + proj.getTitulo() + "  *Status: " + proj.getStatus());
        }

        System.out.print("## ");
        // int escolha = Integer.parseInt(teclado.nextLine());
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
        
        clearBuffer(teclado);
        return TodosOsProjetos.get(escolha - 1);
    }

    public boolean getSize() {
        if(TodosOsProjetos.size() == 0) return true;
        else return false;
    }

    public Vector<Projeto> TodosProjetos() {
        return TodosOsProjetos;
    }

    public void clearBuffer(Scanner scanner) {
        System.out.println("## press[ENTER]...");
        if(scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
