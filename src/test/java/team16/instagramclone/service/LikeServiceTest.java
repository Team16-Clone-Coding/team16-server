package team16.instagramclone.service;

import org.aspectj.lang.annotation.RequiredTypes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestBody;
//import team16.instagramclone.domain.Post;
//import team16.instagramclone.domain.User;
//import team16.instagramclone.dto.PostRequestDto;
//import team16.instagramclone.repository.PostRepository;
//import team16.instagramclone.security.UserDetailsImpl;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//
//class LikeServiceTest {
//
//    PostService postService;
//    LikeService likeService;
//
//    public LikeServiceTest(PostService postService, LikeService likeService) {
//        this.postService = postService;
//        this.likeService = likeService;
//    }
//
//    @Test
//    @DisplayName("좋아요 개수 증가 / user id 일치")
//    public void 좋아요기능() {
//        //given
////        User user = new User(1L, "wonhee", "123456");
////        PostRequestDto postRequestDto = new PostRequestDto();
////        postRequestDto.setPostImage("이미지");
////        postRequestDto.setPostContent("내용");
////        postService.createPost(postRequestDto);
////
////        //when
////        List<Post> postList = postService.getPostList();
////        likeService.doLike(postList.get(0).getPostId());
//
//        //then
//    }
//
//}