package net.weg.api.model.DTO;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.model.Entity.Carro;
import net.weg.api.model.Entity.Cliente;
import net.weg.api.model.Entity.Seguradora;
import net.weg.api.model.Entity.Usuario;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeguroCadastroDTO {

    private Double valor;
    private String descricao;
    private Double franquia;
    private Seguradora seguradora;
    private Carro carro;
    private Cliente cliente;
}
