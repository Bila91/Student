package com.student.demo.Service.Implementations;


import com.student.demo.Entities.Note;
import com.student.demo.Repos.NoteRepository;
import com.student.demo.Service.Interfaces.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteImpl implements INoteService {
@Autowired
 private NoteRepository noteRepository;


    @Override
    public List<Note> getAllNotesByIdStd(Integer sno) {
       List<Note> notes = new ArrayList<>();
       noteRepository.findByStudentSno(sno).
               forEach(notes::add);
       return notes;

    }

   @Override
   public Integer saveNote(Note note) {
      return noteRepository.save(note).getNid();
   }
}
