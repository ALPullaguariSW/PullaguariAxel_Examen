package com.espe.materiales.services;
import com.espe.materiales.model.entities.Materiales;
import com.espe.materiales.repositories.MaterialesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MaterialesServiceImp implements MaterialesService {
    @Autowired
    private MaterialesRepository materialesRepository;
    @Override
    public List<Materiales> findAll() {
        return (List<Materiales>) materialesRepository.findAll();
    }

    @Override
    public Materiales save(Materiales material) {
        return materialesRepository.save(material);
    }
    @Override
    public Optional<Materiales> findById(Long id) {
        return materialesRepository.findById(id);
    }
    @Override
    public void deleteById(Long id) {
        materialesRepository.deleteById(id);
    }
}