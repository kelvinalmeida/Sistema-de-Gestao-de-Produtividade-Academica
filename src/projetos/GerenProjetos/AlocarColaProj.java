package src.projetos.GerenProjetos;

import src.projetos.*;
import src.colaboradores.*;
import src.producaoAcademica.*;
import java.util.Vector;
import java.util.Scanner;


import src.projetos.*;
import src.*;

public class AlocarColaProj {

    Scanner teclado = new Scanner(System.in);
    ClearBuffer clearBuffer = new ClearBuffer();

    public int alocar() {

        clearBuffer.clear();

        System.out.println("#######################################################");
        System.out.println("##          Qual tipo de Colaborador Alocar?         ##");
        System.out.println("##  [1] alunos de graduacao  [2] alunosde mestrado   ##");
        System.out.println("##  [3] alunos de doutorado  [4] professores         ##");
        System.out.println("##  [5] pesquisadores        [6] Voltar              ##");

        int escolha = 0;
        boolean stop = true;
        while(stop) {
            try {
                escolha = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
            }
        }

        if(escolha == 1) return 1;
        if(escolha == 2) return 2;
        if(escolha == 3) return 3;
        if(escolha == 4) return 4;
        if(escolha == 5) return 5;
        else return 6;
    }

    public void alocarAlunosGraduacao(GerenciamentoColaboradores GerenColaboradores, GerenProducaoAcad GerenProdAcademica, GerenciarProgetos gerenciarProgetos) {

        if(GerenColaboradores.sizeAlunoGrad() == 0) {
                System.out.println("## **Adicine um aluno de Graduacao.");
                clearBuffer.clear();
                return;
        }

        System.out.println("#######################################################");
        System.out.println("##             Qual Alu. de Grad. Alocar?            ##");

        Aluno AlunoGraduacao = GerenColaboradores.ReturnAlunosGrad();

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

                clearBuffer.clear();
                return;
            }

