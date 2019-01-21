package com.lycifer.Note.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Can not empty!")
    private String title;

    @NotEmpty(message = "Can not empty!")
    private String content;

    public Note(){}

    public Note(String title, String content){
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("Note[id=%d, title='%s', content='%s']", id, title, content);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

