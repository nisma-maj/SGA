package com.bits.sga2.sga.service;

import com.bits.sga2.sga.model.Author;
import com.bits.sga2.sga.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author updateAuthor(Long id, Author author) {
        author.setId(id);
        return authorRepository.save(author);
    }
}
