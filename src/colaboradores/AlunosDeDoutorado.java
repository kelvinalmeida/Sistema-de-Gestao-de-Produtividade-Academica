package src.colaboradores;

import src.projetos.*;
import java.util.Vector;

public class AlunosDeDoutorado extends Colaboradores {
    
    public void setProjeto(Projeto proj) {
        // if(projG.size() == 2){
        //     System.out.println("## ***"+ getNome() +" ja atingiu a participacao maxima de 2 projetos.");
        //     return;
        // }

        this.projG.add(proj);
    }

}