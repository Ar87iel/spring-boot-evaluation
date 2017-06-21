package com.dharbor.evaluation.web;

import com.dharbor.evaluation.domain.Buyer;
import com.dharbor.evaluation.dto.BuyerDTO;
import com.dharbor.evaluation.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lito on 21/6/17.
 */
@RestController
@RequestMapping(value = "buyers")
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<BuyerDTO> findAll() {
        return buyerService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public BuyerDTO save(@RequestBody BuyerDTO buyer) {
        return buyerService.save(buyer);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public BuyerDTO findOne(@PathVariable long id) {
        return buyerService.findOne(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        buyerService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BuyerDTO update(@RequestBody BuyerDTO buyer) {
        return buyerService.update(buyer);
    }
}
