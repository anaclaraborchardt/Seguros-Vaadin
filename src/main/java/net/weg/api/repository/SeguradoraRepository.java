package net.weg.api.repository;

import net.weg.api.model.Entity.Seguradora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguradoraRepository extends JpaRepository<Seguradora, Integer> {
}
