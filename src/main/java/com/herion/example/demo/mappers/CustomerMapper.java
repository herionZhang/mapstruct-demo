package com.herion.example.demo.mappers;

import com.herion.example.demo.dto.CustomerDto;
import com.herion.example.demo.entity.Customer;
import com.herion.example.demo.entity.User;
import com.herion.example.demo.format.BooleanStrFormat;
import com.herion.example.demo.vo.CustomerVO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { BooleanStrFormat.class})
public interface CustomerMapper {

    /**
     * @Mapping(source = “customerName”, target = “name”)用来指定属性映射的，如果两个对象的属性名相同是可以省略
     * @param customerDto
     * @return
     */
    @Mappings({
            @Mapping(source = "customerName", target = "name"),
            @Mapping(source = "disable", target = "isDisable")
    })
    Customer toCustomer(CustomerDto customerDto);


    /**
     * @InheritInverseConfiguration在这里的作用就是实现customerDto.customerName = customer.getName();功能的。如果没有这个注解，toCustomerDto这个方法则不会有customerName 和name两个属性的对应关系的。
     * @param customer
     * @return
     */
    @InheritInverseConfiguration
    CustomerDto fromCustomer(Customer customer);


    @Mappings({
            @Mapping(source = "name", target = "customerName"),
            @Mapping(source = "isDisable", target = "disable")
    })
    CustomerDto customersToCustomerDto(Customer customer);


    /**
     * 多转一
     * @param customer
     * @param user
     * @return
     */
    @Mappings({
            @Mapping(source = "customer.name", target = "username"),
            @Mapping(source = "customer.id", target = "id"),
            //格式转换
            @Mapping(source = "customer.isDisable", target = "disable"),
            //日期格式转换
            @Mapping(source = "customer.birthday", target = "birthDateFormat", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            //ignore 忽略映射
            @Mapping(target = "email", ignore = true)
    })
    CustomerVO userCustomerToCustomerVO(Customer customer, User user);



}