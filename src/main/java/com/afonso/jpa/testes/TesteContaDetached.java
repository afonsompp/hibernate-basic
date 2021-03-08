package com.afonso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.afonso.jpa.Cliente;
import com.afonso.jpa.Conta;

public class TesteContaDetached {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        EntityManager em2 = emf.createEntityManager();
        Cliente cli = new Cliente(null, "Carlos", "carlos@gmail.com", "0265422021");
        Conta conta = new Conta(null, "1224", "232312-4", cli, 900);

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
