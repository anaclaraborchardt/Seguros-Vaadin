package net.weg.api.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarroCadastroDTO implements IDTO {

    private String placa;
    private String cor;
    private String modelo;
    private String marca;
    private double preco;
    private Integer ano;
}
