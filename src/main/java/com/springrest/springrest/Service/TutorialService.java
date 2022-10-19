package com.springrest.springrest.Service;

import com.springrest.springrest.dao.TutorialRepo;
import com.springrest.springrest.entities.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {


    @Autowired
    private TutorialRepo tutorialRepo;

    //creating
    public boolean CreateTutorial(Tutorial tutorial)
    {
	  if(tutorial==null) return false;
	  tutorialRepo.save (tutorial);
	  return true;
    }

    //updating
    public boolean UpdatePost(Tutorial tutorial,int id)
    {
	 Tutorial t= tutorialRepo.findById (id).orElse (null);
	 if(t==null){
	     return false;
	 }
	 t.setTitle (tutorial.getTitle ());
	 t.setDescription (tutorial.getDescription ());
	 t.setPublished (tutorial.isPublished ());
	 tutorialRepo.save (t);
	 return true;
    }

    //find All post
    public List<Tutorial> GetAllPost()
    {
	   return tutorialRepo.findAll (Sort.by ("title"));
    }

    //delete
    public boolean DeletePost(int id)
    {
	  Tutorial t= tutorialRepo.findById (id).orElse (null);
	  if(t==null){
		return false;
	  }
	  tutorialRepo.deleteById (id);
	  return true;
    }

    public List<Tutorial> ByTitle(String title)
    {
	  return tutorialRepo.findByTitleContaining (title);
    }
}
