package net.weg.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name="id")
public class Funcionario extends Usuario{

    private Integer id;
    private double salario;
    private Integer matricula;
    private String cargo;

}
