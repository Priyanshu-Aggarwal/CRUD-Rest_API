package com.springrest.springrest.controller;


import com.springrest.springrest.Service.TutorialService;
import com.springrest.springrest.entities.Tutorial;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @GetMapping("/")
    public String greet()
    {
	  return "Welcome to my App";

    }

    @PostMapping("post/create")                                             //OK
    public ResponseEntity<?> CREATE(@RequestBody Tutorial tutorial)
    {
       boolean ans= tutorialService.CreateTutorial (tutorial);
       if(ans){
           return new ResponseEntity<>("Data Posted Successfully", HttpStatus.CREATED);
       }
       return new ResponseEntity<> ("Error!!",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("post/update/{id}")                                         //OK
    public ResponseEntity<?> UPDATE(@RequestBody  Tutorial tutorial, @PathVariable("id") int id)
    {
       boolean ans=tutorialService.UpdatePost (tutorial,id);
        if(ans){
            return new ResponseEntity<>("Data Updated Successfully", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<> ("Error!! ID may be wrong",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")                                                     //OK
    @Cacheable("TUTORIALS")
    public ResponseEntity<List<Tutorial>> READ()
    {
        List<Tutorial> list=tutorialService.GetAllPost ();
        return new ResponseEntity<> (list,HttpStatus.OK);
    }

    @DeleteMapping("post/delete/{id}")                                      //OK
    public ResponseEntity<?> DELETE(@PathVariable("id") int id)
    {
        boolean ans=tutorialService.DeletePost (id);
        if(ans){
            return new ResponseEntity<>("Data Updated Successfully", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<> ("Error!! ID may be wrong",HttpStatus.NOT_FOUND);
    }


    @GetMapping("post/{title}")                                             //OK
    public ResponseEntity<?> SAMETITLE(@PathVariable("title") String title)
    {
        List<Tutorial> list= tutorialService.ByTitle (title);
        return new ResponseEntity<> (list,HttpStatus.OK);
    }

}
