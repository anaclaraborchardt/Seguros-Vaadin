package net.weg.api.controller;

import net.weg.api.model.Entity.Cliente;
import net.weg.api.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/usuario")
//Request Mapping -> todas as requisições dentro de determinada controller
//tem que estar dentro de determinado caminho
public class ClienteController {

    private ClienteService usuarioService;

    public ClienteController(ClienteService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    //path seria uma variável da url
    public Cliente buscarUsuario(@PathVariable Integer id){
       return usuarioService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Cliente> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        usuarioService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Cliente usuario){
        usuarioService.salvar(usuario);
    }

    @PutMapping
    public void atualizar (@RequestBody Cliente usuario){
        usuarioService.salvar(usuario);
    }
}
