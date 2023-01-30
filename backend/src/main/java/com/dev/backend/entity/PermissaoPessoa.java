package com.dev.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.Date;
import lombok.Data;

@Entity
@Table(name = "permissao_pessoa")
@Data
public class PermissaoPessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;
    
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    @JsonIgnore
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name = "id_permissao")
    private Permissao permissao;
    
}
