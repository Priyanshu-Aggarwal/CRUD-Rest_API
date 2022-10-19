package com.springrest.springrest.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Published")
    private boolean published;

    public Tutorial () {

    }

    public Tutorial (int id, String title, String description, boolean published) {
	  Id = id;
	  this.title = title;
	  this.description = description;
	  this.published = published;
    }

    public int getId () {
	  return Id;
    }

    public void setId (int id) {
	  Id = id;
    }

    public String getTitle () {
	  return title;
    }

    public void setTitle (String title) {
	  this.title = title;
    }

    public String getDescription () {
	  return description;
    }

    public void setDescription (String description) {
	  this.description = description;
    }

    public boolean isPublished () {
	  return published;
    }

    public void setPublished (boolean published) {
	  this.published = published;
    }

    @Override
    public String toString () {
	  return "Tutorial{" +
		    "Id=" + Id +
		    ", title='" + title + '\'' +
		    ", description='" + description + '\'' +
		    ", published=" + published +
		    '}';
    }
}
