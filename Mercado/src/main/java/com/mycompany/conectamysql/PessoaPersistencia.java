
package com.mycompany.conectamysql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public class PessoaPersistencia {
    
    EntityManagerFactory fabricaDePersistencia = Persistence.createEntityManagerFactory("banco_teste");
    EntityManager persistencia = fabricaDePersistencia.createEntityManager();
    
    public void salvarPessoa(Pessoa p){
        persistencia.getTransaction().begin();
        //inserte into pessoa values(?,?,?)
        persistencia.persist(p);
        persistencia.getTransaction().commit();
        persistencia.close();
        fabricaDePersistencia.close();
   
    }
    
}
