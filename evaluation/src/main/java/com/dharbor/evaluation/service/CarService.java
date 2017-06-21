package com.dharbor.evaluation.service;

import com.dharbor.evaluation.domain.Car;
import com.dharbor.evaluation.dto.CarDTO;
import com.dharbor.evaluation.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lito on 20/6/17.
 */
@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<CarDTO> findAll() {
        Iterable<Car> iterable = carRepository.findAll();
        List<Car> cars = Lists.newArrayList(iterable);

        return getListDTO(cars);
    }

    public CarDTO findOne(long id) {
        return getDTO( carRepository.findOne(id) );
    }

    public CarDTO save(CarDTO car) {
        Car newCar = getCar(car);
        newCar = carRepository.save(newCar);
        return getDTO(newCar);
    }

    public void delete(long id){
        carRepository.delete(id);
    }

    public CarDTO update(CarDTO car) {

        return getDTO( carRepository.save(getCar(car)) );
    }

    private List<CarDTO> getListDTO(List<Car> cars) {
        List<CarDTO> carDTOs = new ArrayList<>();
        for (Car car: cars){

            carDTOs.add(getDTO(car));
        }
        return carDTOs;
    }

    private CarDTO getDTO(Car car) {
        CarDTO carDTO = new CarDTO();

        carDTO.setBrand(car.getBrand());
        carDTO.setColor(car.getColor());
        carDTO.setImage(car.getImage());
        carDTO.setModel(car.getModel());
        carDTO.setYear(car.getYear());
        carDTO.setId(car.getId());

        return carDTO;
    }

    private Car getCar(CarDTO car) {
        Car carNew = new Car();

        carNew.setBrand(car.getBrand());
        carNew.setColor(car.getColor());
        carNew.setImage(car.getImage());
        carNew.setModel(car.getModel());
        carNew.setYear(car.getYear());
        if (car.getId() == 0){
            carNew.setId(0);
        }else{
            carNew.setId(car.getId());
        }

        return carNew;
    }

}
