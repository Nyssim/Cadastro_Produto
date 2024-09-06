
package com.mercado.conexao;

import com.mercado.modelo.ProdutoModelo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;





public class ProdutoPersistencia {
    
    EntityManagerFactory fabricaDePersistencia = Persistence.createEntityManagerFactory("banco_teste");
    EntityManager persistencia = fabricaDePersistencia.createEntityManager();
    
    public void salvarProduto(ProdutoModelo p){

        persistencia.getTransaction().begin();
        //inserte into pessoa values(?,?,?)
        persistencia.persist(p);
        persistencia.getTransaction().commit();
        persistencia.close();
        fabricaDePersistencia.close();
   
    }
    
}