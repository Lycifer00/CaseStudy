package com.lycifer.Note.service.Impl;

import com.lycifer.Note.model.Note;
import com.lycifer.Note.repository.NoteRepository;
import com.lycifer.Note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Page<Note> findAll(Pageable pageable){
        return noteRepository.findAll(pageable);
    }

    @Override
    public Page<Note> findAllByTitleContaining(String title, Pageable pageable){
        return noteRepository.findAllByTitleContaining(title,pageable);
    }

    @Override
    public Optional<Note> findById(Long id){
        return noteRepository.findById(id);
    }

    @Override
    public void save(Note note){
        noteRepository.save(note);
    }

    @Override
    public void remove(Long id){
        noteRepository.deleteById(id);
    }
}
