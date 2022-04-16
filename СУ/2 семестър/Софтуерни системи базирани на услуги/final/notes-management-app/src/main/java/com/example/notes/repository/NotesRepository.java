package com.example.notes.repository;

import com.example.notes.model.Note;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<Note, Long>{
    List<Note> findById(String noteId);
    List<Note> findAll();
}
