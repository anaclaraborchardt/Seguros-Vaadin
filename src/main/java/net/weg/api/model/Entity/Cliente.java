package net.weg.api.model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Cliente extends Usuario{

    @OneToMany
    private Set<Carro> carro;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @OneToMany(mappedBy = "cliente")
    private Set<Seguro> seguros;
    @ManyToMany(mappedBy = "clientes")
    private Set<Seguradora> seguradoras;

}
