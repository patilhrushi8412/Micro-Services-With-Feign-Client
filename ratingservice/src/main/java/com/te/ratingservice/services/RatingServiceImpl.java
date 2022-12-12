package com.te.ratingservice.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ratingservice.customexception.CustomException;
import com.te.ratingservice.dto.RatingDto;
import com.te.ratingservice.entity.Rating;
import com.te.ratingservice.repository.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepo repo;

	@Override
	public Rating addRating(RatingDto dto) {
		try {
			if (dto == null) {
				throw new CustomException("SomeThing Went Wrong");
			} else {
				Rating rating = new Rating();
				BeanUtils.copyProperties(dto, rating);
				String ratingId = UUID.randomUUID().toString();
				rating.setRatingId(ratingId);
				return repo.save(rating);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Rating> getAllRatings() {
		try {
			List<Rating> findAll = repo.findAll();
			if (findAll.isEmpty()) {
				throw new CustomException("No Any Ratings In System");
			} else {
				return findAll;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		try {
			List<Rating> ratings = repo.findAllByUserId(userId);
			if (ratings.isEmpty()) {
				throw new CustomException("No Ratings In System");
			} else {
				return ratings;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		try {
			List<Rating> rating = repo.findAllByHotelId(hotelId);
			if (rating.isEmpty()) {
				throw new CustomException("No Ratings In System");
			} else {
				return rating;
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
