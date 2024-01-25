package com.example.ecommerce.controller.contract;

import com.example.ecommerce.dto.request.CommentRequestDTO;
import com.example.ecommerce.dto.response.CommentResponseDTO;
import com.example.ecommerce.model.Comment;

import java.util.List;

public interface CommentControllerContract {
    CommentResponseDTO saveComment(CommentRequestDTO commentRequestDTO);
    List<CommentResponseDTO> getComments();
    void deleteComment(Long id);
    List<CommentResponseDTO> getCommentsByProductId(Long id);
    List<CommentResponseDTO> getCommentsByUserId(Long id);
}
