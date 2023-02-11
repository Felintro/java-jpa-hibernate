package br.com.felintro.loja.model;

/*
 * @author allfel
 *
 * Data: 09/02/2023
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "ds_nome", nullable = false)
    private String nome;

    @Column(name = "ds_descricao", nullable = false)
    private String descricao;

    @Column(name = "vl_preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "dt_cadastro", nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @ManyToOne
    private Categoria categoria;

    public Produto(String nome, String descricao, BigDecimal preco, LocalDateTime dataCadastro, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
        this.categoria = categoria;
    }
}
