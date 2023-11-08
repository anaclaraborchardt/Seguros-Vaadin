package net.weg.api.model.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SeguroId implements Serializable {

    private Integer seguradoraId;
    private Integer seguroId;
//    private Integer carroId;

    public SeguroId(Integer seguroId) {
        this.seguroId = seguroId;
    }
}
