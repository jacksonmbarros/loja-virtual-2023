package com.dev.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name = "produto")
@Data
public class Produto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "descricao_curta")
    private String descricaoCurta;
    
    @Column(name = "descricao_detalhada")
    private String descricaoDetalhada;
    
    @Column(name = "valor_custo")
    private Double valorCusto;
    
    @Column(name = "valor_venda")
    private Double valorVenda;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;
    
    @ManyToOne
    @JoinColumn(name="id_marca")
    private Marca marca;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
}
