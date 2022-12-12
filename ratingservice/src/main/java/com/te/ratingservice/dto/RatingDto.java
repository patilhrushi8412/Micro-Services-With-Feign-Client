package com.te.ratingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {

	private String ratingId;
	private String userId;
	private int rating;
	private String feedback;
}
