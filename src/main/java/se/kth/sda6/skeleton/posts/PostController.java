package se.kth.sda6.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/*
    @TODO AutoWire PostService and create the methods needed to implement the API.
    Don't forget to add necessary annotations.
 */
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    public PostService postService;

    // get the list of posts
    @GetMapping("")
    public List<Post> getAll(@RequestParam(required = false) String sort) {
        return postService.getAll(sort);
    }

    // get a post by id
    @GetMapping("/{id}")
    public Post getByID(@PathVariable Long id) {
        return postService.getByID(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // create post
    @PostMapping("")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    // update a post
    @PutMapping("")
    public Post update(@RequestBody Post post) {
        return postService.update(post).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        postService.deleteById(id);
    }
}
