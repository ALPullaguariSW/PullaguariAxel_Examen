package com.espe.cursos.services;
import com.espe.cursos.model.entities.Curso;
import com.espe.cursos.model.Material;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> findAll();
    Curso save(Curso curso);
    Optional<Curso> findById(Long id);
    void deleteById(Long id);


    Optional<Material> addUser(Material material, Long id);
}
