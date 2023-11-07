package net.weg.api.controller;

import net.weg.api.model.DTO.SeguroCadastroDTO;
import net.weg.api.model.Entity.Seguro;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/seguro")
public class SeguroController {

    private final SeguroService seguroService;

    public SeguroController(SeguroService seguroService) {
        this.seguroService = seguroService;
    }

    @GetMapping("/{id}/{seguradoraId}")
    //path seria uma variável da url
    public Seguro buscarSeguro(@PathVariable Integer id, @PathVariable Integer seguradoraId){
        return seguroService.buscarSeguro(id, seguradoraId);
    }

    @GetMapping()
    public Collection<Seguro> buscarTodos(){
        return seguroService.buscarTodos();
    }

    @DeleteMapping("/{id}/{seguradoraId}")
    public void deletar(@PathVariable Integer id, @PathVariable Integer seguradoraId){
        seguroService.deletar(id, seguradoraId);
    }

    @PostMapping()
    public void inserir(@RequestBody SeguroCadastroDTO seguro){
        seguroService.inserir(seguro);
    }

//    @PutMapping
//    public void atualizar (@RequestBody Seguro){
//        seguroService.inserir(seguro);
//    }
}
