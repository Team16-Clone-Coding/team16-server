package team16.instagramclone.domain;

import lombok.Getter;
import org.yaml.snakeyaml.tokens.CommentToken;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Post {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long postId;

    @Column(nullable = false)
    private String postContent;

    @Column(nullable = false)
    private String postImage;

    @Column(nullable = false)
    private int postLikes;

    @OneToOne
    private User user;

    @OneToMany
    private List<Comment> commentList;

}
