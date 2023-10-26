package net.weg.api.model.Entity;

import jakarta.persistence.*;
import lombok.*;
import net.weg.api.model.DTO.CarroCadastroDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String placa;
    private String cor;
    private String modelo;
    private String marca;
    private double preco;
    private Integer ano;
    @OneToOne(mappedBy = "carro")
    private Seguro seguro;

    public Carro(CarroCadastroDTO carroDTO){
        this.placa = carroDTO.getPlaca();
        this.cor = carroDTO.getCor();
        this.modelo = carroDTO.getModelo();
        this.marca = carroDTO.getMarca();
        this.preco = carroDTO.getPreco();
        this.ano = carroDTO.getAno();
    }

}
