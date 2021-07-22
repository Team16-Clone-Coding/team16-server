package team16.instagramclone.dto;

import lombok.Getter;
import lombok.Setter;
import team16.instagramclone.domain.User;

@Getter
@Setter
public class LoginResponseDto {
    String jwtToken;
    User user;
}
