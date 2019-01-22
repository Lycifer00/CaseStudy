package com.lycifer.Note.repository;

import com.lycifer.Note.model.Note;
import com.lycifer.Note.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note,Long> {
//    Page <Note> findAllByTitleContainingOrContentContainingOrIdContaining(String s,String s1,Long id, Pageable pageable);
//
//    Page <Note> findAllByNoteTypeAndTitleContainingAndIdContaining(NoteType noteType, String s,Long id, Pageable pageable);

    Page<Note> findAllByTitleContaining(String title,Pageable pageable);

    Page<Note> findAllByNoteType(NoteType noteType,Pageable pageable);
}
