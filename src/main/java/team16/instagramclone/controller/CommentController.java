package team16.instagramclone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team16.instagramclone.dto.CommentRequestDto;
import team16.instagramclone.repository.CommentRepository;
import team16.instagramclone.security.UserDetailsImpl;
import team16.instagramclone.service.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //λκΈ μμ±
    @PostMapping("posts/{id}/comment")
    public void createComment(@PathVariable(name = "id") Long postId, @RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        commentService.saveComment(commentRequestDto, postId, userDetails);
    }
}
