package net.chimaek.restful_msa.chat.service;

import net.chimaek.restful_msa.chat.domain.User;
import net.chimaek.restful_msa.chat.dto.UserDto;
import net.chimaek.restful_msa.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder,
                           UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public Long Register(UserDto userDto) {
        if (userRepository.existsByNickname(userDto.nickname())) {
            throw new IllegalArgumentException("exists User");
        }
        User user =
                userDto.toCreateUser(passwordEncoder.encode(userDto.password()));
        return userRepository.save(user).getId();


    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findUser(UserDto userDto) {
        User user =
                userRepository.findByNicknameAndPassword(userDto.nickname(),
                        passwordEncoder.encode(userDto.password())).orElseThrow(() -> new IllegalArgumentException("not found user"));

        return UserDto.toUserDtoFromUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
