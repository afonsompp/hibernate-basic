package com.afonso.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.afonso.jpa.Cliente;
import com.afonso.jpa.Endereco;

public class TesteCriarCliente {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        
        Endereco end = em.find(Endereco.class, 1L);
        Cliente cli = new Cliente(null, "Augusto", "Augusto@gmail.com", "0265422021", end);
        
        em.getTransaction().begin();
        em.persist(end);
        em.persist(cli);
        em.getTransaction().commit();

        emf.close();
    }
}
