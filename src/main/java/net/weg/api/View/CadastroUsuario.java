package net.weg.api.View;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import lombok.SneakyThrows;
import net.weg.api.model.DTO.EnderecoCadastroDTO;
import net.weg.api.model.DTO.UsuarioCadastroDTO;
import net.weg.api.model.Entity.Endereco;
import net.weg.api.service.ClienteService;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;

@Route(value = "cadastro", layout = NavBarApp.class)
public class CadastroUsuario extends FormLayout {

    private ClienteService clienteService;

    private final TextField usuario = new TextField("Nome");
    private final PasswordField senha = new PasswordField("Senha");
    private final PasswordField confirmacaoSenha = new PasswordField("Confirmar Senha");;
    private final IntegerField idade = new IntegerField("Idade");
    private final Grid<EnderecoCadastroDTO> gridEnderecos = new Grid<>(EnderecoCadastroDTO.class);
    private final Dialog cadastroEndereco = new Dialog();
    private Button cancelar;

    public CadastroUsuario(ClienteService clienteService) {
        this.clienteService = clienteService;
        cadastroEndereco.add(new CadastroEndereco(gridEnderecos, cadastroEndereco));
        Button novoEndereco = new Button("Novo Endereço", event -> cadastroEndereco.open());

        Button salvar = new Button("Salvar", event -> {
            Set<Endereco> enderecos = new HashSet<>();

            Notification notification = new Notification();
            notification.setDuration(3000);
            try {
                gridEnderecos.getListDataView().getItems().forEach(
                        enderecoCadastroDTO -> {
                            Endereco endereco = new Endereco();
                            BeanUtils.copyProperties(enderecoCadastroDTO, endereco);
                            enderecos.add(endereco);
                        }
                );

                clienteService.salvar(new UsuarioCadastroDTO(
                        usuario.getValue(),
                        senha.getValue(),
                        idade.getValue(),
                        enderecos));

                notification.setText("Usuário cadastrado com sucesso.");
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            } catch (Exception e) {
                notification.setText("Erro no cadastro.");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            } finally {
                notification.open();
            }
        });

        cancelar = new Button("Cancelar", event -> new UI().navigate("/"));

        add(usuario, senha, confirmacaoSenha, idade, salvar, cancelar, novoEndereco, gridEnderecos);
    }
}
