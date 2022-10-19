package com.springrest.springrest.dao;

import com.springrest.springrest.entities.Comment;
import com.springrest.springrest.entities.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Integer> {

	//find Comments by tutorial id
          List<Comment> findByTutorial(Tutorial tutorial);

	//find same words content
	List<Comment> findByContentContaining(String words);
}
