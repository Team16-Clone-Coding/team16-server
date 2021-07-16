package team16.instagramclone.domain;

import lombok.Getter;
import team16.instagramclone.utils.TimeStamped;

import javax.persistence.*;

@Entity
@Getter
public class Comment extends TimeStamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long commentId;

    @Column(nullable = false)
    private String commentContent;

    @Column(nullable = false)
    private String commentAuthor;
}
