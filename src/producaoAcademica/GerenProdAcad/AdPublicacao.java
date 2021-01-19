package src.producaoAcademica.GerenProdAcad;

import src.projetos.*;
import src.colaboradores.*;
import java.util.Vector;
import java.util.Scanner;
import src.utilitarios.*;


import src.producaoAcademica.*;

public class AdPublicacao {

    Scanner teclado = new Scanner(System.in);
    EntradaTeclado entradaTeclado = new EntradaTeclado();

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
        
        anoAtual = entradaTeclado.entradaInt();

        publi.setAnoAtual(anoAtual);

        return publi;
    }
}