package com.espe.materiales.services;


import com.espe.materiales.model.entities.Materiales;

import java.util.List;
import java.util.Optional;

public interface MaterialesService {
    List<Materiales> findAll();
    Materiales save(Materiales materiales);
    Optional<Materiales> findById(Long id);
    void deleteById(Long id);

}
