package com.dharbor.evaluation.service;

import com.dharbor.evaluation.domain.Buyer;
import com.dharbor.evaluation.dto.BuyerDTO;
import com.dharbor.evaluation.repository.BuyerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lito on 21/6/17.
 */
@Service
public class BuyerService {

    @Autowired
    BuyerRepository buyerRepository;

    public List<BuyerDTO> findAll() {
        Iterable<Buyer> iterable = buyerRepository.findAll();
        List<Buyer> buyers = Lists.newArrayList(iterable);
        return getListDTO( buyers);
    }

    public BuyerDTO findOne(long id) {
        return getDTO(buyerRepository.findOne(id));
    }

    public BuyerDTO save(BuyerDTO buyer) {
        Buyer newBuyer = getDomain(buyer);
        newBuyer = buyerRepository.save(newBuyer);
        return getDTO(newBuyer);
    }

    public void delete(long id){
        buyerRepository.delete(id);
    }

    public BuyerDTO update(BuyerDTO buyer) {
        return getDTO(buyerRepository.save(getDomain(buyer)));
    }

    private List<BuyerDTO> getListDTO(List<Buyer> buyers) {
        List<BuyerDTO> carDTOs = new ArrayList<>();
        for (Buyer buyer: buyers){

            carDTOs.add(getDTO(buyer));
        }
        return carDTOs;
    }

    private BuyerDTO getDTO(Buyer buyer) {
        BuyerDTO buyerDTO = new BuyerDTO();

        buyerDTO.setCi(buyer.getCi());
        buyerDTO.setCel(buyer.getCel());
        buyerDTO.setName(buyer.getName());
        buyerDTO.setProfessiom(buyer.getProfessiom());
        buyerDTO.setId(buyer.getId());

        return buyerDTO;
    }

    private Buyer getDomain(BuyerDTO buyerDTO) {
        Buyer newBuyer = new Buyer();

        newBuyer.setCel(buyerDTO.getCel());
        newBuyer.setCi(buyerDTO.getCi());
        newBuyer.setProfessiom(buyerDTO.getProfessiom());
        newBuyer.setName(buyerDTO.getName());

        if (buyerDTO.getId() == 0){
            newBuyer.setId((long) 0);
        }else{
            newBuyer.setId(buyerDTO.getId());
        }

        return newBuyer;
    }
}
