package team16.instagramclone.dto;

import lombok.Getter;
import lombok.Setter;
import team16.instagramclone.domain.Post;
import team16.instagramclone.domain.User;

import java.util.List;

@Getter
@Setter
public class MyPageResponseDto {
    User user;
    List<Post> postList;
}
