package com.herion.example.demo.mappers;

import com.herion.example.demo.DemoApplication;
import com.herion.example.demo.dto.UserRoleDto;
import com.herion.example.demo.entity.Role;
import com.herion.example.demo.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class UserRoleMapperTest {

    // 注入Mapper
    @Autowired
    private UserRoleMapper userRoleMapper;

    Role role = null;
    User user = null;

    @Before
    public void before() {
        role = new Role(2L, "admin", "超级管理员");
        user = new User(1L, "herion", "123456", "1389999888", "123@qq.com", role);
    }

    @Test
    public void toUserRoleDtoTest() {
        UserRoleDto userRoleDto=userRoleMapper.toUserRoleDto(user);
        System.out.println(userRoleDto);
    }

    @Test
    public void toUserRoleDto2Test() {
        UserRoleDto userRoleDto=userRoleMapper.toUserRoleDto(user,role);
        System.out.println(userRoleDto);
    }

    @Test
    public void updateDtoTest() {
        UserRoleDto userRoleDto=new UserRoleDto();
        userRoleDto.setName("管理员");
        userRoleDto.setRoleName("架构部");
        userRoleDto.setUserId(2L);
        System.out.println("执行前 userRoleDto："+userRoleDto.toString());
        System.out.println("执行前 user："+user.toString());
        userRoleMapper.updateDto(userRoleDto,user);
        System.out.println("执行后 userRoleDto："+userRoleDto.toString());
        System.out.println("执行后 user："+user.toString());
    }



    @Test
    public void useParameterTest() {
        UserRoleDto userRoleDto = userRoleMapper.useParameter(user, "myUserRole");
        System.out.println(userRoleDto);
    }
}