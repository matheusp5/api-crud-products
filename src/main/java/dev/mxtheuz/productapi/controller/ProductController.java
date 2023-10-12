package dev.mxtheuz.productapi.controller;

import dev.mxtheuz.productapi.domain.dto.CreateBodyDTO;
import dev.mxtheuz.productapi.domain.dto.HttpResponse;
import dev.mxtheuz.productapi.domain.entities.Product;
import dev.mxtheuz.productapi.domain.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private IProductRepository productRepository;

    @GetMapping
    public ResponseEntity<HttpResponse> GetAllProducts() {
        List<Product> products = this.productRepository.findAll();
        return ResponseEntity.ok(new HttpResponse(200, "success", products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpResponse> GetProduct(@PathVariable("id") String id) {
        Optional<Product> product = this.productRepository.findById(id);
        if(product.isEmpty()) {
            return ResponseEntity.status(404).body(new HttpResponse(404, "not_found"));
        }
        return ResponseEntity.ok(new HttpResponse(200, "success", product));
    }

    @PostMapping
    public ResponseEntity<HttpResponse> CreateProduct(@RequestBody CreateBodyDTO dto) {
        Product product = this.productRepository.save(new Product(dto));
        return ResponseEntity.status(201).body(new HttpResponse(201, "success", product));
    }
}
