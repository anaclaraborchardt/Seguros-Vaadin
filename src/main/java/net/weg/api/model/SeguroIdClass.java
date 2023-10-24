package net.weg.api.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeguroIdClass {

    private Integer seguradoraId;
    private Integer seguroId;

}
