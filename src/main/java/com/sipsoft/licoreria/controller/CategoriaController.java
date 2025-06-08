package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.entity.Categoria;
import com.sipsoft.licoreria.services.ICategoriaService;

@RestController
@RequestMapping("/sipsoft")
public class CategoriaController {
    @Autowired
    private ICategoriaService serviceCategoria;

    @GetMapping("/categorias")
    public List<Categoria> buscarTodos() {
        return serviceCategoria.bucarTodos();
    }
    @PostMapping("/categorias")
    public Categoria guardar(@RequestBody Categoria categoria) {
        serviceCategoria.guardar(categoria);
        return categoria;
    }

    @PutMapping("/categorias")
    public Categoria modificar(@RequestBody Categoria categoria) {
        serviceCategoria.modificar(categoria);
        return categoria;
    }

    @GetMapping("/categorias/{idCategoria}")
    public Optional<Categoria> buscarId(@PathVariable("idCategoria") Integer idCategoria) {
        return serviceCategoria.buscarId(idCategoria);
    }

    @DeleteMapping("/categorias/{idCategoria}")
    public String eliminar(@PathVariable Integer idCategoria){
        serviceCategoria.eliminar(idCategoria);
        return "Categoria eliminada";
    }
}
