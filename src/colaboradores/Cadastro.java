package src.colaboradores;
import java.util.Scanner;
import java.util.Vector;

public class Cadastro {
    
    // Vai ficar todos os alunso da graduação!
    Vector<Object> ConjAlunosDeGraduacao = new Vector<Object>();

    public void adicionar() {
        System.out.println("#######################################################");
        System.out.println("##              Quel o tipo de Colaborador?          ##");
        System.out.println("##  [1] alunos de graduacao! [2] alunosde mestrado   ##");

        Scanner teclado = new Scanner(System.in);
        int escolha = Integer.parseInt(teclado.nextLine());

        // Cadastrando os alunos de graduacao!
        if(escolha == 1) {
            AlunosDeGraduacao aluno = new AlunosDeGraduacao();

            System.out.print("Informe o nome: ");
            String nome = teclado.nextLine();
            aluno.setNome(nome);

            System.out.print("Informe o email: ");
            String email = teclado.nextLine();
            aluno.setEmail(email);

            // Foi para a ultima posicao do array.
            ConjAlunosDeGraduacao.add(aluno);
        }

    }
}