package com.te.hotelservice.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.hotelservice.customexception.CustomException;
import com.te.hotelservice.entity.Hotel;
import com.te.hotelservice.hoteldto.HotelDto;
import com.te.hotelservice.repository.HotelRepo;

@Service
public class HotelServiceimpl implements HotelService {

	@Autowired
	private HotelRepo repo;

	@Override
	public Hotel addHotel(HotelDto dto) {
		try {
			if (dto == null) {
				throw new CustomException("SomeThing Went Wrong");
			} else {
				Hotel hotel = new Hotel();
				BeanUtils.copyProperties(dto, hotel);
				String hotelId = UUID.randomUUID().toString();
				hotel.setHotelId(hotelId);
				return repo.save(hotel);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Hotel getHotel(int id) {
		try {
			Optional<Hotel> findById = repo.findById(id);
			if (!findById.isPresent()) {
				throw new CustomException("Which Hotel You Want Is Not Present On This Id");
			} else {
				return findById.get();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Hotel> getAllHotels() {
		try {
			List<Hotel> findAll = repo.findAll();
			if (findAll.isEmpty()) {
				throw new CustomException("No one Hotel Present At The Moment");
			} else {
				return findAll;
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
