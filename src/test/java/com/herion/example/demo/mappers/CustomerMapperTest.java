package com.herion.example.demo.mappers;

import com.herion.example.demo.DemoApplication;
import com.herion.example.demo.dto.CustomerDto;
import com.herion.example.demo.entity.Customer;
import com.herion.example.demo.entity.User;
import com.herion.example.demo.vo.CustomerVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class CustomerMapperTest {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerListMapper customerListMapper;



    @Test
    public void toCustomerTest(){
        CustomerDto customerDto = new CustomerDto(1L, "herion","Y");
        Customer customer = customerMapper.toCustomer(customerDto);
        System.out.println(customer.toString());
    }

    @Test
    public void fromCustomerTest(){
        Customer customer = new Customer(1L, "herion",true,null,null);
        CustomerDto customerDto = customerMapper.fromCustomer(customer);
        System.out.println(customerDto.toString());
    }


    @Test
    public void customersToCustomerDtoTest(){
        Customer customer = new Customer(1L, "herion",true,null,new Date());
        CustomerDto customerDto = customerMapper.customersToCustomerDto(customer);
        System.out.println(customerDto.toString());
    }

    @Test
    public void customersToCustomerDtosTest(){
        Customer customer1 = new Customer(1L, "herion1",true,null,new Date());
        Customer customer2 = new Customer(2L, "herion2",true,null,new Date());
        Customer customer3 = new Customer(3L, "herion3",true,null,new Date());
        List<Customer> list=new ArrayList<Customer>();
        list.add(customer1);
        list.add(customer2);
        list.add(customer3);
        List<CustomerDto> customerDtos = customerListMapper.customersToCustomerDtos(list);
        customerDtos.forEach(customer -> {
            System.out.println(customer.toString());
        });
    }


    @Test
    public void userCustomerToCustomerVOTest(){
        Customer customer = new Customer();
        customer.setId(111L);
        customer.setName("herion");
        customer.setIsDisable(true);
        customer.setBirthday(new Date());

        User user=new User();
        user.setEmail("11@qq.com");
        user.setId(222L);
        user.setPhoneNum("13812344321");
        CustomerVO customerVO = customerMapper.userCustomerToCustomerVO(customer,user);
        System.out.println(customerVO.toString());
    }
}