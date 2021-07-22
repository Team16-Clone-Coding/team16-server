package team16.instagramclone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team16.instagramclone.domain.User;
import team16.instagramclone.dto.UserRequestDto;
import team16.instagramclone.exeption.ApiRequestException;
import team16.instagramclone.repository.UserRepository;
import team16.instagramclone.security.JwtTokenProvider;
import team16.instagramclone.security.UserDetailsImpl;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    public void signup(UserRequestDto userRequestDto) {
        String userName = userRequestDto.getUserName();
        String userEmail = userRequestDto.getUserEmail();

        Optional<User> found = userRepository.findByUserName(userName);
        if (found.isPresent()) {
            throw new ApiRequestException("중복된 사용자 ID 가 존재합니다.");
        }

        String password = userRequestDto.getUserPassword();

        if (!password.isEmpty()) {
            if (password.length() >= 6 && password.length() <= 20) {
            } else {
                throw new ApiRequestException("비밀번호는  6~20자리를 사용해야 합니다.");
            }
        } else {
            throw new ApiRequestException("패스워드를 입력해 주세요.");
        }
        // 패스워드 인코딩
        password = passwordEncoder.encode(password);

        String defaultUserImage = "https://hyunjung.s3.ap-northeast-2.amazonaws.com/dog.png";
        User user = new User(userName,password,defaultUserImage,userEmail);
        userRepository.save(user);
    }

    public String createToken(UserRequestDto userRequestDto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userRequestDto.getUserEmail(),userRequestDto.getUserPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return jwtTokenProvider.createToken(authentication);
    }

    public User findUser(UserRequestDto userRequestDto) {
        String userEmail = userRequestDto.getUserEmail();
        User user = userRepository.findByUserEmail(userEmail).get();
        return user;
    }

    @Transactional
    public void setUserImage(UserRequestDto userRequestDto, UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getUserId();
        User user = userRepository.findById(userId).get();
        user.updateUserImage(userRequestDto.getUserImage());

    }
}
