package lk.nsbm.dea2.libman.controller;

import lk.nsbm.dea2.libman.model.Book;
import lk.nsbm.dea2.libman.service.BookManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {

    private BookManagementService bookManagementService;

    @Autowired
    public BookController(BookManagementService bookManagementService) {
        this.bookManagementService = bookManagementService;
    }

    @PostMapping("/book")
    public ResponseEntity addBook(@RequestBody Book book) {
        if (!book.isValid()) {
            return ResponseEntity.badRequest().build();
        }
        book = this.bookManagementService.add(book);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/book")
    public ResponseEntity update(@RequestBody Book book) {
        if (!book.isValid() && book.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        book = this.bookManagementService.update(book);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/book/{isbn}")
    public ResponseEntity findByIsbn(@PathVariable String isbn) {
        Optional<Book> book = this.bookManagementService.findByIsbn(isbn);
        if (!book.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(book);
    }

}
