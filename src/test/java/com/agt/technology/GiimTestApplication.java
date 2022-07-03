package com.agt.technology;

import com.agt.technology.module.auth.controller.AuthController;
import com.agt.technology.module.auth.pojo.dto.LoginDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class GiimTestApplication {

    @Resource
    private AuthController authController;

    @Test
    public void test() {
        LoginDTO admin = new LoginDTO("admin", "123456");
        String login = authController.login(admin);
        System.out.println(login);
    }

}
