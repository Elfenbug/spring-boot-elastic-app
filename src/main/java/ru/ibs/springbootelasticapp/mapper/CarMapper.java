package ru.ibs.springbootelasticapp.mapper;

import org.springframework.stereotype.Component;
import ru.ibs.springbootelasticapp.dto.CarRequestDto;
import ru.ibs.springbootelasticapp.dto.CarResponseDto;
import ru.ibs.springbootelasticapp.model.Car;

@Component
public class CarMapper {

    public Car toModel(CarRequestDto dto) {
        Car car = new Car();
        car.setModel(dto.getModel());
        car.setBrand(dto.getBrand());
        car.setYearOfManufacture(dto.getYearOfManufacture());
        car.setOwners(dto.getOwners());
        return car;
    }

    public CarResponseDto toDto(Car model) {
        CarResponseDto dto = new CarResponseDto();
        dto.setModel(model.getModel());
        dto.setBrand(model.getBrand());
        dto.setId(model.getId());
        dto.setYearOfManufacture(model.getYearOfManufacture());
        dto.setOwners(model.getOwners());
        return dto;
    }
}
