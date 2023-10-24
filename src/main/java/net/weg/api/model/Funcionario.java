package net.weg.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Funcionario extends Usuario{

    private double salario;
    private Integer matricula;
    private String cargo;



}
