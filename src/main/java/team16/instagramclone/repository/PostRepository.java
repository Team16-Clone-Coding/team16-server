package team16.instagramclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team16.instagramclone.domain.Post;
import team16.instagramclone.domain.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
