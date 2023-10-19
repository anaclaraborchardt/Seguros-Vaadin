package net.weg.api.controller;

import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/seguro")
public class SeguroController {

    private SeguroService seguroService;

    public SeguroController(SeguroService seguroService) {
        this.seguroService = seguroService;
    }

    @GetMapping("/{id}")
    //path seria uma variável da url
    public Seguro buscarSeguro(@PathVariable Integer id){
        return seguroService.buscarSeguro(id);
    }

    @GetMapping()
    public Collection<Seguro> buscarTodos(){
        return seguroService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        seguroService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Seguro seguro){
        seguroService.inserir(seguro);
    }

    @PutMapping
    public void atualizar (@RequestBody Seguro seguro){
        seguroService.inserir(seguro);
    }
}
