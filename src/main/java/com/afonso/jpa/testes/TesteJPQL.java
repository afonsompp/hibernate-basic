package com.afonso.jpa.testes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.afonso.jpa.Conta;
import com.afonso.jpa.Movimentacao;

public class TesteJPQL {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(5L);

        String jpql = "SELECT m FROM Movimentacao m INNER JOIN m.conta c INNER JOIN c.titular";

        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);


        List<Movimentacao> contas =  new ArrayList<>(query.getResultList());

        for (var c : contas) {
            System.out.println("----------------------------------");
            System.out.println(c.getConta().getTitular().getEndereco().getRua());
            System.out.println("----------------------------------");
        }
         
    }
}
