package com.taaaad.test;


import com.taaaaad.config.SpringConfiguration;
import com.taaaaad.domain.Account;
import com.taaaaad.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

/**
 * 使用Junit 进行单元测试
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as;


    /**
     * 测试转账功能
     */
    @Test
    public void testTransfer(){
        as.transfer("aaa", "bbb", 100f);
    }



}
