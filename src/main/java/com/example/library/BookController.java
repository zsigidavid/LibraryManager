package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private LibraryService libraryService;

    // A főoldal lekérése, amely a könyvek listáját jeleníti meg
    @GetMapping("/")
    public String index(Model model) {
        // Lekérdezzük az összes könyvet, és átadjuk a frontend sablonnak
        model.addAttribute("books", libraryService.getAllBooks());
        return "index"; // Visszatérünk az index.html sablonnal
    }

    // Új könyv hozzáadása a formból érkező adatokkal
    @PostMapping("/addBook")
    public String addBook(@RequestParam String title, @RequestParam String author) {
        // Új Book objektum létrehozása és feltöltése
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);

        // Könyv mentése a könyvtárba
        libraryService.addBook(newBook);

        // Visszairányítás az oldal frissítéséhez, hogy megjelenjen az új könyv
        return "redirect:/";
    }
}
