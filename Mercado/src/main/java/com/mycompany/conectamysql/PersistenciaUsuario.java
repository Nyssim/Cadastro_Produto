/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conectamysql;

import com.mycompany.mercado.classe.ClasseUsuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
