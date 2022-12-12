package com.te.hotelservice.services;

import java.util.List;

import com.te.hotelservice.entity.Hotel;
import com.te.hotelservice.hoteldto.HotelDto;

public interface HotelService {

	Hotel addHotel(HotelDto dto);

	Hotel getHotel(int id);

	List<Hotel> getAllHotels();

}
