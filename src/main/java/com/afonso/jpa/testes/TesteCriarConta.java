package com.afonso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.afonso.jpa.Conta;

public class TesteCriarConta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta(null, "1234", "432311-4", "Marcelino Tavares", 500);

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();

        emf.close();
    }
}
