package team16.instagramclone.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Like {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long likeId;

    @Column(nullable = false)
    private int howManyLike;

    @OneToOne
    private Post post;

    @OneToMany
    private List<User> userList;

    public void updateHowManyLike(int plusOrMinus) {
        howManyLike += plusOrMinus;
    }
}
