package src;

import java.util.Scanner;

public class ClearBuffer {
    Scanner teclado = new Scanner(System.in);

    public void clear() {
        System.out.println("## press[ENTER]...");
        teclado.nextLine();
    }
}