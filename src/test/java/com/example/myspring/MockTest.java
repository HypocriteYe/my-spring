package com.example.myspring;

import com.alibaba.fastjson2.JSONObject;
import com.example.myspring.controller.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @description
 * @Author ygl
 * @Create 2024/5/24 15:52
 */
@AutoConfigureMockMvc
public class MockTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        this.mockMvc.perform(post("/testInt")
//                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                        .content("{\"i\":1}")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("result:1"));

    }
}
