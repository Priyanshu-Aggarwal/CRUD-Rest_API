package com.springrest.springrest.controller;

import com.springrest.springrest.Service.CommentService;
import com.springrest.springrest.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CommentController {

   @Autowired
    private  CommentService commentService;

    @GetMapping("comment/tutorial/{id}")
    public ResponseEntity<?> READCOMMENT(@PathVariable("id") int postId) throws Exception {

	  List<Comment> list;
	  try{
		list=commentService.GetAllComments (postId);
	  }
	  catch (Exception e)
	  {
		e.printStackTrace ();
		return new ResponseEntity<> ("Please Enter Correct Post Id",HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<> (list, HttpStatus.OK);
    }

    @PostMapping("post/comment/{id}")
    public ResponseEntity<?> CREATE(@RequestBody Comment comment, @PathVariable("id")int postId)
    {
	  boolean ans=commentService.CommentSave (postId,comment);
	  if(ans){
		return new ResponseEntity<>("Comment Added Successfully!!", HttpStatus.CREATED);
	  }
	  return new ResponseEntity<> ("Error!! Tut ID may be wrong",HttpStatus.NOT_FOUND);
    }
}
