package com.bits.sga2.sga.controller;

import com.bits.sga2.sga.model.Author;
import com.bits.sga2.sga.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/add")
    public String showAddAuthorForm() {
        return "addAuthor";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author) {
        authorService.saveAuthor(author);
        return "redirect:/authors/list";
    }

    @GetMapping("/list")
    public String listAuthors(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "listAuthors";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "updateAuthor";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable Long id, @ModelAttribute Author author) {
        authorService.updateAuthor(id, author);
        return "redirect:/authors/list";
    }
}
