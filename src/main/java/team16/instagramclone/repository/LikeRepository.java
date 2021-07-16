package team16.instagramclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team16.instagramclone.domain.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
}
