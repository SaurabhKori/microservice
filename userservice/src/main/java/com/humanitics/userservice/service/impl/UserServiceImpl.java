package com.humanitics.userservice.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.humanitics.userservice.dao.UserRepo;
import com.humanitics.userservice.dto.Hotels;
import com.humanitics.userservice.dto.Rating;
import com.humanitics.userservice.dto.User;
import com.humanitics.userservice.exception.ResourceNotFoundException;
import com.humanitics.userservice.externalservice.Hotel;
import com.humanitics.userservice.service.UserService;
import com.netflix.discovery.converters.Auto;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
   private UserRepo userRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private Hotel htl;
	@Autowired
	private com.humanitics.userservice.externalservice.Rating rt;
	private Logger log=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user)  {
		try {
//			String userid=UUID.fromString(input).toString();
			  int idLength = 6;  // You can change this to whatever length you need
		        
		        // Create a random object
		        Random random = new Random();
		        
		     
		        StringBuilder uniqueID = new StringBuilder();
		        
		     
		        String characters = ""+user.getEmail()+user.getUsername()+System.currentTimeMillis();
		        characters=characters.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
		        System.err.println(characters);
		        // Generate a random ID
		        for (int i = 0; i < idLength; i++) {
		            int randomIndex = random.nextInt(characters.length());  // Get a random index
		            uniqueID.append(characters.charAt(randomIndex));  // Append the random character
		        }
		        
		        // Convert to string and print
		        String randomUniqueID = uniqueID.toString();
			System.err.println("userid  "+randomUniqueID);
			user.setUser_id(randomUniqueID);
			return userRepo.save(user);
		}catch(Exception e) {
			
			
			System.err.println(e.getMessage());
		}
return null;
	}

	@Override
	public List<User> getAllUser() {
	
		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
	User user=	userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on server !! :"+userId));
	
//	Rating[] rating1=restTemplate.getForObject("http://RATINGSERVICE/rating/byuserid/"+userId,Rating[].class);
	Rating[] rating1=rt.getRatingByuserID(user.getUser_id());
	List<Rating> a=Arrays.stream(rating1).toList();
	List<Rating> ratings=a.stream().map(rating->{
//	Hotels hotel=	restTemplate.getForObject("http://HOTELSERVICE/hotel/gethotelbyid/"+rating.getHotelId() ,Hotels.class);
		Hotels hotel=htl.getHotelById(rating.getHotelId());
	rating.setHotel(hotel);
		return rating;
	}).collect(Collectors.toList());
	user.setRatings(ratings);
	
	log.info(""+a);
		return user;
	}

}
