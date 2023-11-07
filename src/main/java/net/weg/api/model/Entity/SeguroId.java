package net.weg.api.model.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor

@Embeddable
public class SeguroId implements Serializable {

    private Integer seguradoraId;
    private final Integer seguroId;
    private static Integer proxId = 1;
//    private Integer carroId;

    public SeguroId(){
        seguroId = proxId;
        proxId ++;
    }
}
