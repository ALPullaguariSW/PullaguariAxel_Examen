package com.espe.materiales.controllers;

import com.espe.materiales.model.entities.Materiales;
import com.espe.materiales.services.MaterialesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materiales")


public class MaterialesController {
    @Autowired
    private MaterialesService service;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Materiales materiales){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(materiales));
    }

    @GetMapping
    public List<Materiales> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> bucarPorId(@PathVariable Long id) {
        Optional<Materiales> materialOptional = service.findById(id);
        if (materialOptional.isPresent()) {
            return ResponseEntity.ok().body(materialOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Materiales materiales, @PathVariable Long id) {
        Optional<Materiales> materialOptional = service.findById(id);
        if (materialOptional.isPresent()) {
            Materiales materialesDB = materialOptional.get();
            materialesDB.setNombre(materiales.getNombre());
            materialesDB.setDescripcion(materiales.getDescripcion());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(materialesDB));
        }
        return ResponseEntity.notFound().build();
    }
}
