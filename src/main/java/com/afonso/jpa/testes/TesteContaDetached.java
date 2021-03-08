package com.afonso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.afonso.jpa.Conta;

public class TesteContaDetached {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        EntityManager em2 = emf.createEntityManager();

        Conta conta = new Conta(null, "1224", "232312-4", "Carlos Rocha", 900);

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        
        
        conta.setSaldo(300);
        
        em2.getTransaction().begin();
        em2.merge(conta);
        em2.getTransaction().commit();
        
        emf.close();
    }
}
