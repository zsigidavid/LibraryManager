package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    // Minden könyv lekérése az adatbázisból
    public List<Book> getAllBooks() {
        return libraryRepository.findAll();
    }

    // Könyv hozzáadása az adatbázishoz
    public void addBook(Book book) {
        libraryRepository.save(book);
    }

    // Könyv lekérése az ID alapján
    public Optional<Book> getBookById(String id) {
        return libraryRepository.findById(id);
    }

    // Könyv törlése az ID alapján
    public void deleteBookById(String id) {
        libraryRepository.deleteById(id);
    }
}
