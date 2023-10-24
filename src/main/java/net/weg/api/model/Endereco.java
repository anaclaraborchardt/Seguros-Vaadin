package net.weg.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String rua;
    private String bairro;
    private Integer numero;
}
