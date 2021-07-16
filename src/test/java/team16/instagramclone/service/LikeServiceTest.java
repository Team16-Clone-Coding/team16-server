package team16.instagramclone.service;

import org.junit.jupiter.api.Test;
import team16.instagramclone.domain.Like;
import team16.instagramclone.domain.User;
import team16.instagramclone.repository.LikeRepository;
import team16.instagramclone.security.UserDetailsImpl;

import static org.junit.jupiter.api.Assertions.*;

class LikeServiceTest {


//    @Test
//    public void doLike(Long postId, UserDetailsImpl userDetails) {
//        User user = userDetails.getUser();
//        if (likeRepository.findAllByPost_PostIdAndUserListContaining(postId, user).isPresent()) {
//            Like like = likeRepository.findByPost_PostId(postId).get();
//            like.updateHowManyLike(-1);
//        } else {
//            Like like = likeRepository.findByPost_PostId(postId).get();
//            like.updateHowManyLike(+1);
//        }
//    }

}