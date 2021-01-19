package src.utilitarios;

import java.util.Scanner;

public class EntradaTeclado {
    Scanner teclado = new Scanner(System.in);
    public int escolha;
    public String string = "nome";


    public int entradaInt() {
        
        boolean stop = true;
        while(stop) {
            try {
                escolha = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                //
            }
        }

        return escolha;
    }

    public String entradaString() {

        boolean stop = true;
        while(stop) {
            try {
                string = teclado.nextLine();
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor valido!");
            }
        }

        return string;
    }
}