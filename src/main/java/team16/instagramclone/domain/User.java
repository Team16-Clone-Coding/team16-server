package team16.instagramclone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userImage;

    @Column(nullable = false)
    private String userEmail;

    public User(String userName, String userPassword, String userImage, String userEmail) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userImage = userImage;
        this.userEmail = userEmail;
    }

    public void updateUserImage(String userImage) {
        this.userImage = userImage;
    }
}
