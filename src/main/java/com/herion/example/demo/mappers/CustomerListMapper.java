package com.herion.example.demo.mappers;

import com.herion.example.demo.dto.CustomerDto;
import com.herion.example.demo.entity.Customer;
import com.herion.example.demo.format.BooleanStrFormat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { BooleanStrFormat.class})
public interface CustomerListMapper {

    @Mappings({
            @Mapping(source = "name", target = "customerName"),
            @Mapping(source = "isDisable", target = "disable")
    })
    CustomerDto customersToCustomerDto(Customer customer);


    List<CustomerDto> customersToCustomerDtos(List<Customer> customers);

}