package src.projetos;
import java.util.Scanner;
import java.util.Vector;
import src.colaboradores.*;

public class GerenciarProgetos {

    Vector<Projeto> Projetos = new Vector<Projeto>();
    Scanner teclado = new Scanner(System.in);
    GerenciamentoColaboradores GerenColaboradores;

    // ponteiro
    GerenciarProgetos(GerenciamentoColaboradores GerenColaboradores) {
        this.GerenColaboradores = GerenColaboradores;
    }
    
    public void adicionar() {
        System.out.println("#######################################################");
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

        this.adicionarProfessor();
        
        System.out.println("## **PROJETO ADICIONADO! ");
    }

    public void adicionarProfessor() {
        // while(0 != 1) {

        // }
    }
}