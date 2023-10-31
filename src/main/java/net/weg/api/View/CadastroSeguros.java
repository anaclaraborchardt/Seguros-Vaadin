package net.weg.api.View;

import com.vaadin.flow.component.dialog.Dialog;
import net.weg.api.service.CarroService;
import net.weg.api.service.SeguroService;

import java.awt.*;

public class CadastroSeguros {

    private final SeguroService seguroService;

    public CadastroSeguros(SeguroService seguroService, Dialog dialog) {
        this.seguroService = seguroService;
    }

}
