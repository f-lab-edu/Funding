package com.flab.funding.domain.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.funding.domain.user.exception.NoUserExistException;
import com.flab.funding.domain.user.exception.WrongPasswordException;
import com.flab.funding.domain.user.model.LoginRequest;
import com.flab.funding.domain.user.model.LoginedUser;
import com.flab.funding.domain.user.model.UserRole;
import com.flab.funding.domain.user.service.UserLoginService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    private UserLoginService loginService;

    @DisplayName("로그인 요청 성공")
    @Test
    void loginSuccessTest() throws Exception {

        String jsonLoginReq = objectMapper.writeValueAsString(new LoginRequest("testId", "12345678"));
        String expectedJson = "{\"success\":true,\"response\":{\"userId\":\"testId\",\"userName\":\"홍길동\",\"userRole\":\"ORDERER\"},\"error\":null}";

        when(loginService.getLoginInfo()).thenReturn(Optional.of(new LoginedUser("testId", "홍길동", UserRole.ORDERER)));

        mockMvc.perform(post("/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonLoginReq))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andDo(print());
    }

    @DisplayName("로그인 요청 실패 - 아이디 없음")
    @Test
    void loginFailTest() throws Exception {

        String jsonLoginReq = objectMapper.writeValueAsString(new LoginRequest("testId!!", "12345678"));
        String expectedJson = "{\"success\":false,\"response\":null,\"error\":{\"status\":400,\"errMessage\":\"해당 아이디가 존재하지 않습니다.\"}}";

        doThrow(new NoUserExistException()).when(loginService).login("testId!!", "12345678");

        mockMvc.perform(post("/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonLoginReq))
                .andExpect(status().is(400))
                .andExpect(content().json(expectedJson))
                .andDo(print());
    }

    @DisplayName("로그인 요청 실패 - 비밀번호 불일치")
    @Test
    void loginFail2Test() throws Exception {

        String jsonLoginReq = objectMapper.writeValueAsString(new LoginRequest("testId", "111"));
        String expectedJson = "{\"success\":false,\"response\":null,\"error\":{\"status\":400,\"errMessage\":\"패스워드가 올바르지 않습니다.\"}}";
        doThrow(new WrongPasswordException()).when(loginService).login("testId", "111");

        mockMvc.perform(post("/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonLoginReq))
                .andExpect(status().is(400))
                .andExpect(content().json(expectedJson))
                .andDo(print());
    }

    @DisplayName("로그아웃 요청 성공")
    @Test
    void logoutTest() throws Exception {

        mockMvc.perform(post("/user/logout"));
        verify(loginService).logout();

    }
}
