package net.weg.api.model.Entity;

import jakarta.persistence.*;
import lombok.*;
import net.weg.api.model.DTO.UsuarioCadastroDTO;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente extends Usuario{

    @OneToMany
    private Set<Carro> carro;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @OneToMany(mappedBy = "cliente")
    private Set<Seguro> seguros;
    @ManyToMany(mappedBy = "clientes", fetch = FetchType.EAGER)
    private Set<Seguradora> seguradoras;

    public Cliente(UsuarioCadastroDTO usuarioCadastroDTO) {
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
