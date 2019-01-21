package com.lycifer.Note.controllers;

import com.lycifer.Note.model.Note;
import com.lycifer.Note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/")
    public ModelAndView listNotes(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Note> notes;
        if(s.isPresent()){
            notes = noteService.findAllByTitleContaining(s.get(), pageable);
        } else {
            notes = noteService.findAll(new PageRequest(pageable.getPageNumber(), 4));
        }
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }

//    @GetMapping("/create-note")
//    public ModelAndView showCreateForm(){
//        ModelAndView modelAndView = new ModelAndView("create");
//        modelAndView.addObject("note",new Note());
//        return modelAndView;
//    }
//
//    @PostMapping("/create-note")
//    public ModelAndView saveNote(@ModelAttribute("note") Note note){
//        noteService.save(note);
//
//        ModelAndView modelAndView = new ModelAndView("create");
//        modelAndView.addObject("note", new Note());
//        modelAndView.addObject("message", "New note created successfully!");
//        return modelAndView;
//    }
//
//    @GetMapping("/edit-note/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id){
//        Optional<Note> note = noteService.findById(id);
//        if(note.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/edit");
//            modelAndView.addObject("note", note);
//            return modelAndView;
//
//        }else {
//            return new ModelAndView("/error-404");
//        }
//    }
//
//    @PostMapping("/edit-note")
//    public ModelAndView updateNote(@ModelAttribute("note") Note note){
//        noteService.save(note);
//        ModelAndView modelAndView = new ModelAndView("/edit");
//        modelAndView.addObject("note", note);
//        modelAndView.addObject("message", "Note updated successfully!");
//        return modelAndView;
//    }
//
//    @GetMapping("/delete-note/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id){
//        Optional<Note> note = noteService.findById(id);
//        if(note.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/delete");
//            modelAndView.addObject("note", note);
//            return modelAndView;
//
//        }else {
//            return new ModelAndView("/error-404");
//        }
//    }
//
//    @PostMapping("/delete-note")
//    public String deleteCustomer(@ModelAttribute("note") Note note){
//        noteService.remove(note.getId());
//        return "redirect:/";
//    }
}
