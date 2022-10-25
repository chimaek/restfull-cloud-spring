package net.chimaek.restful_msa.user.service;

import java.util.List;
import java.util.stream.Collectors;
import net.chimaek.restful_msa.user.controller.UserNotFoundException;
import net.chimaek.restful_msa.user.domain.User;
import net.chimaek.restful_msa.user.dto.UserDto;
import net.chimaek.restful_msa.user.dto.UserDto.DeleteUserDto;
import net.chimaek.restful_msa.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public UserDto.ResponseDto getUser(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("error not found user"));

    return getDto(user);
  }

  private static UserDto.ResponseDto getDto(User user) {
    return UserDto.ResponseDto.builder().ssn(user.getSsn()).password(
            user.getPassword()).name(user.getName()).id(user.getId()).localDateTime(user.getJoinDate())
        .build();
  }

  @Override
  @Transactional(readOnly = true)
  public List<UserDto.ResponseDto> getUsers() {
    List<User> userList = userRepository.findAll();
    return userList.stream().map((UserServiceImpl::getDto)).collect(Collectors.toList());
  }

  @Override
  @Transactional(readOnly = false)
  public UserDto.ResponseDto createUser(UserDto.CreateUserDto userDto) {

    User user = userRepository.save(userDto.toEntity());
    return getDto(user);
  }

  @Override
  @Transactional(readOnly = false)
  public Void deleteUser(DeleteUserDto deleteUserDto) {
    User user = userRepository.findUserByNameAndPassword(deleteUserDto.getName(),
            deleteUserDto.getPassword())
        .orElseThrow(() -> new UserNotFoundException("not found user"));
    userRepository.delete(user);
    return null;
  }
}
