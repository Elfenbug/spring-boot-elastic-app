package ru.ibs.springbootelasticapp.service;

import ru.ibs.springbootelasticapp.dto.CarRequestDto;
import ru.ibs.springbootelasticapp.dto.CarResponseDto;

import java.util.List;
import java.util.Optional;

public interface CarService {
    void addCar(CarRequestDto carRequestDto);
    Optional<CarResponseDto> findCarById(String id);
    List<CarResponseDto> findCarByBrand(String id);
    List<CarResponseDto> findAllCars();
    void deleteCar(String id);
    void updateCar(CarRequestDto carRequestDto);
}
