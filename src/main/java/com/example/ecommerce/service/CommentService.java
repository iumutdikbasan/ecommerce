package com.example.ecommerce.service;

import com.example.ecommerce.general.BaseEntity;
import com.example.ecommerce.general.BaseEntityService;
import com.example.ecommerce.model.Comment;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends BaseEntityService<Comment, CommentRepository> {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository repository, CommentRepository commentRepository) {
        super(repository);
        this.commentRepository = commentRepository;
    }
    public List<Comment> findAllByUserId(Long userId) {
        return commentRepository.findAllByUserId(userId);
    }

    public List<Comment> findAllByProductId(Long productId) {
        return commentRepository.findAllByProductId(productId);
    }

    public void deleteCommentsByUser(User user) {
        commentRepository.deleteByUser(user);
    }
}
