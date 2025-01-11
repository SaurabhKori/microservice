
package com.sk.ratingservice.controller;

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

import com.sk.ratingservice.dto.Rating;
import com.sk.ratingservice.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingControler {
	@Autowired
  private RatingService rs;
  @PostMapping("/saverating")
  public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
	  return ResponseEntity.status(HttpStatus.CREATED).body(rs.saveRating(rating));
  }
  @GetMapping("/byuserid/{id}")
  public ResponseEntity<List<Rating>> byUserId(@PathVariable("id") String id){
	  return ResponseEntity.ok().body(rs.getUserId(id));
  }
  @PostMapping("/byhotelid/{id}")
  public ResponseEntity<List<Rating>> byHotelId(@PathVariable("id") String id){
	  return ResponseEntity.ok().body(rs.gethotelId(id));
  }
  @GetMapping("/getrating")
  public ResponseEntity<List<Rating>> getAllRating(){
	  return ResponseEntity.ok().body(rs.getAllRating());
  }
  @PostMapping("/byratingid/{id}")
  public ResponseEntity<Rating> byratingId(@PathVariable("id") String id){
	  return ResponseEntity.ok().body(rs.getbyIdrating(id));
  }
  
}
