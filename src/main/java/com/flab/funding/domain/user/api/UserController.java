package com.flab.funding.domain.user.api;

import com.flab.funding.domain.user.dto.UserDto;
import com.flab.funding.domain.user.exception.DuplicatedIdExistException;
import com.flab.funding.domain.user.exception.UserDoesNotExistException;
import com.flab.funding.domain.user.service.UserService;
import com.flab.funding.utils.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Dictionary;

@Controller
@ResponseBody
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> signUp(UserDto userDto) {
        try {
            userService.join(userDto);
        } catch (DuplicatedIdExistException e) {
            return CustomResponse.generateExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(userDto, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<Object> checkId(@RequestParam String id) {
        try {
            UserDto userDto = userService.findUserById(id);
            return new ResponseEntity<Object>(userDto, HttpStatus.OK);
        } catch (UserDoesNotExistException e) {
            return CustomResponse.generateExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
