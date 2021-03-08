package com.afonso.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String agencia;
    
    private String conta;
    
    private String titular;

    public Conta() {

    }

    public Conta(Long id, String agencia, String conta, String titular) {
        this.id = id;
        this.agencia = agencia;
        this.conta = conta;
        this.titular = titular;
    }

    public Long getId() {
        return id;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getConta() {
        return conta;
    }

    public String getTitular() {
        return titular;
    }

}