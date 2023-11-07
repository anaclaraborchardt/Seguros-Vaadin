package net.weg.api.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.api.model.DTO.SeguroCadastroDTO;
import net.weg.api.model.Entity.Seguro;
import net.weg.api.model.Entity.SeguroId;
import net.weg.api.repository.SeguroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class SeguroService {

        private final SeguroRepository seguroRepository;
//
        public Seguro buscarSeguro(Integer id, Integer seguradoraId){
            return seguroRepository.findById(new SeguroId(id, seguradoraId)).get();
        }

        public Collection<Seguro> buscarTodos(){
            return seguroRepository.findAll();
        }

        public void deletar(Integer id, Integer seguradoraId){
            seguroRepository.deleteById(new SeguroId(id, seguradoraId));
        }

        public void inserir(SeguroCadastroDTO seguroCadastroDTO){
            Seguro seguro = new Seguro();
            BeanUtils.copyProperties(seguroCadastroDTO, seguro);
            seguroRepository.save(seguro);
        }
}
