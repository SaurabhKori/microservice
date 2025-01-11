package com.humanitics.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotels {
	private String hotelID;
	private String hotel_name;
	private String hotel_location;
	private String hotel_abouts;
}
