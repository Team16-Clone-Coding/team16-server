package team16.instagramclone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Likes {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long likeId;

    @Column(nullable = true)
    private int howManyLike;

    @OneToMany
    private List<User> userList = new ArrayList<User>();

    public void updateHowManyLike(int plusOrMinus) {
        howManyLike += plusOrMinus;
    }
}
