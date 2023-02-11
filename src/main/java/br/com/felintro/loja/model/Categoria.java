package br.com.felintro.loja.model;
/*
 * @author allfel
 *
 * Data: 11/02/2023
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "ds_nome", nullable = false)
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

}
