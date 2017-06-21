package com.dharbor.evaluation.service;

import com.dharbor.evaluation.domain.RegistryCarSold;
import com.dharbor.evaluation.domain.Seller;
import com.dharbor.evaluation.dto.RegistryCarSoldDTO;
import com.dharbor.evaluation.repository.BuyerRepository;
import com.dharbor.evaluation.repository.CarRepository;
import com.dharbor.evaluation.repository.RegistryCarSoldRepository;
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
public class RegistryCarSoldService {

    @Autowired
    RegistryCarSoldRepository registryRepository;

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    CarRepository carRepository;

    public List<RegistryCarSoldDTO> findAll() {
        Iterable<RegistryCarSold> iterable = registryRepository.findAll();
        List<RegistryCarSold> cars = Lists.newArrayList(iterable);
        return getListDTO(cars);
    }

    public RegistryCarSoldDTO findOne(long id) {
        return getDTO(registryRepository.findOne(id));
    }

    public RegistryCarSoldDTO save(RegistryCarSoldDTO registry) {
        Seller seller = sellerRepository.findOne(registry.getIdSeller());
        seller.setNumCar(seller.getNumCar()+1);
        sellerRepository.save(seller);
        return getDTO(registryRepository.save(getDomain(registry)));
    }

    public void delete(long id){
        registryRepository.delete(id);
    }

    public RegistryCarSoldDTO update(RegistryCarSoldDTO registry) {
        return getDTO(registryRepository.save(getDomain(registry)));
    }

    private List<RegistryCarSoldDTO> getListDTO(List<RegistryCarSold> registryCarSolds) {
        List<RegistryCarSoldDTO> carSoldDTOs = new ArrayList<>();
        for (RegistryCarSold carSold: registryCarSolds){

            carSoldDTOs.add(getDTO(carSold));
        }
        return carSoldDTOs;
    }

    private RegistryCarSoldDTO getDTO(RegistryCarSold carSold) {
        RegistryCarSoldDTO carSoldDTO = new RegistryCarSoldDTO();

        carSoldDTO.setId(carSold.getId());
        carSoldDTO.setIdBuyer(carSold.getBuyer().getId());
        carSoldDTO.setIdCar(carSold.getCar().getId());
        carSoldDTO.setSellingDate(carSold.getSellingDate());
        carSoldDTO.setIdSeller(carSold.getSeller().getId());

        return carSoldDTO;
    }

    private RegistryCarSold getDomain(RegistryCarSoldDTO carSoldDTO) {
        RegistryCarSold carSold = new RegistryCarSold();

        carSold.setSellingDate(carSoldDTO.getSellingDate());
        carSold.setBuyer(buyerRepository.findOne(carSoldDTO.getIdBuyer()));
        carSold.setCar(carRepository.findOne(carSoldDTO.getIdCar()));
        carSold.setSeller(sellerRepository.findOne(carSoldDTO.getIdSeller()));

        if (carSoldDTO.getId() == 0){
            carSold.setId((long) 0);
        }else{
            carSold.setId(carSoldDTO.getId());
        }

        return carSold;
    }
}
