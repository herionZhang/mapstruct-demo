package com.herion.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVO {
    private Long id;
    private String disable;
    private String email;
    private String birthDateFormat;
    private String username;
    private String phoneNum;
}