package com.te.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ratingservice.entity.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer> {

	List<Rating> findAllByUserId(String userId);

	List<Rating> findAllByHotelId(String hotelId);

}
