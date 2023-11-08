package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.model.DTO.CarroEdicaoDTO;
import net.weg.api.model.DTO.IDTO;
import net.weg.api.model.Entity.Carro;
import net.weg.api.repository.CarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Service
public class CarroService implements IService<Carro, Integer> {

    private final CarroRepository carroRepository;

    public Carro buscarUm(Integer id){
        return carroRepository.findById(id).get();
    }

    public List<Carro> buscarTodos(){
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

    public void cadastrar(IDTO idto) throws Exception {
        CarroCadastroDTO carroDTO = (CarroCadastroDTO) idto;
        //faz a conversão de carroDTO para o objeto carro:
        Carro carro = new Carro(carroDTO);
        //passa o objeto que possui as informações
        //posteriormente, passa o objeto que vai receber as informações
        BeanUtils.copyProperties(carroDTO, carro);
        if(carroRepository.existsByPlaca(carro.getPlaca())){
            throw new Exception("Já há um carro com a placa " + carro.getPlaca());
        }

        carroRepository.existsByPlaca(carro.getPlaca());
        carroRepository.save(carro);
    }

    public void editar(IDTO idto) throws Exception {
        CarroEdicaoDTO carroEDTO = (CarroEdicaoDTO) idto;
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroEDTO, carro);
        if (carroRepository.existsById(carroEDTO.getId())) {
            throw new Exception("Não foi encontrado nenhum carro com esse id");
        }
        carroRepository.save(carro);
    }

}
