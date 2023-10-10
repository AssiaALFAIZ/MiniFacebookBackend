package com.facebook.minifacebookback.controllers;

import com.facebook.minifacebookback.entities.Poste;
import com.facebook.minifacebookback.repositories.PosteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PosteController {
    private PosteRepository posteRepository;
    public PosteController(PosteRepository posteRepository){
        this.posteRepository=posteRepository;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> publishPost(@RequestBody Poste newPost) {
        newPost.setDate_poste(new Date()); // Set the current date
        System.out.println("text :"+newPost.getText());

        //posteRepository.save(newPost);
        return ResponseEntity.ok("Post published successfully");
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Poste>> getAllPosts() {
        List<Poste> posts = posteRepository.findAll();

        if (!posts.isEmpty()) {
            return ResponseEntity.ok(posts);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable Long postId, @RequestBody Poste updatedPost) {
        Optional<Poste> existingPost = posteRepository.findById(postId);

        if (existingPost.isPresent()) {
            Poste postToUpdate = existingPost.get();
            postToUpdate.setText(updatedPost.getText());
            postToUpdate.setImage(updatedPost.getImage());
            // Update other fields as needed
            posteRepository.save(postToUpdate);
            return ResponseEntity.ok("Post updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        }
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        if (posteRepository.existsById(postId)) {
            posteRepository.deleteById(postId);
            return ResponseEntity.ok("Post deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        }
    }

}
