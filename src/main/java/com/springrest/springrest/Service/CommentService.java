package com.springrest.springrest.Service;

import com.springrest.springrest.dao.CommentRepo;
import com.springrest.springrest.dao.TutorialRepo;
import com.springrest.springrest.entities.Comment;
import com.springrest.springrest.entities.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private TutorialRepo tutorialRepo;
    @Autowired
    private CommentRepo commentRepo;

    public boolean CommentSave(int postId, Comment comment)  {
	  Tutorial t=tutorialRepo.findById (postId).orElse (null);
	  System.out.println (t);
	  if(t==null) return false;

	  comment.setTutorial (t);
	  commentRepo.save(comment);
	  return true;
    }


    public List<Comment> GetAllComments(int postid) throws Exception {
	  Tutorial t=tutorialRepo.findById (postid).orElse (null);
	  if(t==null)
	  {
		throw new Exception ("ID Not Found");
	  }
	  return commentRepo.findByTutorial(t);

    }


}
