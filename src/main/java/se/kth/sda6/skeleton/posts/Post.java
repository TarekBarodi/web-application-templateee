package se.kth.sda6.skeleton.posts;

import javax.persistence.*;

// @TODO add Hibernate annotations to define which table and columns should be used to save the Post Object.
@Entity
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "body")
    private String body;

    public Post(Long id, String body) {
        this.id = id;
        this.body = body;
    }

    public Post(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public String getDate() {
        return date;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
