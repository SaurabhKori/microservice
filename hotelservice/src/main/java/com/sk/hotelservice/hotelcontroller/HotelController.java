package com.sk.hotelservice.hotelcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.hotelservice.dto.Hotels;
import com.sk.hotelservice.services.HotelServices;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
 private HotelServices hotelservice;
	@PostMapping("/savehotel")
	public ResponseEntity<Hotels> savehotel(@RequestBody Hotels hotel) {
		System.out.println(hotel);
	Hotels hotels=	hotelservice.savehotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotels) ;
	}
	@GetMapping("/gethotelbyid/{hotelid}")
	public ResponseEntity<Hotels>  getHotelById(@PathVariable("hotelid") String hotelid) {
		Hotels hotel=hotelservice.getSingle(hotelid);
		return ResponseEntity.ok().body(hotel)  ;
	}
	@GetMapping("/gethotels")
	public  ResponseEntity<List<Hotels>> getHotels() {
		List<Hotels> hotel=	hotelservice.getHotels();
		return ResponseEntity.ok().body(hotel);
	}
}
