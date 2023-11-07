package net.weg.api.repository;

import net.weg.api.model.Entity.Carro;
import net.weg.api.model.Entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

    List<Carro> findByMarca(String marca);
//    Carro findBySeguro_SeguroId(Integer id);
    List<Carro> findBySeguro_Seguradora_Id(Integer id);
    boolean existsByPlaca(String placa);

}
