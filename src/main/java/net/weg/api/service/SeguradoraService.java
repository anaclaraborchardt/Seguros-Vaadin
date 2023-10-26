package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.Entity.Seguradora;
import net.weg.api.repository.SeguradoraRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class SeguradoraService {

    private SeguradoraRepository seguradoraRepository;

        public Seguradora buscarSeguradora(Integer id){
            return seguradoraRepository.findById(id).get();
        }

        public Collection<Seguradora> buscarTodos(){
            return seguradoraRepository.findAll();
        }

        public void deletar(Integer id){
            seguradoraRepository.deleteById(id);
        }

        public void inserir(Seguradora seguradora){
            seguradoraRepository.save(seguradora);
        }
}
