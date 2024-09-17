/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conectamysql;

import com.mycompany.mercado.classe.ClasseUsuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class PersistenciaUsuario {
    EntityManagerFactory fabricaDePersistencia = Persistence.createEntityManagerFactory("banco_teste");
    EntityManager persistencia = fabricaDePersistencia.createEntityManager();
    
    public void salvarUsuario(ClasseUsuario user) {
        persistencia.getTransaction().begin();
        //inserte into pessoa values(?,?,?)
        persistencia.persist(user);
        persistencia.getTransaction().commit();
        persistencia.close();
        fabricaDePersistencia.close();
    }
    
    public void atualizar(ClasseUsuario user) {
        persistencia.getTransaction().begin();
        persistencia.merge(user);
        persistencia.getTransaction().commit();
        persistencia.close();
        fabricaDePersistencia.close();
    }
    
    public List<ClasseUsuario> listarTodosOsUsuario() {
        Query consulta = persistencia.createQuery("SELECT p FROM ClasseUsuario p");
        return consulta.getResultList();
    }
    
    public void excluirUsuario(Long id) {
        persistencia.getTransaction().begin();
        ClasseUsuario u = persistencia.find(ClasseUsuario.class, id);
        if(u != null) {
            persistencia.remove(u);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario não encontrado");
        }
        persistencia.getTransaction().commit();
        persistencia.close();
        fabricaDePersistencia.close();
    }
}
