package team16.instagramclone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team16.instagramclone.domain.Post;
import team16.instagramclone.domain.User;
import team16.instagramclone.dto.LoginResponseDto;
import team16.instagramclone.dto.MyPageResponseDto;
import team16.instagramclone.dto.UserRequestDto;
import team16.instagramclone.repository.PostRepository;
import team16.instagramclone.security.UserDetailsImpl;
import team16.instagramclone.service.PostService;
import team16.instagramclone.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PostService postService;

    @PostMapping("/user/signup")
    public void signup(@RequestBody UserRequestDto userRequestDto) {
        userService.signup(userRequestDto);
    }

    //로그인
    @PostMapping("/user/login")
    public LoginResponseDto login(@RequestBody UserRequestDto userRequestDto) {
        String token = userService.createToken(userRequestDto);
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setJwtToken(token);
        User user = userService.findUser(userRequestDto);
        loginResponseDto.setUser(user);
        return loginResponseDto;
    }



    @GetMapping("/user/myinfo")
    public MyPageResponseDto myInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails == null) {
            System.out.println("오잉");
        }
        User user = userDetails.getUser();
        List<Post> postList = postService.getMyPost(user);
        MyPageResponseDto myPageResponseDto = new MyPageResponseDto();
        myPageResponseDto.setUser(user);
        myPageResponseDto.setPostList(postList);
        return myPageResponseDto;
    }

    @PostMapping("/user/image")
    public void setUserImage(@RequestBody UserRequestDto userRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        userService.setUserImage(userRequestDto, userDetails);
    }
}
