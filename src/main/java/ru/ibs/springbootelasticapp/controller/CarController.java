package ru.ibs.springbootelasticapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.springbootelasticapp.dto.CarRequestDto;
import ru.ibs.springbootelasticapp.dto.CarResponseDto;
import ru.ibs.springbootelasticapp.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    @PostMapping
    public void save(@RequestBody CarRequestDto dto) {
        carService.addCar(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CarResponseDto>> getById(@PathVariable String id) {
        return ResponseEntity.ok(carService.findCarById(id));
    }

    @GetMapping("/find")
    public ResponseEntity<List<CarResponseDto>> getAll(@RequestParam String brand) {
        return ResponseEntity.ok(carService.findCarByBrand(brand));
    }

    @GetMapping
    public ResponseEntity<List<CarResponseDto>> getAll() {
        return ResponseEntity.ok(carService.findAllCars());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        carService.deleteCar(id);
    }

    @PutMapping
    public void update(@RequestBody CarRequestDto dto) {
        carService.updateCar(dto);
    }
}
