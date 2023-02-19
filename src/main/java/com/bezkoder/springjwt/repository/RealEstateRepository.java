package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate,Long> {
    /*List<RealEstate> findByPublished(boolean published);*/
    @Query("SELECT r FROM RealEstate r WHERE r.homeNumber = ?1")
    List<RealEstate> findByhomeNumber(String homeNumber);
}
