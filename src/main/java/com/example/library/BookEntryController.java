package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BookEntryController {

    @Autowired
    private BookEntryRepository bookRepository;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("entries", books);
        return "index"; // Thymeleaf will resolve this to the `index.html` in the templates folder
    }

    @PostMapping("/add")
    public String addBook(
        @RequestParam("usn") String usn,
        @RequestParam("name") String name,
        @RequestParam("bookTitle") String bookTitle,
        @RequestParam("bookAuthor") String bookAuthor,
        @RequestParam("bookNumber") String bookNumber,
        @RequestParam("collectDate") String collectDate,
        @RequestParam("returnDate") String returnDate) {
        
        // Convert date from String to LocalDate
        Book book = new Book();
        book.setUsn(usn);
        book.setName(name);
        book.setBookTitle(bookTitle);
        book.setBookAuthor(bookAuthor);
        book.setBookNumber(bookNumber);
        book.setCollectDate(LocalDate.parse(collectDate));
        book.setReturnDate(LocalDate.parse(returnDate));

        bookRepository.save(book); // Save to database

        return "redirect:/"; // Redirect back to home page after saving
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/"; // Redirect after deletion
    }
}
