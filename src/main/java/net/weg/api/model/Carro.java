package net.weg.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cor;
    private String modelo;
    private String marca;
    private double preco;
    private Integer ano;
    @OneToOne(mappedBy = "carro")
    private Seguro seguro;

}
