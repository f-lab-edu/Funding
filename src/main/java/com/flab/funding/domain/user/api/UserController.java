package com.flab.funding.domain.user.api;

import com.flab.funding.domain.user.dto.UserDto;
import com.flab.funding.domain.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> signUp(UserDto userDto) {
        userService.join(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }


    @GetMapping("/")
    public ResponseEntity<UserDto> checkId(@RequestParam String id) {
        UserDto userDto = userService.findUserById(id);
        return ResponseEntity.ok().body(userDto);
    }


}
