package com.lycifer.Note.service;

import com.lycifer.Note.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NoteService {
    Page<Note> findAll(Pageable pageable);

    Page<Note> findAllByTitleContaining(String title, Pageable pageable);

    Optional<Note> findById(Long id);

    void save(Note note);

    void remove(Long id);
}
