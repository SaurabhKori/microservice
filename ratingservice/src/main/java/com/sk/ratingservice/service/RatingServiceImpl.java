package com.sk.ratingservice.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.ratingservice.dto.Rating;
import com.sk.ratingservice.exception.ResoursceNotFoundException;
import com.sk.ratingservice.repo.RatingRepo;
@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
private RatingRepo ratingrepo;
	@Override
	public Rating saveRating(Rating rating) {
		 int idLength = 6;  // You can change this to whatever length you need
	        
	        // Create a random object
	        Random random = new Random();
	        
	     
	        StringBuilder uniqueID = new StringBuilder();
	        
	     
	        String characters = ""+rating.getHotelId()+rating.getUserId()+System.currentTimeMillis();
	        characters=characters.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
	        System.err.println(characters);
	        // Generate a random ID
	        for (int i = 0; i < idLength; i++) {
	            int randomIndex = random.nextInt(characters.length());  // Get a random index
	            uniqueID.append(characters.charAt(randomIndex));  // Append the random character
	        }
	        
	        // Convert to string and print
	        String randomUniqueID = uniqueID.toString();
		rating.setRatingId(randomUniqueID);
		return ratingrepo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
	
		return ratingrepo.findAll();
	}

	@Override
	public Rating getbyIdrating(String id) {
	
		return ratingrepo.findById(id).orElseThrow(()->new ResoursceNotFoundException("rating with id not found"+id));
	}

	@Override
	public List<Rating> getUserId(String id) {
	
		return ratingrepo.findByUserId(id);
	}

	@Override
	public List<Rating> gethotelId(String id) {
		
		return ratingrepo.findByHotelId(id);
	}

}
