package team16.instagramclone.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPassword;
}
