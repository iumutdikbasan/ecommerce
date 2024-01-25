package com.example.ecommerce.controller;

import com.example.ecommerce.controller.contract.CommentControllerContract;
import com.example.ecommerce.dto.request.CommentRequestDTO;
import com.example.ecommerce.dto.response.CommentResponseDTO;
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
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentControllerContract commentControllerContract;

    @PostMapping
    public ResponseEntity<DataResult<CommentResponseDTO>> saveComment(@RequestBody CommentRequestDTO comment){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessDataResult<>("Listelendi",commentControllerContract.saveComment(comment)));
    }
    @GetMapping
    public ResponseEntity<DataResult<List<CommentResponseDTO>>> getAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(new SuccessDataResult<>("Listelendi",commentControllerContract.getComments()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteComment(@PathVariable Long id){
        commentControllerContract.deleteComment(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResult("Silme Başarılı"));
    }
    @GetMapping("/byProduct/{productId}")
    public ResponseEntity<DataResult<List<CommentResponseDTO>>> getCommentsByProductId(@PathVariable Long productId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(new SuccessDataResult<>("Listelendi",commentControllerContract.getCommentsByProductId(productId)));
    }
    @GetMapping("/byUser/{userId}")
    public ResponseEntity<DataResult<List<CommentResponseDTO>>> getCommentsByUserId(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(new SuccessDataResult<>("Listelendi",commentControllerContract.getCommentsByUserId(userId)));
    }

}
