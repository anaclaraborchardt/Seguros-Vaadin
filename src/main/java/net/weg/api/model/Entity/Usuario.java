package net.weg.api.model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String nome;
    private String senha;
    private Integer idade;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Endereco> endereco;

}
