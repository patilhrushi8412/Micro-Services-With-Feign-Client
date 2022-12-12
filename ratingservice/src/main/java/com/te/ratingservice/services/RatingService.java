package com.te.ratingservice.services;

import java.util.List;

import com.te.ratingservice.dto.RatingDto;
import com.te.ratingservice.entity.Rating;

public interface RatingService {

	Rating addRating(RatingDto dto);

	List<Rating> getAllRatings();

	List<Rating> getRatingByUserId(String userId);

	List<Rating> getRatingByHotelId(String hotelId);
}
