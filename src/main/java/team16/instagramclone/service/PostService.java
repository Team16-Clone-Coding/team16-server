package team16.instagramclone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team16.instagramclone.domain.Likes;
import team16.instagramclone.domain.Post;
import team16.instagramclone.domain.User;
import team16.instagramclone.dto.PostRequestDto;
import team16.instagramclone.repository.CommentRepository;
import team16.instagramclone.repository.PostRepository;
import team16.instagramclone.repository.UserRepository;
import team16.instagramclone.security.UserDetailsImpl;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final LikeService likeService;
    private final UserRepository userRepository;

    //게시글 조회
    public List<Post> getPostList(){
       return postRepository.findAll();
    }

    //게시글 작성
    @Transactional
    public void createPost(PostRequestDto postRequestDto){
//        User user = userDetails.getUser();
        User user = userRepository.findById(1L).get();
        Likes like = likeService.createLike();
        Post post = new Post(postRequestDto, user, like);
        postRepository.save(post);

    }

}
