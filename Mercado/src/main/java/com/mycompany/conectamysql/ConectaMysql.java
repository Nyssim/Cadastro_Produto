
package com.mycompany.conectamysql;


public class ConectaMysql {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        PessoaPersistencia per = new PessoaPersistencia();
        Pessoa p = new Pessoa();
        per.salvarPessoa(p);
    }
}
