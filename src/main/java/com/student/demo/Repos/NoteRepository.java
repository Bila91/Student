package com.student.demo.Repos;

import com.student.demo.Entities.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {
    public List<Note> findByStudentSno(Integer sno);
}
