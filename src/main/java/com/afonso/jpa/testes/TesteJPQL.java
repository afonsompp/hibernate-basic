package com.afonso.jpa.testes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.afonso.jpa.Conta;

public class TesteJPQL {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(5L);

        String jpql = "SELECT c FROM Conta c where c.id = :pConta";

        Query query = em.createQuery(jpql);

        query.setParameter("pConta", 5L);

        List<Conta> contas =  new ArrayList<>(query.getResultList());

        for (Conta conta2 : contas) {
            System.out.println(conta2.getConta());
        }
         
    }
}