            System.out.println("##     Escolha o Projeto Para alocar o estudante!    ##");
            Projeto proj = gerenciarProgetos.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                clearBuffer.clear();
                return;
            } else {
                proj.addAlunoGrad(AlunoGraduacao);
                AlunoGraduacao.setProjeto(proj);

                System.out.println("## Aluno: " + AlunoGraduacao.getNome() + "** AlOCADO!");
                clearBuffer.clear();
            }
        }

        if(escolha == 2) {

            if(GerenProdAcademica.publicacaoSize()) {
                System.out.println("##  Adicione uma publicacao antes!   ##");
                clearBuffer.clear();
                return;
            }

            System.out.println("##     Escolha o Publicacao para alocar o estudante!    ##");
            Publicacao pubEsco = GerenProdAcademica.publicacaoList();

            pubEsco.addAlunoGrad(AlunoGraduacao);
            AlunoGraduacao.setPublicacao(pubEsco);

            System.out.println("## Aluno: " + AlunoGraduacao.getNome() + "** AlOCADO!");
            clearBuffer.clear();
        }
    }

    public void alocarAlunosMestrado(GerenciamentoColaboradores GerenColaboradores, GerenProducaoAcad GerenProdAcademica, GerenciarProgetos gerenciarProgetos) {

        if(GerenColaboradores.sizeAlunoMest() == 0) {
            System.out.println("## **Adicine um aluno de Mestrado.");
            clearBuffer.clear();
            return;
        }

        System.out.println("#######################################################");
        System.out.println("##             Qual Alu. de Mest. Alocar?            ##");

        Aluno AlunoMestrado = GerenColaboradores.ReturnAlunosMest();

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
            Projeto proj = gerenciarProgetos.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                clearBuffer.clear();
                return;
            }

            proj.addAlunoMest(AlunoMestrado);
            AlunoMestrado.setProjeto(proj);
            System.out.println("## Aluno: " + AlunoMestrado.getNome() + "** AlOCADO!");
            clearBuffer.clear();
        }

        if(escolha == 2) {

            if(GerenProdAcademica.publicacaoSize()) {
                System.out.println("##  Adicione uma publicacao antes!   ##");
                clearBuffer.clear();
                return;
            }

            System.out.println("##     Escolha o Publicacao para alocar o estudante!    ##");
            Publicacao pubEsco = GerenProdAcademica.publicacaoList();

            pubEsco.addAlunoMest(AlunoMestrado);
            AlunoMestrado.setPublicacao(pubEsco);

            System.out.println("## Aluno: " + AlunoMestrado.getNome() + "** AlOCADO!");
            clearBuffer.clear();
        }
    }

    public void alocarAlunosDoutorado(GerenciamentoColaboradores GerenColaboradores, GerenProducaoAcad GerenProdAcademica, GerenciarProgetos gerenciarProgetos) {

        if(GerenColaboradores.sizeAlunoDout() == 0) {
            System.out.println("## **Adicine um aluno de Doutorado.");
            clearBuffer.clear();
            return;
        }

        System.out.println("#######################################################");
        System.out.println("##             Qual Alu. de Dout. Alocar?            ##");

        Aluno AlunoDoutorado = GerenColaboradores.ReturnAlunosDout();

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
            Projeto proj = gerenciarProgetos.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                clearBuffer.clear();
                return;
            }

            proj.addAlunoDout(AlunoDoutorado);
            AlunoDoutorado.setProjeto(proj);

            System.out.println("## Aluno: " + AlunoDoutorado.getNome() + "** AlOCADO!");
            clearBuffer.clear();
        }
        if(escolha == 2) {

            if(GerenProdAcademica.publicacaoSize()) {
                System.out.println("##  Adicione uma publicacao antes!   ##");
                clearBuffer.clear();
                return;
            }

            System.out.println("##     Escolha o Publicacao para alocar o estudante!    ##");
            Publicacao pubEsco = GerenProdAcademica.publicacaoList();

            pubEsco.addAlunoDout(AlunoDoutorado);
            AlunoDoutorado.setPublicacao(pubEsco);

            System.out.println("## Aluno: " + AlunoDoutorado.getNome() + "** AlOCADO!");
            clearBuffer.clear();
        }
    }

    public void alocarProfessores(GerenciamentoColaboradores GerenColaboradores, GerenProducaoAcad GerenProdAcademica, GerenciarProgetos gerenciarProgetos) {

        if(GerenColaboradores.sizeProf()) {
            System.out.println("## **Adicine um aluno um Professor.");
            clearBuffer.clear();
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
            Projeto proj = gerenciarProgetos.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                clearBuffer.clear();
                return;
            }

            proj.addProfessor(professor);
            professor.setProjeto(proj);

            System.out.println("## Aluno: " + professor.getNome() + "** AlOCADO!");
            clearBuffer.clear();
        }
        if(escolha == 2) {

            if(GerenProdAcademica.publicacaoSize()) {
                System.out.println("##  Adicione uma publicacao antes!   ##");
                clearBuffer.clear();
                return;
            }

            System.out.println("##     Escolha o Publicacao para alocar o estudante!    ##");
            Publicacao pubEsco = GerenProdAcademica.publicacaoList();

            pubEsco.addProfessor(professor);
            professor.setPublicacao(pubEsco);

            System.out.println("## Aluno: " + professor.getNome() + "** AlOCADO!");
            clearBuffer.clear();
        }
    }

    public void alocarPesquisadores(GerenciamentoColaboradores GerenColaboradores, GerenProducaoAcad GerenProdAcademica, GerenciarProgetos gerenciarProgetos) {

        if(GerenColaboradores.sizeAlunoPesq() == 0) {
            System.out.println("## **Adicine um aluno um Pesquisador.");
            clearBuffer.clear();
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
            Projeto proj = gerenciarProgetos.projetList();

            // Regra!
            if(proj.getEmElaboracao() == false) {
                System.out.println("## Pojeto Precisa esta em elaboracao! ##");
                clearBuffer.clear();
                return;
            }

            proj.addPesquisador(pesquisador);
            pesquisador.setProjeto(proj);

            System.out.println("## Aluno: " + pesquisador.getNome() + "     ** AlOCADO!");
            clearBuffer.clear();
        }
        if(escolha == 2) {

            if(GerenProdAcademica.publicacaoSize()) {
                System.out.println("##  Adicione uma publicacao antes!   ##");
                clearBuffer.clear();
                return;
            }

            System.out.println("##     Escolha o Publicacao para alocar o estudante!    ##");
            Publicacao pubEsco = GerenProdAcademica.publicacaoList();

            pubEsco.addPesquisador(pesquisador);
            pesquisador.setPublicacao(pubEsco);

            System.out.println("## Aluno: " + pesquisador.getNome() + "** AlOCADO!");
            clearBuffer.clear();
        }
    }   
    
}