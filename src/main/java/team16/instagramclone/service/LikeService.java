package team16.instagramclone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team16.instagramclone.domain.Likes;
import team16.instagramclone.domain.Post;
import team16.instagramclone.domain.User;
import team16.instagramclone.repository.LikeRepository;
import team16.instagramclone.security.UserDetailsImpl;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    //좋아요 생성
    public void createLike(Post post, User user) {
        Likes likes = new Likes(post, user);
    }

    //좋아요 증감
    @Transactional
    public void doLike(Long postId, UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        if (likeRepository.findAllByPost_PostIdAndUserListContaining(postId, user).isPresent()) {
            Likes likes = likeRepository.findByPost_PostId(postId).get();
            likes.updateHowManyLike(-1);
        } else {
            Likes likes = likeRepository.findByPost_PostId(postId).get();
            likes.updateHowManyLike(+1);
        }
    }
}
