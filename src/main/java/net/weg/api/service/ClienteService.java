package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.model.DTO.CarroEdicaoDTO;
import net.weg.api.model.DTO.IDTO;
import net.weg.api.model.DTO.UsuarioCadastroDTO;
import net.weg.api.model.Entity.Carro;
import net.weg.api.model.Entity.Cliente;
import net.weg.api.model.Entity.Usuario;
import net.weg.api.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService implements IService<Cliente, Integer> {

    private final ClienteRepository clienteRepository;
    private final CarroService carroService;

    public Cliente buscarUm(Integer id) {
        Optional<Cliente> usuarioOpcional = clienteRepository.findById(id);
        Cliente usuario = usuarioOpcional.get();
        return usuario;
    }

    public List<Cliente> buscarTodos() {
        List<Cliente> usuarios = clienteRepository.findAll();
        return usuarios;
    }

    @Override
    public void cadastrar(IDTO dto) throws Exception {
        UsuarioCadastroDTO usuarioCadastroDTO = (UsuarioCadastroDTO) dto;
        //faz a conversão de carroDTO para o objeto carro:
        Cliente cliente = new Cliente(usuarioCadastroDTO);
        BeanUtils.copyProperties(usuarioCadastroDTO, cliente);
        clienteRepository.save(cliente);
    }

    @Override
    public void editar(IDTO dto) throws Exception {

    }

//    public void editar(IDTO idto) throws Exception {
//        UsuarioCadastroDTO usuarioCadastroDTO = (UsuarioCadastroDTO) idto;
//        Usuario usuario = new Usuario();
//        BeanUtils.copyProperties(usuarioCadastroDTO, usuario);
//        if (clienteRepository.existsById(usuarioCadastroDTO.getId())) {
//            throw new Exception("Não foi encontrado nenhum carro com esse id");
//        }
//        carroRepository.save(carro);
//    }

    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
