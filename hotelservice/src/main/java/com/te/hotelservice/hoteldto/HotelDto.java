package com.te.hotelservice.hoteldto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {

	private String hotelName;
	private String location;
	private String about;
}
