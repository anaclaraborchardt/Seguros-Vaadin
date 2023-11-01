package net.weg.api.controller;

import net.weg.api.model.Entity.Seguradora;
import net.weg.api.service.SeguradoraService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/seguradora")
public class SeguradoraController {

    private final SeguradoraService seguradoraService;

    public SeguradoraController(SeguradoraService seguradoraService) {
        this.seguradoraService = seguradoraService;
    }

    @GetMapping("/{id}")
    //path seria uma variável da url
    public Seguradora buscarSeguradora(@PathVariable Integer id){
        return seguradoraService.buscarSeguradora(id);
    }

    @GetMapping()
    public Collection<Seguradora> buscarTodos(){

        return seguradoraService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        seguradoraService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Seguradora seguradora){
        seguradoraService.inserir(seguradora);
    }

    @PutMapping
    public void atualizar (@RequestBody Seguradora seguradora){
        seguradoraService.inserir(seguradora);
    }
}

