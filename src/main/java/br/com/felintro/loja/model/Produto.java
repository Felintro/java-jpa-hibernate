package br.com.felintro.loja.model;

/*
 * @author allfel
 *
 * Data: 09/02/2023
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "ds_nome", nullable = false)
    private String nome;

    @Column(name = "ds_descricao", nullable = false)
    private String descricao;

    @Column(name = "vl_preco", nullable = false)
    private BigDecimal preco;




}