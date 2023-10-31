package net.weg.api.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.api.model.Entity.Seguro;
import net.weg.api.repository.SeguroRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class SeguroService {

        private final SeguroRepository seguroService;
//
//        public Seguro buscarSeguro(Integer id){
//            return seguroService.findById(id).get();
//        }

        public Collection<Seguro> buscarTodos(){
            return seguroService.findAll();
        }

//        public void deletar(Integer id){
//            seguroService.deleteById(id);
//        }

        public void inserir(Seguro seguro){
            seguroService.save(seguro);
        }
}
