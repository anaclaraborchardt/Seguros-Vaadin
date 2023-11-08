package net.weg.api.model.DTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.model.Entity.Endereco;

import java.util.Set;
@AllArgsConstructor
@Data
public class UsuarioCadastroDTO implements IDTO {

    private String nome;
    private String sobrenome;
    private String usuario;
    private String senha;
    private Integer idade;
    private Set<Endereco> endereco;
}
