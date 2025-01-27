package com.espe.cursos.services;
import com.espe.cursos.clients.materialClientRest;
import com.espe.cursos.model.entities.Curso;
import com.espe.cursos.model.entities.CursoMaterial;
import com.espe.cursos.model.Material;
import com.espe.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImp implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public List<Curso> findAll() {
        List<Curso> cursos = (List<Curso>) cursoRepository.findAll();
        for (Curso curso : cursos) {
            // Llenar los materiales asociados
            List<Material> materiales = new ArrayList<>();
            for (CursoMaterial cursoMaterial : curso.getCursoMaterials()) {
                Material material = materialClientRest.findById(cursoMaterial.getMaterialId());
                materiales.add(material);
            }
            curso.setMaterial(materiales); // Asignar los materiales al curso
        }
        return cursos;
    }


    @Autowired
    private materialClientRest clientRest;


    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }
    public Optional<Curso> findById(Long id) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isPresent()) {
            Curso curso = cursoOptional.get();
            List<Material> materiales = new ArrayList<>();
            for (CursoMaterial cursoMaterial : curso.getCursoMaterials()) {
                Material material = materialClientRest.findById(cursoMaterial.getMaterialId());
                materiales.add(material);
            }
            curso.setMaterial(materiales); // Asignar los materiales al curso
        }
        return cursoOptional;
    }
    @Override
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }


    @Override
    public Optional<Material> addUser(Material material, Long id) {
        Optional<Curso> optional = cursoRepository.findById(id);
        if (optional.isPresent()) {
            Material materialTemp = materialClientRest.findById(material.getId());

            Curso curso = optional.get();
            CursoMaterial cursoMaterial = new CursoMaterial();

            cursoMaterial.setMaterialId(materialTemp.getId());

            curso.addCursoMaterial(cursoMaterial);
            cursoRepository.save(curso);
            return Optional.of(materialTemp);

        }
        return Optional.empty();
    }
}
