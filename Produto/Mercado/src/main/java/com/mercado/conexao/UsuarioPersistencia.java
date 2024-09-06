
package com.mercado.conexao;

import com.mercado.modelo.UsuarioModelo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public class UsuarioPersistencia {
    
    EntityManagerFactory fabricaDePersistencia = Persistence.createEntityManagerFactory("banco_teste");
    EntityManager persistencia = fabricaDePersistencia.createEntityManager();
    
    public void salvarUsuario(UsuarioModelo u){
    persistencia.getTransaction().begin();
        //inserte into pessoa values(?,?,?)
    persistencia.persist(u);
    persistencia.getTransaction().commit();
    persistencia.close();
    fabricaDePersistencia.close();
   
    }
    
    
}
