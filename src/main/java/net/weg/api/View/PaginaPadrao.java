package net.weg.api.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.weg.api.model.Entity.Seguradora;
import net.weg.api.model.Entity.Seguro;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class PaginaPadrao<T> extends VerticalLayout {

    private Grid<T> grid;
    private H1 titulo;
    private HorizontalLayout hl = new HorizontalLayout();

    PaginaPadrao(String titulo, List<T> itens, Class<T> classe, Button botao){
        this(titulo, itens, classe);
        hl.add(botao);
//        add(grid);
    }



    PaginaPadrao(String titulo, List<T> itens, Class<T> classe){
        this.grid = new Grid<>(classe);
        this.grid.setItems(itens);
        this.hl = new HorizontalLayout();
        this.hl.add(titulo);
        this.add(this.hl, this.grid);
//        add(grid);
    }

}
