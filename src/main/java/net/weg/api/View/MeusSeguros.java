package net.weg.api.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.Entity.Seguro;
import com.vaadin.flow.component.dialog.Dialog;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;

@Route(value = "/meus-seguros", layout = NavBarApp.class)
public class MeusSeguros extends VerticalLayout {

    public MeusSeguros(SeguroService seguroService,
                       SeguradoraService seguradoraService,
                       CarroService carroService,
                       ClienteService clienteService) {
        HorizontalLayout hl = new HorizontalLayout();
        hl.add(new H1("Meus seguros"));
        Dialog cadastro = new Dialog();
        cadastro.add(new CadastroSeguros(cadastro, seguroService, seguradoraService, carroService, clienteService));
        Button button = new Button("Novo Seguro", e -> cadastro.open());
//        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY,
//                ButtonVariant.LUMO_ERROR);
        hl.add(button);
        add(hl, cadastro);
        Grid<Seguro> seguros = new Grid<>(Seguro.class);
        seguros.setItems(seguroService.buscarTodos());
        add(seguros);
    }

}
