package com.te.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.hotelservice.entity.Hotel;

@Repository
public interface HotelRepo  extends JpaRepository<Hotel, Integer>{

}
