package team16.instagramclone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
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

    public Like(Post post, User user) {
        this.post = post;
        this.userList.add(user);
    }
}
