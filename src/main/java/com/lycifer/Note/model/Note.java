package com.lycifer.Note.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Can't not empty")
    @Size(max = 30,min = 1)
    private String title;

    @NotEmpty(message = "Can't not empty")
    @Size(max = 200 ,min = 10)
    private String content;

    @ManyToOne
    @JoinColumn(name = "noteType_id")
    private NoteType noteType;

    public Note(){}

    public Note(@NotEmpty @Size(max = 30,min = 1) String title, @NotEmpty @Size(max = 200,min = 10) String content){
        this.title = title;
        this.content = content;
    }

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(NoteType noteType) {
        this.noteType = noteType;
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

