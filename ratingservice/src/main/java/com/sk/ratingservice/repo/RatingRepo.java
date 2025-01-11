package com.sk.ratingservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.ratingservice.dto.Rating;

public interface RatingRepo extends JpaRepository<Rating,String>{
List<Rating> findByUserId(String userId);
List<Rating> findByHotelId(String hotelId);
}
