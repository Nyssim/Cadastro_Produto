
package com.mycompany.conectamysql;

import com.mycompany.mercado.classe.ClasseProduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class PersistenciaProduto {
    EntityManagerFactory fabricaDePersistencia = Persistence.createEntityManagerFactory("banco_teste");
    EntityManager persistencia = fabricaDePersistencia.createEntityManager();
    
    public void salvarProduto(ClasseProduto prod) {
        persistencia.getTransaction().begin();
        //inserte into pessoa values(?,?,?)
        persistencia.persist(prod);
        persistencia.getTransaction().commit();
        persistencia.close();
        fabricaDePersistencia.close();
    }
    
    public void atualizarProduto(ClasseProduto prod) {
        persistencia.getTransaction().begin();
        persistencia.merge(prod);
        persistencia.getTransaction().commit();
        persistencia.close();
        fabricaDePersistencia.close();
    }
    
    public List<ClasseProduto> listarTodosOsProduto() {
        Query consulta = persistencia.createQuery("SELECT p FROM ClasseProduto p");
        return consulta.getResultList();
    }
    
    public void excluirProduto(Long id) {
        persistencia.getTransaction().begin();
        ClasseProduto p = persistencia.find(ClasseProduto.class, id);
        if(p != null) {
            persistencia.remove(p);
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }
        persistencia.getTransaction().commit();
        persistencia.close();
        fabricaDePersistencia.close();
    }
}
