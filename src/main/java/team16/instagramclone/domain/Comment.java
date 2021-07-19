package team16.instagramclone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import team16.instagramclone.security.UserDetailsImpl;
import team16.instagramclone.utils.TimeStamped;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends TimeStamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long commentId;

    @Column(nullable = false)
    private String commentContent;

    @Column(nullable = false)
    private String commentAuthor;

    @Column(nullable = false)
    private Long postId;

    public Comment(String commentContent, Long postId, String username) {
        this.commentContent = commentContent;
        this.postId = postId;
        this.commentAuthor = username;
    }
}
