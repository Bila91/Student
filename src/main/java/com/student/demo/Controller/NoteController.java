package com.student.demo.Controller;

import com.student.demo.Entities.Note;
import com.student.demo.Entities.Student;
import com.student.demo.Service.Interfaces.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/NotesDetails")
public class NoteController {

    @Autowired
    private INoteService noteService;

    @GetMapping("/AllNotesByIdStudent/{sno}")
    public ResponseEntity<List<Note>> getAllNotesByIdstud(@PathVariable Integer sno)
    {

        List<Note> list = noteService.getAllNotesByIdStd(sno);
        return new ResponseEntity<List<Note>>(list, HttpStatus.OK);

    }

    @PostMapping("/saveNote")
    public ResponseEntity<String> saveNote( @RequestBody Note note){
        Integer id = noteService.saveNote(note);
        return  new ResponseEntity<String>("Note with '"+id+"' has been saved", HttpStatus.OK);

    }


}
