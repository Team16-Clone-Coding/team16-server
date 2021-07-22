package team16.instagramclone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.mapping.ToOne;
import org.yaml.snakeyaml.tokens.CommentToken;
import team16.instagramclone.dto.PostRequestDto;
import team16.instagramclone.utils.TimeStamped;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Post extends TimeStamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long postId;

    @Column(nullable = false)
    private String postContent;

    @Column(nullable = false)
    private String postImage;

    @OneToOne
    @JoinColumn(name = "LIKE_ID")
    private Likes likes;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Comment> commentList = new ArrayList<Comment>();

    public Post(PostRequestDto postRequestDto, User user, Likes likes) {
        this.postContent = postRequestDto.getPostContent();
        this.postImage = postRequestDto.getPostImage();
        this.user = user;
        this.likes = likes;

    }

    public void addComment(Comment comment) {
        commentList.add(comment);
    }
}

