package com.dharbor.evaluation.web;

import com.dharbor.evaluation.domain.Car;
import com.dharbor.evaluation.dto.CarDTO;
import com.dharbor.evaluation.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lito on 20/6/17.
 */
@RestController
@RequestMapping(value = "cars")
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CarDTO> findAll() {
        return carService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public CarDTO save(@RequestBody CarDTO car) {
        return carService.save(car);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public CarDTO findOne(@PathVariable long id) {
        return carService.findOne(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        carService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public CarDTO update(@RequestBody CarDTO car) {
        return carService.update(car);
    }

}
