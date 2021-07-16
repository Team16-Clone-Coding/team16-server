package team16.instagramclone.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Comment {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long commentId;

    @Column(nullable = false)
    private String commentContent;

    @Column(nullable = false)
    private String commentAuthor;
}
