package com.herion.example.demo.mappers;

import com.herion.example.demo.dto.CarDto;
import com.herion.example.demo.entity.Car;
import org.junit.Test;



public class CarMapperTest {

    @Test
    public void shouldMapCarToDto() {
        //given
        Car car = new Car("Morris", 5);

        //when
        CarDto carDto = CarMapper.INSTANCE.carToCarDto( car );

        System.out.println(carDto.toString());
    }
}