package com.example.servicioproducto.controller;

import com.example.servicioproducto.model.entity.Product;
import com.example.servicioproducto.model.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    final ProductRepository productRepository;
    final Environment environment;

    public ProductController(ProductRepository productRepository, Environment environment) {
        this.productRepository = productRepository;
        this.environment = environment;
    }

    @GetMapping("/listar")
    public List<Product> listar() {
        List<Product> list = productRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            int port = Integer.parseInt(environment.getProperty("local.server.port"));
            list.get(i).setPort(port);
        }
        return list;
    }

    @GetMapping(value = "/obtener/{id}")
    public Product obtenerProductoPorId(@PathVariable("id") int id) throws InterruptedException {
        if(id == 10)
            throw new IllegalStateException("Producto no encontrado");

        if(id == 20)
            Thread.sleep(5000);

        Optional<Product> optional = productRepository.findById(id);
        return optional.orElse(null);
    }
}
