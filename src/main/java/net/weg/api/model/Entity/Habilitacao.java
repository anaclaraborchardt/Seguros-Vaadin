package net.weg.api.model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Habilitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private Long registro;
    private Long cpf;
    private String orgaoEmissor;

}
