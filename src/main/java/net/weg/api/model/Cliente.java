package net.weg.api.model;

import jakarta.persistence.*;
import lombok.*;
import net.weg.api.model.Carro;
import java.sql.ResultSet;
import java.sql.SQLException;
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
//    @ManyToMany(mappedBy = "clientes")
//    private Set<Seguradora> seguradoras;

}
