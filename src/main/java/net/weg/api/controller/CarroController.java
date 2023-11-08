package net.weg.api.controller;

import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.model.DTO.CarroEdicaoDTO;
import net.weg.api.model.Entity.Carro;
import net.weg.api.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/carro")
//Request Mapping -> todas as requisições dentro de determinada controller
//tem que estar dentro de determinado caminho
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping("/{id}")
    //path seria uma variável da url
    public ResponseEntity<Carro> buscarUm(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(carroService.buscarUm(id),
                    HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/seguradora/{id}")
    //path seria uma variável da url
    public ResponseEntity<Collection<Carro>> buscarCarroSeguradora(@PathVariable Integer id){
        return new ResponseEntity<>(carroService.buscarPorSeguradora(id),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Carro>> buscarTodos(){
        return new ResponseEntity<>(carroService.buscarTodos(),
                HttpStatus.OK);
    }

    @GetMapping("/marca")
    public ResponseEntity<Collection<Carro>> buscarCarroMarca(@RequestParam String marca){
        return new ResponseEntity<>(carroService.buscarPorMarca(marca),
                HttpStatus.OK);
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        carroService.deletar(id);
    }

    @PostMapping
    public ResponseEntity<Carro> inserir(@RequestBody CarroCadastroDTO carroCadastroDTO){
        try {
            return new ResponseEntity<>(
                    HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<Carro> atualizar(@RequestBody CarroEdicaoDTO carroDTO){
        try {
            return new ResponseEntity<>(
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
