package com.afonso.jpa.testes;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.afonso.jpa.Conta;
import com.afonso.jpa.EnumTipo;
import com.afonso.jpa.Movimentacao;

public class TesteMovimentacao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta(null, "2323", "434234-4", "carvalho Cunha", 500);
        Movimentacao movimentacao = new Movimentacao(null, new BigDecimal(200), 
                EnumTipo.DEPOSITO, Instant.now(), "bla bla bla", conta);

        em.getTransaction().begin();
        em.persist(conta);
        em.persist(movimentacao);
        em.getTransaction().commit();

        emf.close();    
    }
}
