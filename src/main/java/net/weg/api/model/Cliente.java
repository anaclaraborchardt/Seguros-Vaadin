package net.weg.api.model;

import jakarta.persistence.*;
import lombok.*;
import net.weg.api.model.Carro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuarios")
@PrimaryKeyJoinColumn(name="id")
public class Cliente extends Usuario{

    //Muitos usuários podem ter o mesmo carro
    //Many = usuários
    //one = carro
    @OneToMany()
    //Caso o carro não exista, ele permite o cadastro
    @JoinColumn(name = "fkCarro")
    //Quando for uma associação, deve utilizar JoinColumn
    private Set<Carro> carro;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    //usa o mappedBy para não gerar duplicidade de atributos
    @OneToMany(mappedBy = "cliente")
    private Set<Seguro> seguros;
}
