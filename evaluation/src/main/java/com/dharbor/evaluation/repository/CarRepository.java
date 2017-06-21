package com.dharbor.evaluation.repository;

import com.dharbor.evaluation.domain.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lito on 20/6/17.
 */
public interface CarRepository extends CrudRepository<Car, Long> {

}
