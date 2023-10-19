package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class CarroService {

    private CarroRepository carroRepository;

    public Carro buscarCarro(Integer id){
        return carroRepository.findById(id).get();
    }

    public Collection<Carro> buscarTodos(){

        return carroRepository.findAll();
    }

    public void deletar(Integer id){
        carroRepository.deleteById(id);
    }

    public void inserir(Carro carro){
        carroRepository.save(carro);
    }
}
