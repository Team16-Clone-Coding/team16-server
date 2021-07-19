package team16.instagramclone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import team16.instagramclone.domain.Post;
import team16.instagramclone.dto.PostRequestDto;
import team16.instagramclone.repository.PostRepository;
import team16.instagramclone.security.UserDetailsImpl;
import team16.instagramclone.service.LikeService;
import team16.instagramclone.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 목록 조회
    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.getPostList();
    }

    // 게시글 작성
    @PostMapping("/posts")
    public void createPost(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
//        postService.createPost(postRequestDto, userDetails);
        postService.createPost(postRequestDto);
    }
}
