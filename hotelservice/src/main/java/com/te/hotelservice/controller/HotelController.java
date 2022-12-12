package com.te.hotelservice.controller;

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

import com.te.hotelservice.entity.Hotel;
import com.te.hotelservice.hoteldto.HotelDto;
import com.te.hotelservice.responce.Responce;
import com.te.hotelservice.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	
	@Autowired
	private HotelService service;
	
	@PostMapping("/addHotel")
	public ResponseEntity<Responce> addHotel(@RequestBody HotelDto dto){
		Hotel hotel=service.addHotel(dto);
		return new ResponseEntity<Responce>(new Responce(false, "Hotel Added Succesfully", hotel),HttpStatus.OK);
	}
	
	@GetMapping("/getHotel/{id}")
	public ResponseEntity<Responce> getHotel(@PathVariable int id){
		Hotel hotel=service.getHotel(id);
		return new ResponseEntity<Responce>(new Responce(false, "Getting Hotel Succesfully", hotel),HttpStatus.OK);
	}
	
	@GetMapping("/getAllHotels")
	public ResponseEntity<Responce> getAllHotels(){
		List<Hotel> hotel=service.getAllHotels();
		return new ResponseEntity<Responce>(new Responce(false, "Getting All Hotel Details Succesfully", hotel),HttpStatus.OK);
	}
}
