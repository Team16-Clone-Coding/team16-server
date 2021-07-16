package team16.instagramclone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import team16.instagramclone.domain.Like;
import team16.instagramclone.domain.User;
import team16.instagramclone.repository.LikeRepository;
import team16.instagramclone.security.UserDetailsImpl;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    public void doLike(Long postId, UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        if (likeRepository.findAllByPost_PostIdAndUserListContaining(postId, user).isPresent()) {
            Like like = likeRepository.findByPost_PostId(postId).get();
            like.updateHowManyLike(-1);
        } else {
            Like like = likeRepository.findByPost_PostId(postId).get();
            like.updateHowManyLike(+1);
        }
    }
}
