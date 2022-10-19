package com.springrest.springrest.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/* Many to One mapping is considered Best as compared to One to Many*/


@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CId;



    private String content;

    //Many comments associated with one tutorial.

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private Tutorial tutorial;

    public Comment () {
    }


    public Comment (int id, String content, Tutorial tutorial) {
        CId = id;
        this.content = content;
        this.tutorial = tutorial;
    }

    public int getId () {
        return CId;
    }

    public void setId (int id) {
        CId = id;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public Tutorial getTutorial () {
        return tutorial;
    }

    public void setTutorial (Tutorial tutorial) {
        this.tutorial = tutorial;
    }

    @Override
    public String toString () {
        return "Comment{" +
                "Id=" + CId +
                ", content='" + content + '\'' +
                ", tutorial=" + tutorial +
                '}';
    }
}
