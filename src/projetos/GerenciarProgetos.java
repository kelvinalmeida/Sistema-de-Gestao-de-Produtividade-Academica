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

        TodosOsProjetos.add(projeto);
        
        System.out.println("## **PROJETO ADICIONADO! ");
    }

    public void adicionarProfessor(Projeto projeto) {
        System.out.println("#######################################################");
        System.out.println("##      Qual professor quer adicionar no projeto?    ##");
        Professores professor = GerenColaboradores.ReturnProf();

        // Projeto(ponteiro) criado no adicionar();
        projeto.addProf(professor);

        System.out.println("## **Professor: " + professor.getNome() + "   **ADICIONADO!");

    }

    /////////////////////////////
    // Alucacao de Participantes!

    public void alocar() {
        System.out.println("#######################################################");
        System.out.println("##          Qual tipo de Colaborador Alocar?         ##");
        System.out.println("##              Quel o tipo de Colaborador?          ##");
        System.out.println("##  [1] alunos de graduacao  [2] alunosde mestrado   ##");
        System.out.println("##  [3] alunos de doutorado  [4] professores         ##");
        System.out.println("##                [5] pesquisadores                  ##");

        int escolha = Integer.parseInt(teclado.nextLine());

        if(escolha == 1) alocarAlunosGraduacao(); 
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
            
            proj.addAlunoGrad(AlunoGraduacao);
            
            System.out.println("## Aluno: " + AlunoGraduacao.getNome() + "** AlOCADO!");
        }

    }



    //////////////////////////
    // Listando projetos

    public Projeto projetList() {
        for (int i = 0; i < TodosOsProjetos.size(); i++) {
            Projeto proj = TodosOsProjetos.get(i);
            System.out.println("## " + "["+(i+1)+"]" + proj.getTitulo());
        }

        int escolha = Integer.parseInt(teclado.nextLine());
        return TodosOsProjetos.get(escolha - 1);
    }

}