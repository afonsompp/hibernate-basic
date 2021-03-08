package com.afonso.jpa;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private EnumTipo tipoMovimentacao;

    private Instant data;

    private String descricao;

    @ManyToOne
    private Conta conta;

    public Movimentacao(Long id, BigDecimal valor, EnumTipo tipoMovimentacao, Instant data, String descricao,
            Conta conta) {
        this.id = id;
        this.valor = valor;
        this.tipoMovimentacao = tipoMovimentacao;
        this.data = data;
        this.descricao = descricao;
        this.conta = conta;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public EnumTipo getTipoMovimentacao() {
        return this.tipoMovimentacao;
    }

    public void setTipoMovimentacao(EnumTipo tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Instant getData() {
        return this.data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Conta getConta() {
        return this.conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

}
