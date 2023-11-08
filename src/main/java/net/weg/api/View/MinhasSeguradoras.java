package net.weg.api.View;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.Entity.Seguradora;
import net.weg.api.service.SeguradoraService;

import java.util.List;

@Route(value = "/seguradoras", layout = NavBarApp.class)
public class MinhasSeguradoras extends PaginaPadrao<Seguradora> {

    MinhasSeguradoras(SeguradoraService seguradoraService){
        super("Seguradoras",
                (List<Seguradora>) seguradoraService.buscarTodos(),
                Seguradora.class);
    }
}
