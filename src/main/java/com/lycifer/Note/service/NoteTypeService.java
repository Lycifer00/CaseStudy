package com.lycifer.Note.service;

import com.lycifer.Note.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteTypeService {
    Page<NoteType> findAll(Pageable pageable);

    NoteType findById(Long id);

    void save(NoteType noteType);

    void remove(Long id);
}
