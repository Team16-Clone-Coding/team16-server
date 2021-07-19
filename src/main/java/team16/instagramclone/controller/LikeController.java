package team16.instagramclone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team16.instagramclone.security.UserDetailsImpl;
import team16.instagramclone.service.LikeService;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    //좋아요 기능
    @PostMapping("/posts/{id}/like")
    public void doLike(@PathVariable(name = "id") Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails){
//        likeService.doLike(postId, userDetails);
        likeService.doLike(postId);
    }
}
