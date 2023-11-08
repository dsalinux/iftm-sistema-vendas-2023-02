package br.edu.iftm.vendas.entidade;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Produto {
    
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private String descricao;
    private String marca;
    private BigDecimal preco;
    private String cor;
    
}
