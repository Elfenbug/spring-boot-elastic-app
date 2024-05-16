package ru.ibs.springbootelasticapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ibs.springbootelasticapp.dto.CarRequestDto;
import ru.ibs.springbootelasticapp.dto.CarResponseDto;
import ru.ibs.springbootelasticapp.mapper.CarMapper;
import ru.ibs.springbootelasticapp.model.Car;
import ru.ibs.springbootelasticapp.repository.CarRepository;
import ru.ibs.springbootelasticapp.service.CarService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public void addCar(CarRequestDto carRequestDto) {
        Car car = carMapper.toModel(carRequestDto);
        carRepository.save(car);
    }

    @Override
    public Optional<CarResponseDto> findCarById(String id) {
        Optional<Car> car = carRepository.findById(id);
        return car.map(carMapper::toDto);
    }

    @Override
    public List<CarResponseDto> findCarByBrand(String id) {
        List<Car> cars = carRepository.findByBrand(id);
        return cars.stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarResponseDto> findAllCars() {
        Iterable<Car> cars = carRepository.findAll();
        return StreamSupport.stream(cars.spliterator(), false)
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCar(String id) {
        carRepository.deleteById(id);
    }

    @Override
    public void updateCar(CarRequestDto carRequestDto) {
        Car car = carMapper.toModel(carRequestDto);
        carRepository.save(car);
    }

}
