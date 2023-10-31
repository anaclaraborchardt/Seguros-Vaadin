package net.weg.api.View;


import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.Entity.Carro;
import net.weg.api.service.CarroService;

@Route(value = "/meus-automoveis", layout = NavBarApp.class)
public class MeusAutomoveis extends VerticalLayout {

    private final CarroService carroService;
    public MeusAutomoveis(CarroService carroService) {
        this.carroService = carroService;

        HorizontalLayout hl = new HorizontalLayout();
        hl.add(new H1("Meus Automóveis"));
        Dialog cadastro = new Dialog();
        cadastro.add(new CadastroCarro(carroService, cadastro));

        Button button = new Button("Novo Carro", e -> cadastro.open());
//        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY,
//                ButtonVariant.LUMO_ERROR);
        hl.add(button);
        Grid<Carro> gridCarro = new Grid<>(Carro.class);
        gridCarro.setItems(carroService.buscarTodos());
        add(hl);
        add(gridCarro);

    }

}