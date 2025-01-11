package com.sk.hotelservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.hotelservice.dto.Hotels;

public interface HotelRepo extends JpaRepository<Hotels,String> {

}
