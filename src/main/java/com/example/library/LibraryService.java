package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository; // Ellenőrizd, hogy ez az importálás megtörtént

    public void addBook(Book book) {
        libraryRepository.save(book);
    }

    public Optional<Book> getBookById(String id) {
        return libraryRepository.findById(id);
    }

    public void removeBook(String id) {
        libraryRepository.deleteById(id);
    }

    public List<Book> getAllBooks() {
        return libraryRepository.findAll();
    }
}
