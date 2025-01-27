package com.espe.materiales.repositories;
import com.espe.materiales.model.entities.Materiales;
import org.springframework.data.repository.CrudRepository;

public interface MaterialesRepository extends CrudRepository<Materiales, Long> {
}
