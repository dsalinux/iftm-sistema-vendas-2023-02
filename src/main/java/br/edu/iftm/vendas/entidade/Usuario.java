package br.edu.iftm.vendas.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name = "codigo")
    private Integer id;
    private String nome;
    @NonNull
    private String email;
    private String senha;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    
    
}
