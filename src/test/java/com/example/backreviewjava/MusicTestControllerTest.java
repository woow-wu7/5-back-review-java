package com.example.backreviewjava;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@Slf4j
@SpringBootTest
@AutoConfigureMockMvc // 自动构建 MockMvc 这个对象，通过  @Resource 来使用
@ExtendWith(SpringExtension.class) // 表示给当前测试方法添加 springboot 运行时的环境，这样就可以拿到 controller servers mapper
public class MusicTestControllerTest {

    // Mock Object
    @Resource
    private MockMvc mockMvc;

    // The following code we don't need, because we used '@AutoConfigureMockMvc' and '@Resource' to replace it.
    //    @BeforeAll
    //    static void setUp() {
    //        mockMvc = MockMvcBuilders.standaloneSetup(new MusicTestController()).build();
    //    }


    @Test
    public void testGetMusic() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders
                                .request(HttpMethod.GET, "/music-api/music")
                                .contentType("application/json")
                                .param("name", "晴天")
                                .param("singer", "周杰伦")
                                .param("album", "无与伦比"))
                // the expected value.
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.name").value("晴天")).andDo(print()).andReturn();

        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }

}
