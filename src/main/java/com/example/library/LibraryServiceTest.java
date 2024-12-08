package com.example.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)  // JUnit5 támogatása
public class LibraryServiceTest {

    @Mock
    private LibraryRepository libraryRepository; // A repository mockolása

    @InjectMocks
    private LibraryService libraryService; // A mockolt repositoryt injektáljuk a service-be

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book("1", "Test Book", "Test Author", false);
    }

    @Test
    public void testAddBook() {
        libraryService.addBook(book);
        verify(libraryRepository, times(1)).save(book); // Ellenőrizzük, hogy a save metódus egyszer hívódott
    }

    @Test
    public void testGetBookById() {
        when(libraryRepository.findById("1")).thenReturn(Optional.of(book));

        Optional<Book> result = libraryService.getBookById("1");

        assertTrue(result.isPresent());
        assertEquals(book, result.get());
    }
}
