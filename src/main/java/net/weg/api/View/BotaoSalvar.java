package net.weg.api.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import net.weg.api.model.DTO.IDTO;
import net.weg.api.service.IService;



public class BotaoSalvar extends Button {

    BotaoSalvar(IService service, IDTO dto) throws Exception{
        Notification notification = new Notification();
        notification.setDuration(3000);
        try{
            notification.setText("Usuário cadastrado com sucesso.");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } catch (Exception e) {
            notification.setText("Erro no cadastro.");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }finally {
            notification.open();
        }
    }
}
