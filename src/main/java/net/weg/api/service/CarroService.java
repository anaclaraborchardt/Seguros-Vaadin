package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.model.DTO.CarroEdicaoDTO;
import net.weg.api.model.Entity.Carro;
import net.weg.api.repository.CarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public Carro buscarCarro(Integer id){
        return carroRepository.findById(id).get();
    }

    public Collection<Carro> buscarTodos(){
        return carroRepository.findAll();
    }

    public Collection<Carro> buscarPorSeguradora(Integer id){
        return carroRepository.findBySeguro_Seguradora_Id(id);
    }

    public Collection<Carro> buscarPorMarca(String marca){
        return carroRepository.findByMarca(marca);
    }

    public void deletar(Integer id){
        carroRepository.deleteById(id);
    }

    public Carro inserir(CarroCadastroDTO carroDTO) throws Exception {
        //faz a conversão de carroDTO para o objeto carro:
        Carro carro = new Carro(carroDTO);
        //passa o objeto que possui as informações
        //posteriormente, passa o objeto que vai receber as informações
        BeanUtils.copyProperties(carroDTO, carro);
        if(carroRepository.existsByPlaca(carro.getPlaca())){
            throw new Exception("Já há um carro com a placa " + carro.getPlaca());
        }

        carroRepository.existsByPlaca(carro.getPlaca());
        return carroRepository.save(carro);
    }

    public Carro atualizar(CarroEdicaoDTO carroEDTO) throws Exception {
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroEDTO, carro);
        if (carroRepository.existsById(carroEDTO.getId())) {
            throw new Exception("Não foi encontrado nenhum carro com esse id");
        }
        return carroRepository.save(carro);
    }

}
