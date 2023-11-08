package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.IDTO;
import net.weg.api.model.DTO.SeguradoraCadastroDTO;
import net.weg.api.model.Entity.Seguradora;
import net.weg.api.repository.SeguradoraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SeguradoraService implements IService<Seguradora, Integer> {

    private final SeguradoraRepository seguradoraRepository;

        public Seguradora buscarSeguradora(Integer id){
            return seguradoraRepository.findById(id).get();
        }
        public List<Seguradora> buscarTodos(){
            return seguradoraRepository.findAll();
        }

    @Override
    public void cadastrar(IDTO dto) throws Exception {
        SeguradoraCadastroDTO seguradoraDTO = (SeguradoraCadastroDTO) dto;
        Seguradora seguradora = new Seguradora();
        BeanUtils.copyProperties(seguradoraDTO, seguradora);
        seguradoraRepository.save(seguradora);
    }

    @Override
    public void editar(IDTO dto) throws Exception {

    }

    public void deletar(Integer id){
            seguradoraRepository.deleteById(id);
        }

    @Override
    public Seguradora buscarUm(Integer integer) {
        return null;
    }
}
