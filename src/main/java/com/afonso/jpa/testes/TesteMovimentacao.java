package com.afonso.jpa.testes;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.afonso.jpa.Categoria;
import com.afonso.jpa.Cliente;
import com.afonso.jpa.Conta;
import com.afonso.jpa.EnumTipo;
import com.afonso.jpa.Movimentacao;

public class TesteMovimentacao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        Cliente cli = new Cliente(null, "Carlos", "carlos@gmail.com", "0265422021");
        Conta conta = new Conta(null, "2323", "434234-4", cli, 500);
        List<Categoria> cat = new ArrayList<>();
        Categoria c = new Categoria(null, "Trabalho");
        cat.add(c);
        Movimentacao movimentacao = new Movimentacao(null, new BigDecimal(200), 
                EnumTipo.DEPOSITO, Instant.now(), "bla bla bla", conta, cat);

        em.getTransaction().begin();
        em.persist(conta);
        em.persist(movimentacao);
        em.getTransaction().commit();

        emf.close();    
    }
}
