package com.lycifer.Note.controllers;

import com.lycifer.Note.model.Note;
import com.lycifer.Note.model.NoteType;
import com.lycifer.Note.service.NoteService;
import com.lycifer.Note.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class NoteTypeController {
    @Autowired
    private NoteTypeService noteTypeService;

    @Autowired
    private NoteService noteService;

    @GetMapping("/note-types")
    public ModelAndView listNoteTypes(Pageable pageable) {
        Page <NoteType> noteTypes = noteTypeService.findAll(new PageRequest(pageable.getPageNumber(), 5));
        ModelAndView modelAndView = new ModelAndView("notetype/list");
        modelAndView.addObject("noteTypes", noteTypes);
        return modelAndView;
    }

    @GetMapping("/create-notetype")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("notetype/create");
        modelAndView.addObject("noteType", new NoteType());
        return modelAndView;
    }

    @PostMapping("/create-notetype")
    public String saveNoteType(@Validated @ModelAttribute NoteType noteType,
                               BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("note", new NoteType());
            model.addAllAttributes(bindingResult.getModel());
            return "notetype/create";
        } else {
            noteTypeService.save(noteType);
            model.addAttribute("noteType", noteType);
            redirectAttributes.addFlashAttribute("message", "New NoteType created successfully");
            return "redirect:/note-types";
        }
    }

    @GetMapping("/edit-notetype/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        NoteType noteType = noteTypeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("notetype/edit");
        modelAndView.addObject("noteType", noteType);
        return modelAndView;
    }


    @PostMapping("/edit-notetype")
    public String updateType(@Valid @ModelAttribute NoteType noteType
            , BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("noteType", new NoteType());
            model.addAllAttributes(bindingResult.getModel());
            return "notetype/edit";
        } else {
            noteTypeService.save(noteType);
            model.addAttribute("noteType", noteType);
            redirectAttributes.addFlashAttribute("message", "New Type updated successfully");
            return "redirect:/note-types";
        }
    }

    @RequestMapping("/delete-notetype/{id}")
    public String deleteType(@PathVariable Long id) {
        NoteType noteType = noteTypeService.findById(id);
        noteTypeService.remove(id);
        return "redirect:/note-types";
    }

    @GetMapping("/view-notetype/{id}")
    public ModelAndView viewType(@PathVariable Long id, Pageable pageable) {
        NoteType noteType = noteTypeService.findById(id);
        Page<Note> notes = noteService.findAllByNoteType(noteType, pageable);
        ModelAndView modelAndView = new ModelAndView("notetype/view");
        modelAndView.addObject("noteType", noteType);
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }

}
