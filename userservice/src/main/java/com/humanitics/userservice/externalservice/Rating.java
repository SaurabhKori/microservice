package com.humanitics.userservice.externalservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="RATINGSERVICE")
public interface Rating {
	@GetMapping("/rating/byuserid/{userId}")
 com.humanitics.userservice.dto.Rating[] getRatingByuserID(@PathVariable("userId")String userId);
}
