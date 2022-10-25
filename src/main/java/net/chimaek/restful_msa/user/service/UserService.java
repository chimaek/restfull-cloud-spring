package net.chimaek.restful_msa.user.service;

import java.util.List;
import net.chimaek.restful_msa.user.dto.UserDto;

public interface UserService {

  UserDto.ResponseDto getUser(Long id);
  List<UserDto.ResponseDto> getUsers();

  UserDto.ResponseDto createUser(UserDto.CreateUserDto userDto);

  Void deleteUser(UserDto.DeleteUserDto deleteUserDto);

}
