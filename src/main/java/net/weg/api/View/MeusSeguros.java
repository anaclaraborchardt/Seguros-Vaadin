package net.weg.api.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;
import net.weg.api.model.Entity.Seguro;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;

@Route(value = "/meus-seguros", layout = NavBarApp.class)
public class MeusSeguros extends PaginaPadrao<Seguro> {

    public MeusSeguros(SeguroService seguroService,
                       SeguradoraService seguradoraService,
                       CarroService carroService,
                       ClienteService clienteService) {
        super("Meus Seguros", seguroService.buscarTodos(), Seguro.class, new Button("Novo seguro", buttonClickEvent -> {
            new CadastroSeguros(seguroService, seguradoraService, carroService, clienteService).open();
        }));

    }

}
