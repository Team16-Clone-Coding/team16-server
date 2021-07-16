package team16.instagramclone.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Comment {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long commentId;
}
