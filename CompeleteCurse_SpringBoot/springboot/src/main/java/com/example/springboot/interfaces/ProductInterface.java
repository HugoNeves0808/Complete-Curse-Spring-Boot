package com.example.springboot.interfaces;

import com.example.springboot.models.dto.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ProductInterface {
    ResponseEntity<ProductModel> saveProduct(ProductModel productModel);
    ResponseEntity<List<ProductRecordDto>> getAllProducts();
    ResponseEntity<ProductRecordDto> getOneProduct(UUID id);
    ResponseEntity<ProductModel> updateProduct(UUID id, ProductRecordDto productRecordDto);
    ResponseEntity<ProductModel> deleteProduct(UUID id);
}
