package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/carro")
//Request Mapping -> todas as requisições dentro de determinada controller
//tem que estar dentro de determinado caminho
public class CarroController {

    private CarroService carroService;

    @GetMapping("/{id}")
    //path seria uma variável da url
    public Carro buscarCarro(@PathVariable Integer id){
        return carroService.buscarCarro(id);
    }

    @GetMapping()
    public Collection<Carro> buscarTodos(){
        return carroService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        carroService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Carro carro){
        carroService.inserir(carro);
    }

    @PutMapping
    public void atualizar(@RequestBody Carro carro){
        carroService.inserir(carro);
    }


}
