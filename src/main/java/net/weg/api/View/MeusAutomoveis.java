package net.weg.api.View;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.Entity.Carro;

@Route(value = "/meus-automoveis", layout = NavBarApp.class)
public class MeusAutomoveis extends VerticalLayout {

    public MeusAutomoveis() {

        HorizontalLayout hl = new HorizontalLayout();
        hl.add(new H1("Meus Automóveis"));
        hl.add(new Button("Novo Carro"));
        add(hl);
        add(new Grid<>(Carro.class));

    }

}