package com.lycifer.Note.service.Impl;

import com.lycifer.Note.model.Note;
import com.lycifer.Note.model.NoteType;
import com.lycifer.Note.repository.NoteRepository;
import com.lycifer.Note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Page <Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id).get();
    }

    @Override
    public Page <Note> findAllByTitleContaining(String title, Pageable pageable) {
        return noteRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void remove(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Page <Note> findAllByNoteType(NoteType noteType, Pageable pageable) {
        return noteRepository.findAllByNoteType(noteType, pageable);
    }

//    @Override
//    public Page<Note> findAllByTitleContainingOrContentContainingOrIdContaining(String s, String s1, Long id, Pageable pageable) {
//        return noteRepository.findAllByTitleContainingOrContentContainingOrIdContaining(s,s1,id,pageable);
//    }
//
//    @Override
//    public Page<Note> findAllByNoteTypeAndTitleContainingAndIdContaining(NoteType noteType, String s, Long id, Pageable pageable) {
//        return noteRepository.findAllByNoteTypeAndTitleContainingAndIdContaining(noteType,s,id,pageable);
//    }


}
