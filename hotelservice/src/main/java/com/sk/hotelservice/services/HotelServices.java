package com.sk.hotelservice.services;

import java.util.List;

import com.sk.hotelservice.dto.Hotels;

public interface HotelServices {
Hotels savehotel(Hotels hotel);
List<Hotels> getHotels();
Hotels getSingle(String Id);
}
