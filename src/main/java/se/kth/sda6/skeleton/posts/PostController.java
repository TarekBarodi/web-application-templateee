package se.kth.sda6.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

/*
    @TODO AutoWire PostService and create the methods needed to implement the API.
    Don't forget to add necessary annotations.
 */
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public List<Post> getAll(@RequestParam String sort) {
        return postService.getAll(sort);
    }

    @GetMapping("/{id}")
    public Post getPostByID(@PathVariable Long id){
        return postService.getByID(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public Post createPost(@RequestBody Post newPost) {
        return postService.create(newPost);
    }

    @PutMapping("")
    public Post update(@RequestBody Post post) {
        return postService.update(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deleteById(id);
    }

}
