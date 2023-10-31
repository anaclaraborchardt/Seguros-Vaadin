package net.weg.api.View;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import lombok.SneakyThrows;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.service.CarroService;


import com.vaadin.flow.component.dialog.Dialog;
import java.util.ArrayList;
import java.util.Collection;

public class CadastroCarro extends FormLayout {

    public CadastroCarro(CarroService carroService, Dialog dialog) {

        TextField placa = new TextField("Placa");
        TextField marca = new TextField("Marca");
        TextField cor = new TextField("Cor");
        TextField modelo = new TextField("Modelo");
        IntegerField ano = new IntegerField("Ano");
        IntegerField preco = new IntegerField("Preço");
        add(placa, marca, cor, modelo, ano, preco);

        Button buttonSave = new Button("Salvar", new ComponentEventListener<ClickEvent<com.vaadin.flow.component.button.Button>>() {
            @SneakyThrows
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                CarroCadastroDTO carroDTO = new CarroCadastroDTO(
                        placa.getValue(),
                        marca.getValue(),
                        cor.getValue(),
                        modelo.getValue(),
                        ano.getValue(),
                        preco.getValue());
                carroService.inserir(carroDTO);
                dialog.close();
            }
        });

        Button buttonCancel = new Button("Cancelar", event -> dialog.close());
        dialog.getFooter().add(buttonSave, buttonCancel);
        add(placa, marca, cor, modelo, ano, preco);

    }
}
