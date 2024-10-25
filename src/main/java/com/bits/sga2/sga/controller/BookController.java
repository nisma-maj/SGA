package com.bits.sga2.sga.controller;

import com.bits.sga2.sga.model.Book;
import com.bits.sga2.sga.service.AuthorService;
import com.bits.sga2.sga.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/books/list";
    }

    @GetMapping("/list")
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "listBooks";  // Return the JSP file name without .jsp
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "updateBook";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        bookService.updateBook(id, book);
        return "redirect:/books/list";
    }
}
