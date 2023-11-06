package net.weg.api.model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(SeguroIdClass.class)
public class Seguro {

//    @EmbeddedId
//    private SeguroId idComposto;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seguroId;
    @Id
    private Integer seguradoraId;
    private Double valor;
    private String descricao;
    private Double franquia;
    @ManyToOne
//    @MapsId("seguradoraId")
    @JoinColumn(name = "seguradoraId")
    private Seguradora seguradora;
    @OneToOne
//    @MapsId("carroId")
    private Carro carro;
    @ManyToOne
    private Cliente cliente;
}
