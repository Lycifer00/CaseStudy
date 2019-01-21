package com.lycifer.Note.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "noteTypes")
public class NoteType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;
    private String description;

    @OneToMany(mappedBy = "noteType")
    private Set <Note> notes;

    public NoteType() {
    }

    public NoteType(@NotEmpty String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Set <Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
