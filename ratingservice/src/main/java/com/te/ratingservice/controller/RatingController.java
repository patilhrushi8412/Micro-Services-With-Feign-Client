package com.te.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.ratingservice.dto.RatingDto;
import com.te.ratingservice.entity.Rating;
import com.te.ratingservice.responce.Responce;
import com.te.ratingservice.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired 
	private RatingService service;
	
	@PostMapping("/addRating")
	public ResponseEntity<Responce> addRating(@RequestBody RatingDto dto){
		Rating rating=service.addRating(dto);
		return new ResponseEntity<Responce>(new Responce(false, "Rating Added Successfully", rating),HttpStatus.OK);
	}
	
	@GetMapping("/getRatingsWithUserId/{userId}")
	public ResponseEntity<Responce> getRating(@PathVariable String userId){
		List<Rating> rating=service.getRatingByUserId(userId);
		return new ResponseEntity<Responce>(new Responce(false, "All Rating Details Using UserId", rating),HttpStatus.OK);
	}
	
	@GetMapping("/getAllRatings")
	public ResponseEntity<Responce> getAllRatings(){
		List<Rating> rating=service.getAllRatings();
		return new ResponseEntity<Responce>(new Responce(false, "Getting All Ratings", rating),HttpStatus.OK);
	}
	
	@GetMapping("/getRatingsWithHotelId/{hotelId}")
	public ResponseEntity<Responce> getRatingsWithHotelId(@PathVariable String hotelId){
		List<Rating> rating=service.getRatingByHotelId(hotelId);
		return new ResponseEntity<Responce>(new Responce(false, "All Rating Details Using HotelId", rating),HttpStatus.OK);
	}
	
}
