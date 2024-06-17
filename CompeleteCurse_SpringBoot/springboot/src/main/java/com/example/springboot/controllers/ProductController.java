package com.example.springboot.controllers;

import com.example.springboot.models.dto.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // Método para salvar um produto (POST)
    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductModel productRecordDto) {
        return productService.saveProduct(productRecordDto);
    }

    // Método GetAll para retornar todos os produtos (GET)
    @GetMapping("/products")
    public ResponseEntity<List<ProductRecordDto>> getAllProducts() {
        return productService.getAllProducts();
    }

    // Método para retornar um produto pelo ID (GET)
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductRecordDto> getOneProduct(@PathVariable(value="id") UUID id) {
        return productService.getOneProduct(id);
    }

    // Método para atualizar um produto pelo ID (PUT)
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable(value="id") UUID id, @RequestBody ProductRecordDto productRecordDto) {
        return productService.updateProduct(id, productRecordDto);
    }

    // Método para deletar um produto pelo ID (DELETE)
    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductModel> deleteProduct(@PathVariable(value="id") UUID id) {
        return productService.deleteProduct(id);
    }
}
