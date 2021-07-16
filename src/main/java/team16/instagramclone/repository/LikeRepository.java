package team16.instagramclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team16.instagramclone.domain.Like;
import team16.instagramclone.domain.Post;
import team16.instagramclone.domain.User;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findAllByPost_PostIdAndUserListContaining(Long postId, User user);
    Optional<Like> findByPost_PostId(Long postId);
}
