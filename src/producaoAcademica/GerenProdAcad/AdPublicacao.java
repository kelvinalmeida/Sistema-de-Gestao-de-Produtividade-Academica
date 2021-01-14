package src.producaoAcademica.GerenProdAcad;

import src.projetos.*;
import src.colaboradores.*;
import java.util.Vector;
import java.util.Scanner;


import src.producaoAcademica.*;

public class AdPublicacao {

    Scanner teclado = new Scanner(System.in);

    public Publicacao adicionarPublicacao() {
        Publicacao publi = new Publicacao();

        System.out.print("## Titulo - ");
        String titulo = teclado.nextLine();
        publi.setTitulo(titulo);

        System.out.print("## Conferencia Aonde Foi Publicada - ");
        String Conf = teclado.nextLine();
        publi.setConferenciaAondeFoiPublicada(Conf);

        System.out.print("## Ano Atual - ");
        int anoAtual = 0;
        boolean stop = true;
        while(stop) {
            try {
                anoAtual = Integer.parseInt(teclado.nextLine());
                stop = false;
            } catch(Exception erro) {
                System.out.println("Digite um valor válido!");
            }
        }
        publi.setAnoAtual(anoAtual);

        return publi;
    }
}