
package com.mercado.conexao;

import com.mercado.modelo.ClienteModelo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public class ClientePersistencia {
    
    EntityManagerFactory fabricaDePersistencia = Persistence.createEntityManagerFactory("banco_teste");
    EntityManager persistencia = fabricaDePersistencia.createEntityManager();
    
    public void salvarCliente(ClienteModelo c){
        persistencia.getTransaction().begin();
        //inserte into pessoa values(?,?,?)
        persistencia.persist(c);
        persistencia.getTransaction().commit();
        persistencia.close();
        fabricaDePersistencia.close();
   
    }
    
}
