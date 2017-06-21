package com.dharbor.evaluation.web;

import com.dharbor.evaluation.domain.Car;
import com.dharbor.evaluation.domain.Seller;
import com.dharbor.evaluation.dto.SellerDTO;
import com.dharbor.evaluation.service.CarService;
import com.dharbor.evaluation.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lito on 21/6/17.
 */
@RestController
@RequestMapping(value = "sellers")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<SellerDTO> findAll() {
        return sellerService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public SellerDTO save(@RequestBody SellerDTO seller) {
        return sellerService.save(seller);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public SellerDTO findOne(@PathVariable long id) {
        return sellerService.findOne(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        sellerService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public SellerDTO update(@RequestBody SellerDTO seller) {
        return sellerService.update(seller);
    }
}


