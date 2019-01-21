package com.lycifer.Note.repository;

import com.lycifer.Note.model.NoteType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteTypeRepository extends PagingAndSortingRepository<NoteType,Long> {
}
