package ru.ibs.springbootelasticapp.dto;

import lombok.Data;
import ru.ibs.springbootelasticapp.model.Owner;

import java.util.List;

@Data
public class CarResponseDto {
    private String id;
    private String model;
    private Integer yearOfManufacture;
    private String brand;
    private List<Owner> owners;
}
