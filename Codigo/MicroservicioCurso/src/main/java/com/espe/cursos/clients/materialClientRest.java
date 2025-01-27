package com.espe.cursos.clients;


import com.espe.cursos.model.Material;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cursos", url = "http://localhost:8006/api/materiales")
public interface materialClientRest {
    @GetMapping("/{id}")
    static Material findById(@PathVariable Long id) {
        return null;
    }

}
