package com.example.ecommerce.service;

import com.example.ecommerce.general.BaseEntityService;
import com.example.ecommerce.model.Comment;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.CommentRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseEntityService<Product, ProductRepository> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    public ProductService(ProductRepository repository) {
        super(repository);
    }

    public Product updateProduct(Integer price, Long id) {
        Product product1 = productRepository.findById(id).orElseThrow(); //hata
        product1.setPrice(price);
        return save(product1);
    }

    @Transactional
    public void deleteProduct(Long productId) {
        List<Comment> comments = commentRepository.findAllByProductId(productId);
        for (Comment comment : comments) {
            comment.setProduct(null);
            commentRepository.save(comment);
            commentRepository.deleteById(comment.getId());
        }

        productRepository.deleteById(productId);
    }
}
