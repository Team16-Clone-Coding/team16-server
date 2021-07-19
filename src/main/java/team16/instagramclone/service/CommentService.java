package team16.instagramclone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team16.instagramclone.domain.Comment;
import team16.instagramclone.domain.User;
import team16.instagramclone.repository.CommentRepository;
import team16.instagramclone.repository.UserRepository;
import team16.instagramclone.security.UserDetailsImpl;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    //댓글 저장
    public void saveComment(String commentContent, Long postId) {
//        String userName = userDetails.getUser().getUserName();
        String userName = userRepository.findById(1L).get().getUserName();
        Comment comment = new Comment(commentContent, postId, userName);
        commentRepository.save(comment);
    }
}
