package net.chimaek.restful_msa.chat.controller;


import net.chimaek.restful_msa.chat.dto.UserDto;
import net.chimaek.restful_msa.chat.service.UserService;
import net.chimaek.restful_msa.chat.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public ResponseEntity<UserDto> findUser(UserDto userDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.findUser(userDto));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
