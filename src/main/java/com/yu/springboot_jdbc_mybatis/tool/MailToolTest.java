package com.yu.springboot_jdbc_mybatis.tool;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailToolTest {
    @Autowired
    private MailTool mailTool;
    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void sendSimpleMail() {
        String[] filePathList = new String[]{};
        Map<String, Object> valueMap = new HashMap<String, Object>();
        valueMap.put("to", new String[]{"1727493926@qq.com"});
        valueMap.put("title", "测试邮件标题");
        valueMap.put("content","测试邮件内容");
        valueMap.put("filePathList", filePathList);
        mailTool.sendSimpleMail(valueMap);
    }
}