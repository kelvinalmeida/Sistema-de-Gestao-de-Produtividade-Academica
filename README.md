# Sistema de Gestao de Produtividade Academica
 O sistema de gestão de produtividade acadêmica objetiva o gerenciamento da produção
 acadêmica de um laboratório de pesquisa, incluindo informações sobre projetos de pesquisa e
 colaboradores.
 Implementado em java!

# Para executar o programa, baixe a pasta src e execute os seguintes comandos:
 
  - javac src/*.java && javac src/colaboradores/*.java && javac src/colaboradores/Gerenciador/*.java && javac src/producaoAcademica/*.java && javac src/producaoAcademica/GerenProdAcad/*.java && javac src/projetos/*.java && javac src/projetos/GerenProjetos/*.java

  OU

  - javac src/*.java
  - javac src/colaboradores/*.java
  - javac src/colaboradores/Gerenciador/*.java
  - javac src/producaoAcademica/*.java
  - javac src/producaoAcademica/GerenProdAcad/*.java
  - javac src/projetos/*.java
  - javac src/projetos/GerenProjetos/*.java
 
# Para executar o programa:
 
  - java src.Main

# Foi aplicado os padrões de projeto Singleton e Extract Class. Os padrões foram aplicados nas seguintes classes:

 - src/colaboradores/GerenciamentoColaboradores.java
 - src/producaoAcademica/GerenProducaoAcad.java
 - src/projetos/GerenciarProgetos.java

 # Também foi aplicado o padrão state em:

 - src/projetos/Status
 
 # Diminuindo repetições de código:
  
  ### Os códigos de entrada de teclado e de limpar o Buffer estavam muito repetidos.
  Tive a ideia de Criar duas classes: uma para trabalhar com entrada de teclado e outra para limpar Buffer.

  ### As duas classes estão em:
  - src/utilitarios
  ### Dessa forma consegui diminuir muito código repetido e o tamanho das classes.

 
