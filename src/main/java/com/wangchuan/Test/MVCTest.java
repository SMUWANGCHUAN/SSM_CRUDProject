package com.wangchuan.Test;

import com.github.pagehelper.PageInfo;
import com.wangchuan.Bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * 测试emps,controller的正确性
 * @author wangchuan
 * @creat 2021-06-10-16:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/applicationContext-mvc.xml"})
public class MVCTest {
    //传入mvc的ioc
    @Autowired
    WebApplicationContext applicationContext;
    //虚拟的mvc
    MockMvc mockMvc;

    @Before
    public void InitMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
        System.out.println(mockMvc);
    }

    @Test
    public  void testPage() throws Exception {
        //模拟请求，拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码" + pageInfo.getPageNum());
        System.out.println("总页码：" + pageInfo.getPages());
        System.out.println("总记录数：" + pageInfo.getTotal());
        int[] nums = pageInfo.getNavigatepageNums();
        for (int i:nums){
            System.out.println(i+"");
        }
        List<Employee> list = pageInfo.getList();
        for (Employee employee:list){
            System.out.println(employee);
        }
    }
}
