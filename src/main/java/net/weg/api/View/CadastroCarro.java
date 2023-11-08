package net.weg.api.View;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import lombok.SneakyThrows;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.service.CarroService;
import com.vaadin.flow.component.dialog.Dialog;

public class CadastroCarro extends Dialog {

    public CadastroCarro(CarroService carroService) {

        TextField placa = new TextField("Placa");
        TextField marca = new TextField("Marca");
        TextField cor = new TextField("Cor");
        TextField modelo = new TextField("Modelo");
        IntegerField ano = new IntegerField("Ano");
        IntegerField preco = new IntegerField("Preço");
        add(placa, marca, cor, modelo, ano, preco);

        Button buttonSave = new Button("Salvar", event ->{
                CarroCadastroDTO carroDTO = new CarroCadastroDTO(
                        placa.getValue(),
                        marca.getValue(),
                        cor.getValue(),
                        modelo.getValue(),
                        ano.getValue(),
                        preco.getValue());
            try {
                carroService.cadastrar(carroDTO);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            this.close();
            });

        Button buttonCancel = new Button("Cancelar", event -> this.close());
        this.getFooter().add(buttonSave, buttonCancel);
        add(placa, marca, cor, modelo, ano, preco);

    }
}
