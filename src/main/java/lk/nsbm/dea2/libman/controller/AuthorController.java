package lk.nsbm.dea2.libman.controller;

import lk.nsbm.dea2.libman.model.Author;
import lk.nsbm.dea2.libman.service.AuthorManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthorController {

    private AuthorManagementService authorManagementService;

    @Autowired
    public AuthorController(AuthorManagementService authorManagementService) {
        this.authorManagementService = authorManagementService;
    }

    @PostMapping("/author")
    public ResponseEntity<?> addAuthor(@RequestBody Author author) {


        if (!author.isValid()) {
            return ResponseEntity.badRequest().build();
        }
        author = this.authorManagementService.add(author);
        return ResponseEntity.ok(author);

    }

    @PutMapping("/author")
    public ResponseEntity<?> update(@RequestBody Author author) {
        if (!author.isValid() || author.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        author = this.authorManagementService.update(author);
        return ResponseEntity.ok(author);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity getAuthorById(@PathVariable Long id) {
        Optional<Author> author = this.authorManagementService.findById(id);
        if (!author.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(author);
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        boolean deleted = this.authorManagementService.delete(id);
        if (deleted) {
            return ResponseEntity.ok().build(); // 200, 204
        }
        return ResponseEntity.notFound().build();
    }


}
