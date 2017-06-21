package com.dharbor.evaluation.web;

import com.dharbor.evaluation.domain.RegistryCarSold;
import com.dharbor.evaluation.domain.Seller;
import com.dharbor.evaluation.dto.RegistryCarSoldDTO;
import com.dharbor.evaluation.dto.SellerDTO;
import com.dharbor.evaluation.service.RegistryCarSoldService;
import com.dharbor.evaluation.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lito on 21/6/17.
 */
@RestController
@RequestMapping(value = "sold")
public class RegistryCarSoldController {
    @Autowired
    RegistryCarSoldService carSoldService;

    @Autowired
    SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<RegistryCarSoldDTO> findAll() {
        return carSoldService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public RegistryCarSoldDTO save(@RequestBody RegistryCarSoldDTO registryCarSold) {
        return carSoldService.save(registryCarSold);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public RegistryCarSoldDTO findOne(@PathVariable long id) {
        return carSoldService.findOne(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        carSoldService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public RegistryCarSoldDTO update(@RequestBody RegistryCarSoldDTO registryCarSold) {
        return carSoldService.update(registryCarSold);
    }

    @RequestMapping(value="/canCarsSoldBySeller/{sellerId}",method = RequestMethod.GET)
    public HashMap<String,Object> getSold(@PathVariable("sellerId") long sellerId){

        SellerDTO seller = sellerService.findOne(sellerId);

        HashMap<String,Object> hashMap = new HashMap<String,Object>();
        hashMap.put("nameSeller",seller.getName());
        hashMap.put("QuantityCarsSold",seller.getNumCar());

        return hashMap;
    }
}
