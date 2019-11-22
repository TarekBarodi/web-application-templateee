package se.kth.sda6.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import se.kth.sda6.skeleton.comments.*;

/*
    @TODO Autowire the PostRepository and use it to implement all the service methods.
 */
@Service
public class PostService {
    // public static List<Post> posts = new ArrayList<>();
    @Autowired
    private PostRepository postRepository;

    // get all posts and return them as List<Post>
    public List<Post> getAll(String sort) {
        if (sort.equals("body")) {
            // return
            // posts.stream().sorted(Comparator.comparing(Post::getBody)).collect(Collectors.toList());
            return postRepository.findAll().stream().sorted(Comparator.comparing(Post::getBody))
                    .collect(Collectors.toList());
        } else {
            // return posts;
            return postRepository.findAll();
        }
    }

    // get a post by ID if it exists
    public Optional<Post> getByID(Long id) {
        // return posts.stream().filter(t -> t.getId().equals(id)).findFirst();
        return postRepository.findById(id);
    }

    // save the post to DB and return the saved post
    public Post createPost(Post post) {
        // posts.add(post);
        postRepository.save(post);
        return post;
    }

    // update a post
    public Optional<Post> update(Post post) {
        // @TODO update the post if it exists in DB and return the updated post.
        postRepository.save(post);
        return postRepository.findById(post.getId());
    }

    // delete the post by id
    public void deleteById(Long id) {
        // posts = posts.stream().filter(t ->
        // !t.getId().equals(id)).collect(Collectors.toList());
        postRepository.deleteById(id);
    }

}
