package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.Dto.RealEstateDto;

import java.util.List;

public interface realEstateService {
    List<RealEstateDto> getByhomeNumber(String homeNumber);
    List<RealEstateDto> getAllRealEstate();

    RealEstateDto getRealEstateById(long id);

    RealEstateDto createRealEstate(RealEstateDto realEstateDto);

    void updateRealEstate(RealEstateDto realEstateDto);

    void deleteRealEstate(long id);
}
