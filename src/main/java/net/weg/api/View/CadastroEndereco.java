package net.weg.api.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.DTO.EnderecoCadastroDTO;

public class CadastroEndereco extends FormLayout {

    private final TextField rua = new TextField("Rua");
    private final TextField bairro = new TextField("Bairro");;
    private final IntegerField numero = new IntegerField("Número");
    private Button salvar;
    private Button cancelar;


    CadastroEndereco(Grid<EnderecoCadastroDTO> gridEndereco, Dialog dialog){
        salvar = new Button("Salvar", event -> {
                gridEndereco.setItems(new EnderecoCadastroDTO(
                        rua.getValue(),
                        bairro.getValue(),
                        numero.getValue()
                ));
                dialog.close();
        });

        cancelar = new Button("Cancelar", event -> dialog.close());
        dialog.getFooter().add(salvar, cancelar);
        add(rua, bairro, numero);
    }
}
