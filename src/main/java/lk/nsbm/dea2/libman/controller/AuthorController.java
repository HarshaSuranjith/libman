package lk.nsbm.dea2.libman.controller;

import lk.nsbm.dea2.libman.model.Author;
import lk.nsbm.dea2.libman.service.AuthorManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}
