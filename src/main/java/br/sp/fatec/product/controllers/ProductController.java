package br.sp.fatec.product.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.sp.fatec.product.entities.Product;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("products")
public class ProductController {

    private ArrayList<Product> list = new ArrayList<Product>();

    public ProductController() {
        list.add(new Product(1L, "product 1", "description1", 100.0));
        list.add(new Product(2L, "product 2", "description2", 200.0));
        list.add(new Product(3L, "product 3", "description3", 300.0));
    }

    @GetMapping
    public List<Product> getProducts() {
        return list;
    }

     @GetMapping("{id}")
    public Product getProductById(@PathVariable long id) {
        return list.stream()
                 .filter( p -> p.getId() == id)
                 .findFirst()
                 .orElseThrow( () -> new EntityNotFoundException("Não cadastrado"));
    }
   
}
