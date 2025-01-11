package com.sk.hotelservice.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.hotelservice.dto.Hotels;
import com.sk.hotelservice.exception.ResourceNotFoundException;
import com.sk.hotelservice.repo.HotelRepo;
@Service
public class HotelServiceImpl implements HotelServices {
	@Autowired
   private HotelRepo hotelrepo;
	@Override
	public Hotels savehotel(Hotels hotel) {
		int idLength = 5;  // You can change this to whatever length you need
        
        // Create a random object
        Random random = new Random();
        
     
        StringBuilder uniqueID = new StringBuilder();
        
     
        String characters = ""+hotel.getHotel_name()+hotel.getHotel_location()+hotel.getHotel_abouts()+System.currentTimeMillis();
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
hotel.setHotelID(randomUniqueID);
		return hotelrepo.save(hotel);
	}

	@Override
	public List<Hotels> getHotels() {
	
		return hotelrepo.findAll();
	}

	@Override
	public Hotels getSingle(String Id) {
		
		return hotelrepo.findById(Id).orElseThrow(()->new ResourceNotFoundException("hotel with given by id not found"+Id));
	}

}
