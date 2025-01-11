package com.sk.ratingservice.service;

import java.util.List;

import com.sk.ratingservice.dto.Rating;

public interface RatingService {
Rating saveRating(Rating rating);
List<Rating> getAllRating();
Rating getbyIdrating(String id);
List<Rating> getUserId(String id);
List<Rating> gethotelId(String id);
}
