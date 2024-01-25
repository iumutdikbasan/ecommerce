package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.request.ProductRequestDTO;
import com.example.ecommerce.dto.request.ProductUpdateDTO;
import com.example.ecommerce.dto.response.ProductResponseDTO;
import com.example.ecommerce.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductRequestDTO productRequestDTO);
    ProductRequestDTO toRequestDTO(Product product);

    Product toProduct(ProductResponseDTO productResponseDTO);
    ProductResponseDTO toResponseDTO(Product product);

    Product toProduct(ProductUpdateDTO productUpdateDTO);
    ProductUpdateDTO toUpdateDTO(Product product);
}
