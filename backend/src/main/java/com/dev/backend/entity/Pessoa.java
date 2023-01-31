package com.dev.backend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;



@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "email")
    private String email;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_envio_codigo")
    private Date dataEnvioCodigo;
    
    @Column(name = "codigo_recuperacao_senha")
    private String codigoRecuperacaoSenha;
    
    @Column(name = "senha")
    private String senha;
    
    @Column(name = "endereco")
    private String endereco;
    
    @Column(name = "cep")
    private String cep;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;
    
    @ManyToOne
    @JoinColumn(name="id_cidade")
    private Cidade cidade;
    
    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(value = AccessLevel.NONE)
    private List<PermissaoPessoa> permissaoPessoas;
    
    public void setPermissaoPessoas(List<PermissaoPessoa> pp){
        for (PermissaoPessoa p : pp) {
            p.setPessoa(this);
        }
        this.permissaoPessoas = pp;
    }
    
}
