package net.weg.api.model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//@IdClass(SeguroIdClass.class)
public class Seguro {

    @EmbeddedId
    private final SeguroId idComposto = new SeguroId();
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer seguroId;
//    @Id
//    private Integer seguradoraId;
    private Double valor;
    private String descricao;
    private Double franquia;
    @ManyToOne
    @MapsId("seguradoraId")
//    @JoinColumn(name = "seguradoraId")
    private Seguradora seguradora;
    @OneToOne
    @EqualsAndHashCode.Exclude
    private Carro carro;
    @ManyToOne
    private Cliente cliente;
}
