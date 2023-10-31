package ai.segura.front;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/meus-seguros", layout = NavBarApp.class)
public class MeusSeguros extends VerticalLayout {

    public MeusSeguros() {

        add(new H1("Meus seguros"));
        add(new Grid<>(Seguro.class));
        
    }

}
