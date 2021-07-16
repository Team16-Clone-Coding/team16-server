package team16.instagramclone.domain;

import lombok.Getter;
import org.yaml.snakeyaml.tokens.CommentToken;
import team16.instagramclone.utils.TimeStamped;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Post extends TimeStamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long postId;

    @Column(nullable = false)
    private String postContent;

    @Column(nullable = false)
    private String postImage;

    @Column(nullable = false)
    private int postLikes;

    @OneToMany
    private List<Comment> commentList;

}
