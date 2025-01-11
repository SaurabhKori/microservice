package com.sk.hotelservice.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotels {
	@Id
private String hotelID;
private String hotel_name;
private String hotel_location;
private String hotel_abouts;

}
