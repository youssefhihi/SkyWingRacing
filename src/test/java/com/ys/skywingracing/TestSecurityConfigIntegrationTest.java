package com.ys.skywingracing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class TestSecurityConfigIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAuthenticationWithCorrectPassword() throws Exception {
        // Any password works since authentication is bypassed for testing
        mockMvc.perform(get("/api/private/user/pigeons")
                        .with(httpBasic("fla7ds", "12345")))  // Any password works
                .andExpect(status().isOk());
    }

    @Test
    void testAuthenticationWithAnyPassword() throws Exception {
        mockMvc.perform(get("/api/private/user/pigeons")
                        .with(httpBasic("fla7", "anyPassword")))  // Any password works
                .andExpect(status().isOk());
    }
}
