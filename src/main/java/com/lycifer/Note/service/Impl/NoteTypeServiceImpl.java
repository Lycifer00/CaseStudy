package com.lycifer.Note.service.Impl;

import com.lycifer.Note.model.NoteType;
import com.lycifer.Note.repository.NoteTypeRepository;
import com.lycifer.Note.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    private NoteTypeRepository noteTypeRepository;

    @Override
    public Page<NoteType> findAll(Pageable pageable) {
        return noteTypeRepository.findAll(pageable);
    }

    @Override
    public NoteType findById(Long id) {
        return noteTypeRepository.findById(id).get();
    }

    @Override
    public void save(NoteType noteType) {
        noteTypeRepository.save(noteType);
    }

    @Override
    public void remove(Long id) {
        noteTypeRepository.deleteById(id);
    }
}
