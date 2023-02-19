package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.Dto.RealEstateDto;
import com.bezkoder.springjwt.models.RealEstate;
import com.bezkoder.springjwt.repository.RealEstateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class realEstateServiceImpl implements realEstateService {
    @Autowired
    private RealEstateRepository realEstateRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<RealEstateDto> getByhomeNumber(String homeNumber) {
        List<RealEstateDto> realEstateDto = Collections.singletonList(modelMapper.map(realEstateRepository.findByhomeNumber(homeNumber), RealEstateDto.class));
        return realEstateDto;
    }

    @Override
    public List<RealEstateDto> getAllRealEstate() {
        List<RealEstateDto> realEstateDto = Collections.singletonList(modelMapper.map(realEstateRepository.findAll(), RealEstateDto.class));
        return realEstateDto;
    }

    @Override
    public RealEstateDto getRealEstateById(long id) {
        realEstateRepository.findById(id);
        RealEstateDto realEstateDto = modelMapper.map(realEstateRepository.findById(id), RealEstateDto.class);
        return realEstateDto;
    }

    @Override
    public RealEstateDto createRealEstate(RealEstateDto realEstateDto) {
        RealEstate realEstate = modelMapper.map(realEstateDto, RealEstate.class);
        realEstateRepository.save(realEstate);
        return realEstateDto;
    }

    @Override
    public void updateRealEstate(RealEstateDto realEstateDto) {
        RealEstateDto getRealEstateById = getRealEstateById(realEstateDto.getId());
        if (getRealEstateById != null) {
            RealEstate realEstate = modelMapper.map(realEstateDto, RealEstate.class);
            realEstate.setHomeNumber(realEstateDto.getHomeNumber());
            realEstate.setPrice(realEstateDto.getPrice());
            realEstate.setCity(realEstateDto.getCity());
            realEstate.setDistrict(realEstateDto.getDistrict());
            realEstate.setWard(realEstateDto.getWard());
            realEstate.setStreet(realEstateDto.getStreet());
            realEstate.setStructure(realEstateDto.getStructure());
            realEstate.setTotalArea(realEstateDto.getTotalArea());
            realEstate.setPriceM2(realEstateDto.getPriceM2());
            realEstate.setOwner(realEstateDto.getOwner());
            realEstate.setPhoneOwner(realEstateDto.getPhoneOwner());
            realEstate.setStatus(realEstateDto.getStatus());
            realEstateRepository.save(realEstate);
        } else
            throw new RuntimeException("RealEstate not found");
    }

    @Override
    public void deleteRealEstate(long id) {
        RealEstateDto getRealEstateById = getRealEstateById(id);
        if (getRealEstateById != null) {
            realEstateRepository.deleteById(id);
        } else
            throw new RuntimeException("RealEstate not found");

    }
}
