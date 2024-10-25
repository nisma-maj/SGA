package com.bits.sga2.sga;

import com.bits.sga2.sga.model.Author;
import com.bits.sga2.sga.model.Book;
import com.bits.sga2.sga.repository.BookRepository;
import com.bits.sga2.sga.service.BookService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private List<Book> bookList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        MockitoAnnotations.openMocks(this);

        // Initialize authors with name and nationality
        Author authorOne = new Author("Author One", "American");
        Author authorTwo = new Author("Author Two", "British");

        // Initialize book list with title, genre, and authors
        bookList = new ArrayList<>();
        bookList.add(new Book("Book One", "123", authorOne));
        bookList.add(new Book("Book Two", "456", authorTwo));
    }

    @Test
    public void testAddBook() {
        // Arrange
        Book newBook = new Book("New Book", "Fiction", new Author("New Author", "Canadian"));
        when(bookRepository.save(any(Book.class))).thenReturn(new Book("New Book", "Fiction", new Author("New Author", "Canadian")));

        // Act
        Book savedBook = bookService.saveBook(newBook);

        // Assert
        assertNotNull(savedBook);
        assertEquals("New Book", savedBook.getTitle());
        assertEquals("789", savedBook.getIsbn());
        verify(bookRepository, times(1)).save(newBook);
    }

    @Test
    public void testGetAllBooks() {
        // Arrange
        when(bookRepository.findAll()).thenReturn(bookList);

        // Act
        List<Book> books = bookService.getAllBooks();

        // Assert
        assertNotNull(books);
        assertEquals(2, books.size());
        assertEquals("Book One", books.get(0).getTitle());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    public void testGetBookById() {
        // Arrange
        when(bookRepository.findById(1L)).thenReturn(Optional.of(bookList.get(0)));

        // Act
        Book book = bookService.getBookById(1L);

        // Assert
        assertEquals("Book One", book.getTitle());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetBookByIdNotFound() {
        // Arrange
        when(bookRepository.findById(3L)).thenReturn(Optional.empty());

        // Act
        Book book = bookService.getBookById(3L);

        // Assert
        verify(bookRepository, times(1)).findById(3L);
    }
}
