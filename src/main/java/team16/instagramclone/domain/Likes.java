package team16.instagramclone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Likes {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long likeId;

    @Column(nullable = true)
    private int howManyLike;

    @OneToOne
    private Post post;

    @ManyToMany
    private List<User> userList;

    public void updateHowManyLike(int plusOrMinus) {
        howManyLike += plusOrMinus;
    }

    public void updateUser(User user) {
        userList = new ArrayList<User>();
        userList.add(user);
    }

    public Likes(Post post) {
        this.post = post;
    }
}
