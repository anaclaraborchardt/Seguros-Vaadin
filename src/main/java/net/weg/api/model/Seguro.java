package net.weg.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plano")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Seguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double valor;
    private String descricao;
    private Double franquia;
    @ManyToOne
    private Seguradora seguradora;
    @OneToOne
    @JsonIgnore
    private Carro carro;
    @ManyToOne
    @JsonIgnore
    private Cliente cliente;
}
