package com.lycifer.Note.service;

import com.lycifer.Note.model.Note;
import com.lycifer.Note.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    Page <Note> findAllByTitleContaining(String title, Pageable pageable);

    Page <Note> findAll(Pageable pageable);

    Note findById(Long id);

    void save(Note note);

    void remove(Long id);

    Page <Note> findAllByNoteType(NoteType noteType, Pageable pageable);
}
