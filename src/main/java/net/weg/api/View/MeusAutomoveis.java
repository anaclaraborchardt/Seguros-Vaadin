package net.weg.api.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.Entity.Carro;
import net.weg.api.service.CarroService;

@Route(value = "/meus-automoveis", layout = NavBarApp.class)
public class MeusAutomoveis extends PaginaPadrao<Carro> {


    public MeusAutomoveis(CarroService carroService) {
        super("Meus Automóveis", carroService.buscarTodos(), Carro.class,new Button("Novo Carro",buttonClickEvent -> {
            new CadastroCarro(carroService).open();
        }));
    }

}