package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.Dto.RealEstateDto;
import com.bezkoder.springjwt.models.RealEstate;
import com.bezkoder.springjwt.repository.RealEstateRepository;
import com.bezkoder.springjwt.services.realEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RealEstateController {
    @Autowired
    realEstateService service;


    //param homeNumber
    @GetMapping("/realestate")
    public ResponseEntity<List<RealEstateDto>> getByhomeNumber(@RequestParam(required = false) String homeNumber) {
        try {
            List<RealEstateDto> realEstate = new ArrayList<RealEstateDto>();

            if (homeNumber == null)
                service.getAllRealEstate().forEach(realEstate::add);
            else
                service.getByhomeNumber(homeNumber).forEach(realEstate::add);

            if (realEstate.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(realEstate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/realEstate")
    public ResponseEntity<List<RealEstateDto>> getAllRealEstate() {
        try {
            List<RealEstateDto> realEstate = new ArrayList<RealEstateDto>();

            service.getAllRealEstate().forEach(realEstate::add);

            if (realEstate.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(realEstate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/realestate/{id}")
    public ResponseEntity<RealEstateDto> getTutorialById(@PathVariable("id") long id) {
        Optional<RealEstateDto> realEstateData = Optional.ofNullable(service.getRealEstateById(id));
        if (realEstateData.isPresent()) {
            return new ResponseEntity<>(realEstateData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/realestate")
    public ResponseEntity<?> createTutorial(@RequestBody RealEstateDto realEstateDto) {
        try {
            RealEstateDto _realEstateDto = service.createRealEstate(realEstateDto);
            return new ResponseEntity<>(_realEstateDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/realestate/{id}")
    public ResponseEntity<RealEstateDto> updateTutorial(@PathVariable("id") long id, @RequestBody RealEstateDto realEstateDto) {
        Optional<RealEstateDto> realEstateData = Optional.ofNullable(service.getRealEstateById(id));

        if (realEstateData.isPresent()) {
            RealEstateDto _realEstateDto = realEstateData.get();
            _realEstateDto.setHomeNumber(realEstateDto.getHomeNumber());
            _realEstateDto.setPrice(realEstateDto.getPrice());
            _realEstateDto.setCity(realEstateDto.getCity());
            _realEstateDto.setDistrict(realEstateDto.getDistrict());
            _realEstateDto.setWard(realEstateDto.getWard());
            _realEstateDto.setStreet(realEstateDto.getStreet());
            _realEstateDto.setStructure(realEstateDto.getStructure());
            service.updateRealEstate(_realEstateDto);
            return new ResponseEntity<>(_realEstateDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/realestate/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            service.deleteRealEstate(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
