package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")  // Az URL útvonal, amelyet a vezérlő kezel
public class BookController {

    // A LibraryService injektálása, hogy a könyvek kezelését végezhesse
    @Autowired
    private LibraryService libraryService;

    // POST kérés: Új könyv hozzáadása a könyvtárhoz
    @PostMapping
    public String addBook(@RequestBody Book book) {
        libraryService.addBook(book);  // A könyv hozzáadása a szolgáltatásban
        return "redirect:/library";  // Visszairányít a könyvtár listát tartalmazó oldalra
    }

    // GET kérés: A könyvtár megjelenítése
    @GetMapping
    public String showLibrary(Model model) {
        // Az összes könyv lekérése és hozzáadása a Model-hez
        model.addAttribute("books", libraryService.getAllBooks());
        // Visszatérés a "library" nézethez, amely a könyveket megjeleníti
        return "library";
    }
}
