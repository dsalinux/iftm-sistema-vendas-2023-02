package br.edu.iftm.vendas.entidade;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Usuario {
    
    @EqualsAndHashCode.Include
    private Integer codigo;
    private String nome;
    @NonNull
    private String email;
    private String senha;
    private Date dataCadastro;

    
    
}
