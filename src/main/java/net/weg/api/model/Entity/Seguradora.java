package net.weg.api.model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.api.model.DTO.SeguradoraCadastroDTO;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Seguradora {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private Long cnpj;
    private String nome;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Cliente> clientes;

    public Seguradora(SeguradoraCadastroDTO seguradoraDTO) {
    }
}
