package com.humanitics.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
private String ratingId;
private String userId;
private String hotelId;
private int rating;
private String feedback;
private Hotels hotel;
}
