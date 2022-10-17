package net.chimaek.restful_msa.chat.service;

import net.chimaek.restful_msa.chat.domain.User;
import net.chimaek.restful_msa.chat.dto.UserDto;

import java.util.List;

public interface UserService {

    Long Register(UserDto userDto);

    User findUser(UserDto userDto);

    List<User> findAllUser();
}
