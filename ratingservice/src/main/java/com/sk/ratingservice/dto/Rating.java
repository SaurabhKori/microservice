package com.sk.ratingservice.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	@Id
	private String ratingId;

	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;

}
