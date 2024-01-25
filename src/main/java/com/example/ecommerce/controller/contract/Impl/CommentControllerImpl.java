package com.example.ecommerce.controller.contract.Impl;

import com.example.ecommerce.controller.contract.CommentControllerContract;
import com.example.ecommerce.dto.request.CommentRequestDTO;
import com.example.ecommerce.dto.response.CommentResponseDTO;
import com.example.ecommerce.exception.exceptions.MyException;
import com.example.ecommerce.mapper.CommentMapper;
import com.example.ecommerce.model.Comment;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.CommentService;
import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentControllerImpl implements CommentControllerContract {

    private final CommentService commentService;
    private final CommentMapper commentMapper;
    private final UserService userService;
    private final ProductService productService;


    @Override
    public CommentResponseDTO saveComment(CommentRequestDTO commentRequestDTO) {
        Optional<Product> product = productService.findById(commentRequestDTO.productId());
        Optional<User> user = userService.findById(commentRequestDTO.userId());

        Comment savedComment = null;
        if(product.isPresent() && user.isPresent()){
            Comment comment = commentMapper.toComment(commentRequestDTO);
            comment.setProduct(product.get());
            comment.setUser(user.get());
            savedComment = commentService.save(comment);
        }else{
            throw new MyException("Başarısız");
        }
        CommentResponseDTO commentResponseDTO = commentMapper.toResponseDTO(savedComment);
        return commentResponseDTO;
    }

    @Override
    public List<CommentResponseDTO> getComments() {
        List<CommentResponseDTO> commentResponseDTOS = commentService.findAll()
                .stream().map(commentMapper::toResponseDTO).collect(Collectors.toList());
        if(commentResponseDTOS.isEmpty()){
            throw new MyException("Henüz bir yorum yazılmamıştır.");
        }
        return commentResponseDTOS;
    }

    @Override
    public void deleteComment(Long id) {
        Optional<Comment> comment = commentService.findById(id);
        if (comment.isPresent()){
            commentService.delete(comment.get());
        }else {
            throw new MyException("Bulunamadı");
        }
    }

    @Override
    public List<CommentResponseDTO> getCommentsByProductId(Long id) {
        List<Comment> product = commentService.findAllByProductId(id);
        List<CommentResponseDTO> commentResponseDTOS = product.stream().map(commentMapper::toResponseDTO).toList();
        if(commentResponseDTOS.isEmpty()){
            throw new MyException("Ürüne henüz bir yorum yapılmadı.");
        }
        return commentResponseDTOS;
    }

    @Override
    public List<CommentResponseDTO> getCommentsByUserId(Long id) {
        List<Comment> user = commentService.findAllByUserId(id);
        List<CommentResponseDTO> commentResponseDTOS = user.stream().map(commentMapper::toResponseDTO).toList();
        if (commentResponseDTOS.isEmpty()){
            throw new MyException("Kullanıcı adına henüz bir yorum yazılmamıştır");
        }
        return commentResponseDTOS;

    }
}
