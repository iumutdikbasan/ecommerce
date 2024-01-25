package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.request.CommentRequestDTO;
import com.example.ecommerce.dto.response.CommentResponseDTO;
import com.example.ecommerce.model.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment toComment(CommentResponseDTO commentResponseDTO);

    CommentResponseDTO toResponseDTO(Comment comment);
    Comment toComment(CommentRequestDTO commentRequestDTO);
    CommentRequestDTO toRequestDTO(Comment comment);
}
