package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import java.security.Principal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

    @GetMapping("/new")
    public String newBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book_form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "book_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/issue/{id}")
    public String warnWrongMethod() {
        throw new IllegalStateException("❌ Book issue called via GET instead of POST");
    }

    @GetMapping("/confirmation")
    public String showConfirmationPage() {
        return "confirmation";
    }


    @PostMapping("/issue/{id}")
    @PreAuthorize("hasRole('USER')")
    public String issueBook(@PathVariable Long id, Principal principal) {
        System.out.println("📘 Issuing book ID: " + id + " to user: " + principal.getName());

        Book book = bookService.findById(id);
        if (book != null && book.getIssuedTo() == null) {
            bookService.issueBookToUser(book, principal.getName());
        }
        return "redirect:/books/confirmation";
    }
}

