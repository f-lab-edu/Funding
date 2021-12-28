package com.flab.funding.domain.user.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.funding.domain.user.entity.LoginRequest;
import com.flab.funding.domain.user.entity.LoginedUser;
import com.flab.funding.domain.user.entity.UserRole;
import com.flab.funding.domain.user.infrastructure.SessionAuthentication;
import com.flab.funding.domain.user.service.UserLoginService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

        when(loginService.getLoginInfo()).thenReturn(Optional.of(new LoginedUser("testId", "홍길동", UserRole.ORDERER)));

        mockMvc.perform(post("/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonLoginReq))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("로그인 요청 실패")
    @Test
    void loginFailTest() {
//        String jsonLoginReq = objectMapper.writeValueAsString(new LoginRequest("testId", "12345678"));
//
//        mockMvc.perform(post("/user/login")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonLoginReq))
//                .andExpect(status().isOk())
//                .andDo(print());
    }
}
