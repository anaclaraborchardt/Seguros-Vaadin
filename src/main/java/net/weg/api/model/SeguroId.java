package net.weg.api.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class SeguroId {

    private Integer seguradoraId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seguroId;
//    private Integer carroId;
}
