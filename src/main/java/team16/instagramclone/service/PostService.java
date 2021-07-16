package team16.instagramclone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team16.instagramclone.domain.Post;
import team16.instagramclone.domain.User;
import team16.instagramclone.dto.PostRequestDto;
import team16.instagramclone.repository.CommentRepository;
import team16.instagramclone.repository.PostRepository;
import team16.instagramclone.security.UserDetailsImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    //게시글 조회
    public List<Post> getPostList(){
       return postRepository.findAll();
    }

    //게시글 작성
    public void createPost(PostRequestDto postRequestDto, UserDetailsImpl userDetails){
        User user = userDetails.getUser();
        Post post = new Post(postRequestDto, user);
    }

}
