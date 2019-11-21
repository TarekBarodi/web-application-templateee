package se.kth.sda6.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class PostService {

    //Autowire the PostRepository and use it to implement all the service methods
    @Autowired
    private PostRepository repository;

    public List<Post> getAll(String sort) {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(sort.equals("body") ? Post::getBody : Post::getDate))
                .collect(Collectors.toList());
    }

    public Optional<Post> getByID(Long id){
        return repository.findById(id);
    }

    public Post create(Post newPost) {
        return repository.save(newPost);
    }

    public Post update(Post post) {
        return repository.save(post);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
