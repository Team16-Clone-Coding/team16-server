package team16.instagramclone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team16.instagramclone.domain.Likes;
import team16.instagramclone.domain.Post;
import team16.instagramclone.domain.User;
import team16.instagramclone.repository.LikeRepository;
import team16.instagramclone.repository.UserRepository;
import team16.instagramclone.security.UserDetailsImpl;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    public final UserRepository userRepository;

    //좋아요 생성
    public void createLike(Post post) {
        Likes likes = new Likes(post);
        likeRepository.save(likes);
    }

    //좋아요 증감
    @Transactional
    public void doLike(Long postId) {
//        User user = userDetails.getUser();
        User user = userRepository.findById(1L).get();
        if (likeRepository.findByPost_PostIdAndUserList(postId, user).isPresent()) {
            Likes likes = likeRepository.findByPost_PostId(postId).get();
            likes.updateHowManyLike(-1);
            likes.getUserList().remove(user);
        } else {
            Likes likes = likeRepository.findByPost_PostId(postId).get();
            likes.updateHowManyLike(+1);
            likes.updateUser(user);
        }
    }
}
