package com.guofei.wu;

import com.guofei.wu.controller.MyController;
import com.guofei.wu.service.TestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author 吴国飞 (guofei.wu)
 * @author 吴国飞 (guofei.wu)
 * @version 2018/9/29
 * @since 2018/9/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootApplicationTest {

    Logger logger = LoggerFactory.getLogger(SpringBootApplicationTest.class);

    @Autowired
    private TestService testService;

    @Test
    public void test() {
        testService.test();
        Long a = null;
        assert a != null : "a should not be null";

//        logger.info("单元测试");
    }

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;


    @Before
    public void setupMockMvc() {
        mvc = MockMvcBuilders.standaloneSetup(new MyController()).build();
//        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void getName() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/my/integration/{name}", "lisi");
//        MockMvcRequestBuilders.post()
//        MockMvcRequestBuilders.delete()
//        MockMvcRequestBuilders.put()
//        ... 其他的http请求
        // 请求接受类型
//        builder.accept(MediaType.APPLICATION_JSON);
        // 参数
//        builder.param();
        // 请求的body
//        builder.content();
//        ... 还有一些其他的请求参数设置，具体的可以查看api

//        执行后返回结果的动作
        ResultActions resultActions = mvc.perform(builder);

        // 打印并返回结果
        // code 是否是200
        MvcResult result = resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                // 内容是不是 name:lisi
                .andExpect(MockMvcResultMatchers.content().string("name:lisi"))
                // 打印
                .andDo(MockMvcResultHandlers.print())
                // 返回结果
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        logger.info("响应状态:{},响应内容:{}", response.getStatus(), response.getContentAsString());

    }


}
