package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.UsuarioCadastroDTO;
import net.weg.api.model.Entity.Cliente;
import net.weg.api.model.Entity.Usuario;
import net.weg.api.repository.ClienteRepository;
import net.weg.api.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final CarroService carroService;

    public void salvar(UsuarioCadastroDTO usuario){
        Cliente usuario1 = new Cliente();
        BeanUtils.copyProperties(usuario, usuario1);
        clienteRepository.save(usuario1);
    }

    public Cliente buscarUm(Integer id) {
        Optional<Cliente> usuarioOpcional = clienteRepository.findById(id);
        Cliente usuario = usuarioOpcional.get();
        return usuario;
    }

    public Collection<Cliente> buscarTodos() {
        Collection<Cliente> usuarios = clienteRepository.findAll();
        return usuarios;
    }

    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
