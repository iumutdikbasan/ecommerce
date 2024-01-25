package com.example.ecommerce.controller;

import com.example.ecommerce.controller.contract.ProductControllerContract;
import com.example.ecommerce.dto.request.ProductRequestDTO;
import com.example.ecommerce.dto.request.ProductUpdateDTO;
import com.example.ecommerce.dto.response.ProductResponseDTO;
import com.example.ecommerce.error.DataResult;
import com.example.ecommerce.error.Result;
import com.example.ecommerce.error.SuccessDataResult;
import com.example.ecommerce.error.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductControllerContract productControllerContract;


    @PostMapping
    public ResponseEntity<DataResult<ProductResponseDTO>> saveProduct(@RequestBody ProductRequestDTO product){
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessDataResult<>("Kaydedildi", productControllerContract.saveProduct(product)));
    }

    @GetMapping
    public ResponseEntity<DataResult<List<ProductResponseDTO>>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi", productControllerContract.getProducts()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteProduct(@PathVariable Long id){
        productControllerContract.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResult("Silme Başarılı"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<ProductResponseDTO>> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDTO productUpdateDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Güncelleme başarılı", productControllerContract.updateProduct(id, productUpdateDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<ProductResponseDTO>> getProductById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi", productControllerContract.getProductById(id)));
    }



}
