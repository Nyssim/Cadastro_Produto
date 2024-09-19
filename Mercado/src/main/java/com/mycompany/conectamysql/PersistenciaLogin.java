
package com.mycompany.conectamysql;

import com.mycompany.mercado.classe.ClasseUsuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class PersistenciaLogin {
    
   EntityManagerFactory fabricaDePersistencia = Persistence.createEntityManagerFactory("banco_teste");
    EntityManager persistencia = fabricaDePersistencia.createEntityManager();
    
    public boolean verificarLogin(String login, String senha) throws Exception {
        try {
            Query query = persistencia.createQuery("SELECT p FROM ClasseUsuario p" + " WHERE p.nome = :login AND p.senha = :senha");
            query.setParameter("login", login);
            query.setParameter("senha", senha);

            List<PersistenciaUsuario> resultados = query.getResultList();
            
        return !resultados.isEmpty();
        
    }catch(Exception e){
       throw new Exception("Erro ao consultar! "+e.getMessage());
        
        } finally {
                if(persistencia.isOpen()) {
                   persistencia.close();
                }
                if (fabricaDePersistencia.isOpen()) {
                    fabricaDePersistencia.close();
                }
        }
    


    }
    
}