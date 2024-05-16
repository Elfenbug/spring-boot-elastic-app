package ru.ibs.springbootelasticapp.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ru.ibs.springbootelasticapp.model.Car;

import java.util.List;

public interface CarRepository extends ElasticsearchRepository<Car, String> {
    List<Car> findByBrand(String brand);
}
