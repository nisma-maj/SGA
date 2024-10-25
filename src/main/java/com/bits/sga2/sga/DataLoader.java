package com.bits.sga2.sga;

import com.bits.sga2.sga.model.Author;
import com.bits.sga2.sga.model.Book;
import com.bits.sga2.sga.repository.AuthorRepository;
import com.bits.sga2.sga.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataLoader(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author();
        author1.setName("Author One");
        author1.setBiography("Biography of Author One");
        authorRepository.save(author1);

        Author author2 = new Author();
        author2.setName("Author Two");
        author2.setBiography("Biography of Author Two");
        authorRepository.save(author2);

        for (int i = 1; i <= 10; i++) {
            Book book = new Book();
            book.setTitle("Book Title " + i);
            book.setIsbn("ISBN-" + i);
            book.setAuthor(i % 2 == 0 ? author1 : author2);
            bookRepository.save(book);
        }
    }
}
