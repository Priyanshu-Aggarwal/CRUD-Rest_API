package com.springrest.springrest.dao;

import com.springrest.springrest.entities.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TutorialRepo extends JpaRepository<Tutorial, Integer> {

    //find List of Tutorials containing giving titles
     List<Tutorial> findByTitleContaining(String title);



}
