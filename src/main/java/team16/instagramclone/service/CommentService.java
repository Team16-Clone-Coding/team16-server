package team16.instagramclone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team16.instagramclone.domain.Comment;
import team16.instagramclone.domain.Post;
import team16.instagramclone.domain.User;
import team16.instagramclone.dto.CommentRequestDto;
import team16.instagramclone.repository.CommentRepository;
import team16.instagramclone.repository.PostRepository;
import team16.instagramclone.repository.UserRepository;
import team16.instagramclone.security.UserDetailsImpl;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    //댓글 저장
    @Transactional
    public void saveComment(CommentRequestDto commentRequestDto, Long postId, UserDetailsImpl userDetails) {
        String userName = userDetails.getUser().getUserName();
        Comment comment = new Comment(commentRequestDto.getCommentContent(), postId, userName);
        Post post = postRepository.findById(postId).get();
        post.addComment(comment);
        commentRepository.save(comment);
    }
}
