package team16.instagramclone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.tokens.CommentToken;
import team16.instagramclone.dto.PostRequestDto;
import team16.instagramclone.utils.TimeStamped;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
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

    @ManyToOne
    private User user;

    @OneToMany
    private List<Comment> commentList;

    public Post(PostRequestDto postRequestDto, User user) {
        this.postContent = postRequestDto.getPostContent();
        this.postImage = postRequestDto.getPostImage();
        this.user = user;
    }
}
