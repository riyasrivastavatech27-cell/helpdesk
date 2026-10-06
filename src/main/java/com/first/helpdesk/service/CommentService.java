package com.first.helpdesk.service;
import java.util.List;
import com.first.helpdesk.repository.CommentRepository;
import com.first.helpdesk.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private  final CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
    }
    public Comment createComment(Comment comment){
        return commentRepository.save(comment);
    }
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }
    public Comment getCommentById(int id){
        return commentRepository.findById(id).orElseThrow();
    }
    public void deleteComment(int id){
        commentRepository.deleteById(id);
    }
}
