package com.first.helpdesk.controller;
import com.first.helpdesk.service.CommentService;
import com.first.helpdesk.entity.Comment;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final  CommentService commentService;
    public CommentController(CommentService commentService){
        this.commentService=commentService;
    }
    @PostMapping
    public Comment createComment(@RequestBody Comment comment){
         return commentService.createComment(comment);
    }
    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }
    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable int id){
        return commentService.getCommentById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable int id){
         commentService.deleteComment(id);
    }
}
