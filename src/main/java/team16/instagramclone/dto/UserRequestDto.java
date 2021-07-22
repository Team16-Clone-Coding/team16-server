package team16.instagramclone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    String userEmail;
    String userName;
    String userPassword;
    String userImage;
}
