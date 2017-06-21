package com.dharbor.evaluation.service;

import com.dharbor.evaluation.domain.Seller;
import com.dharbor.evaluation.dto.SellerDTO;
import com.dharbor.evaluation.repository.SellerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lito on 21/6/17.
 */
@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;

    public List<SellerDTO> findAll() {
        Iterable<Seller> iterable = sellerRepository.findAll();
        List<Seller> sellers = Lists.newArrayList(iterable);

        return getListDTO(sellers);
    }

    public SellerDTO findOne(long id) {
        return getDTO(sellerRepository.findOne(id));
    }

    public SellerDTO save(SellerDTO seller) {
        return getDTO(sellerRepository.save(getDomain(seller)));
    }

    public void delete(long id){
        sellerRepository.delete(id);
    }

    public SellerDTO update(SellerDTO seller) {
        return getDTO(sellerRepository.save(getDomain(seller)));
    }

    private List<SellerDTO> getListDTO(List<Seller> buyers) {
        List<SellerDTO> carDTOs = new ArrayList<>();
        for (Seller seller: buyers){

            carDTOs.add(getDTO(seller));
        }
        return carDTOs;
    }

    private SellerDTO getDTO(Seller seller) {
        SellerDTO sellerDTO = new SellerDTO();

        sellerDTO.setName(seller.getName());
        sellerDTO.setCi(seller.getCi());
        sellerDTO.setAge(seller.getAge());
        sellerDTO.setNumCar(seller.getNumCar());
        sellerDTO.setId(seller.getId());

        return sellerDTO;
    }

    private Seller getDomain(SellerDTO sellerDTO) {
        Seller seller = new Seller();

        seller.setNumCar(sellerDTO.getNumCar());
        seller.setAge(sellerDTO.getAge());
        seller.setCi(sellerDTO.getCi());
        seller.setName(sellerDTO.getName());

        if (sellerDTO.getId() == 0){
            seller.setId((long) 0);
        }else{
            seller.setId(sellerDTO.getId());
        }

        return seller;
    }
}
