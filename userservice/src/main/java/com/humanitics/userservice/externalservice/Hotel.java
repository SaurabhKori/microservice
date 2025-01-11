package com.humanitics.userservice.externalservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.humanitics.userservice.dto.Hotels;

@FeignClient(name = "HOTELSERVICE")
public interface Hotel {
	@GetMapping("/hotel/gethotelbyid/{hotelId}")
 Hotels getHotelById(@PathVariable("hotelId") String hotelId);
}
