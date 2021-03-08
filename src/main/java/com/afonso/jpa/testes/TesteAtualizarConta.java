package com.afonso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.afonso.jpa.Conta;

public class TesteAtualizarConta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = em.find(Conta.class, 1L);
        em.getTransaction().begin();
        conta.setSaldo(300);
        em.getTransaction().commit();

        emf.close();
    }
}
