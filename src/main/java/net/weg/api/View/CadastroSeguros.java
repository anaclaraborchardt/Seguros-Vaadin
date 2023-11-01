package net.weg.api.View;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import lombok.SneakyThrows;
import net.weg.api.model.DTO.SeguroCadastroDTO;
import net.weg.api.model.Entity.Carro;
import net.weg.api.model.Entity.Cliente;
import net.weg.api.model.Entity.Seguradora;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;

import java.awt.*;

public class CadastroSeguros extends FormLayout {

    private final SeguroService seguroService;

    CadastroSeguros(Dialog dialog,
                    SeguroService seguroService,
                    SeguradoraService seguradoraService,
                    CarroService carroService,
                    ClienteService clienteService) {
        this.seguroService = seguroService;

        NumberField valor = new NumberField("Valor");
        TextField descricao = new TextField("Descrição");
        NumberField franquia = new NumberField("Valor da franquia");

        Select<Seguradora> seguradora = new Select<>();
        seguradora.setLabel("Seguradora");
        seguradora.setItems(seguradoraService.buscarTodos());

        Select<Carro> carro = new Select<>();
        carro.setLabel("Veículo");
        carro.setItems(carroService.buscarTodos());

        Select<Cliente> usuario = new Select<>();
        seguradora.setLabel("Cliente");
        usuario.setItems(clienteService.buscarTodos());

        Button buttonSave = new Button("Salvar", new ComponentEventListener<ClickEvent<com.vaadin.flow.component.button.Button>>() {
            @SneakyThrows
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                SeguroCadastroDTO seguroDTO = new SeguroCadastroDTO(
                        valor.getValue(),
                        descricao.getValue(),
                        franquia.getValue(),
                        seguradora.getValue(),
                        carro.getValue(),
                        usuario.getValue()
                );

                seguroService.inserir(seguroDTO);
                dialog.close();
            }
        });

        Button buttonCancel = new Button("Cancelar", event -> dialog.close());
        dialog.getFooter().add(buttonSave, buttonCancel);
        add(valor, descricao, franquia, seguradora, carro, usuario);
    }

}
