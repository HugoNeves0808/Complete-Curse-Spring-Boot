package com.example.springboot.services;

import com.example.springboot.models.dto.ProductRecordDto;
import com.example.springboot.interfaces.ProductInterface;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements ProductInterface {

    @Autowired
    private ProductRepository productRepository;


    // Método para salvar um produto (POST)
    @Override
    public ResponseEntity<ProductModel> saveProduct(ProductModel productModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    // Método GetAll para retornar todos os produtos (GET)
    @Override
    public ResponseEntity<List<ProductRecordDto>> getAllProducts() {
        List<ProductModel> productList = productRepository.findAll();
        // Conversion of ProductModel to ProductRecordDto using streams
        List<ProductRecordDto> dto = new ArrayList<>();
        for (ProductModel productModel : productList) {
            ProductRecordDto productRecordDto = new ProductRecordDto(productModel.getName(), productModel.getValue());
            dto.add(productRecordDto);
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    // Método para retornar um produto pelo ID (GET)
    @Override
    public ResponseEntity<ProductRecordDto> getOneProduct(UUID id) {
        Optional<ProductModel> productModel = productRepository.findById(id);
        if (productModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        ProductRecordDto productRecordDto = new ProductRecordDto(productModel.get().getName(), productModel.get().getValue());
        return ResponseEntity.status(HttpStatus.OK).body(productRecordDto);
    }

    // Método para atualizar um produto pelo ID (PUT)
    public ResponseEntity<ProductModel> updateProduct(UUID id, ProductRecordDto productRecordDto) {
        ProductModel productModel = productRepository.findById(id).get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    // Método para deletar um produto pelo ID (DELETE)
    public ResponseEntity<ProductModel> deleteProduct(UUID id) {
        ProductModel productModel = productRepository.findById(id).get();
        productRepository.delete(productModel);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productModel);
    }
}
