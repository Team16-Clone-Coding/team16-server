package team16.instagramclone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team16.instagramclone.domain.Likes;
import team16.instagramclone.domain.Post;
import team16.instagramclone.domain.User;
import team16.instagramclone.repository.LikeRepository;
import team16.instagramclone.repository.PostRepository;
import team16.instagramclone.repository.UserRepository;
import team16.instagramclone.security.UserDetailsImpl;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    //좋아요 생성
    public Likes
    createLike() {
        Likes likes = new Likes();
        likeRepository.save(likes);
        return likes;
    }

    public void saveLikes(Likes likes) {
        likeRepository.save(likes);
    }

    //좋아요 증감
    @Transactional
    public void doLike(Long postId) {
//        User user = userDetails.getUser();
        User user = userRepository.findById(1L).get();
        Likes likes = postRepository.findById(postId).get().getLikes();
        if (likes.getUserList().contains(user)) {
            likes.updateHowManyLike(-1);
            likes.getUserList().remove(user);
        } else {
            likes.updateHowManyLike(+1);
            likes.getUserList().add(user);
            System.out.println("likes.getUserList() = " + likes.getUserList().size());
        }
    }
}
