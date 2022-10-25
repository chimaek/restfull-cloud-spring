package net.chimaek.restful_msa.user.controller;


import java.net.URI;
import java.util.List;
import net.chimaek.restful_msa.user.dto.UserDto;
import net.chimaek.restful_msa.user.service.UserService;
import net.chimaek.restful_msa.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequestMapping("/api")
@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserServiceImpl userService) {
    this.userService = userService;
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<UserDto.ResponseDto> findUser(@PathVariable("id") Long id) {
    UserDto.ResponseDto user = userService.getUser(id);
    if (user == null || user.getName() == null) {
      throw new UserNotFoundException(String.format("ID[%s] NOT FOUND ", id));
    }
    return ResponseEntity.status(HttpStatus.OK).body(user);
  }

  @PostMapping("/user")
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto.CreateUserDto userDto) {
    UserDto.ResponseDto user = userService.createUser(userDto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(user.getId())
        .toUri();

    return ResponseEntity.created(uri).build();
  }

  @GetMapping("/users")
  public ResponseEntity<List<UserDto.ResponseDto>> findUsers() {
    return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
  }
}
