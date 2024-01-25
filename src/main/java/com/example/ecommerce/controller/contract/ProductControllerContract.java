package com.example.ecommerce.controller.contract;

import com.example.ecommerce.dto.request.ProductRequestDTO;
import com.example.ecommerce.dto.request.ProductUpdateDTO;
import com.example.ecommerce.dto.response.CommentResponseDTO;
import com.example.ecommerce.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductControllerContract {
    ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO);
    List<ProductResponseDTO> getProducts();
    void deleteProduct(Long id);
    ProductResponseDTO updateProduct(Long id, ProductUpdateDTO productUpdateDTO);

    ProductResponseDTO getProductById(Long id);

}
