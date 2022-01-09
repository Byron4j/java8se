package org.byron4j.controller;

import org.byron4j.BaseTest;
import org.byron4j.beans.UserBean;
import org.byron4j.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

public class UserMapperTest extends BaseTest {
    @MockBean
    private UserMapper userMapper;
    private UserBean userZhang = UserBean.builder()
            .name("zhangSan")
            .age(23)
            .build();

    @Before
    public void setup() {
        Mockito.when(userMapper.findByName("zhangSan")).thenReturn(userZhang);
        Mockito.when(userMapper.findByName("liSi")).thenReturn(null);
    }

    @Test
    public void testGetUser() {
        Assert.assertEquals(userZhang, userMapper.findByName("zhangSan"));
        Assert.assertEquals(null, userMapper.findByName("liSi"));
    }


}
