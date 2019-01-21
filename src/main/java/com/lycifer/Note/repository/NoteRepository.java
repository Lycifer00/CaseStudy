package com.lycifer.Note.repository;

import com.lycifer.Note.model.Note;
import com.lycifer.Note.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note,Long> {
    Page <Note> findAllByTitleContaining(String title, Pageable pageable);

    Page <Note> findAllByNoteType(NoteType noteType, Pageable pageable);
}
