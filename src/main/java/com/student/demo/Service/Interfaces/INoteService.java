package com.student.demo.Service.Interfaces;


import com.student.demo.Entities.Note;
import com.student.demo.Entities.Student;

import java.util.List;

public interface INoteService {

    public List<Note> getAllNotesByIdStd(Integer sno);

    public Integer saveNote(Note note);
}
