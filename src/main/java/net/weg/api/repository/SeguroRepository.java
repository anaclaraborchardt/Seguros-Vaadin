package net.weg.api.repository;

import net.weg.api.model.Entity.Seguro;
import net.weg.api.model.Entity.SeguroId;
import net.weg.api.model.Entity.SeguroIdClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguroRepository extends JpaRepository<Seguro, SeguroIdClass> {
}
