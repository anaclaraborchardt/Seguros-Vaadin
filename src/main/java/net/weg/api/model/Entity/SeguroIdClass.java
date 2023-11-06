package net.weg.api.model.Entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SeguroIdClass {

    private final Integer seguradoraId;
    private final Integer seguroId;

}
