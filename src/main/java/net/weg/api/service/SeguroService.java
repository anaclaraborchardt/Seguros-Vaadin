package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.IDTO;
import net.weg.api.model.DTO.SeguradoraCadastroDTO;
import net.weg.api.model.DTO.SeguroCadastroDTO;
import net.weg.api.model.Entity.Seguradora;
import net.weg.api.model.Entity.Seguro;
import net.weg.api.model.Entity.SeguroId;
import net.weg.api.repository.SeguroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SeguroService implements IService<Seguro, SeguroId> {

        private final SeguroRepository seguroRepository;
//
        public Seguro buscarSeguro(Integer id, Integer seguradoraId){
            return seguroRepository.findById(new SeguroId(id, seguradoraId)).get();
        }

    @Override
    public void cadastrar(IDTO dto) throws Exception {
        SeguroCadastroDTO seguroCadastroDTO = (SeguroCadastroDTO) dto;
        Seguro seguro = new Seguro();
        BeanUtils.copyProperties(seguroCadastroDTO, seguro);
        seguroRepository.save(seguro);
    }

    @Override
    public void editar(IDTO dto) throws Exception {

    }

    @Override
    public void deletar(SeguroId seguroId) {
        seguroRepository.deleteById(seguroId);
    }

    @Override
    public Seguro buscarUm(SeguroId seguroId) {
        return seguroRepository.findById(seguroId).get();
    }

    public List<Seguro> buscarTodos(){
            return seguroRepository.findAll();
        }

        public void deletar(Integer id, Integer seguradoraId){
            seguroRepository.deleteById(new SeguroId(id, seguradoraId));
        }
}
