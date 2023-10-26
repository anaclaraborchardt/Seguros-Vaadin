package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.Entity.Cliente;
import net.weg.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository usuarioRepository;
    private CarroService carroService;

    public void salvar(Cliente usuario){
        usuarioRepository.save(usuario);
    }

    public Cliente buscarUm(Integer id) {
        Optional<Cliente> usuarioOpcional = usuarioRepository.findById(id);
        Cliente usuario = usuarioOpcional.get();
        return usuario;
    }

    public Collection<Cliente> buscarTodos() {
        Collection<Cliente> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
