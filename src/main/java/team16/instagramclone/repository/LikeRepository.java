package team16.instagramclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team16.instagramclone.domain.Likes;
import team16.instagramclone.domain.User;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findAllByPost_PostIdAndUserListContaining(Long postId, User user);
    Optional<Likes> findByPost_PostId(Long postId);
}
