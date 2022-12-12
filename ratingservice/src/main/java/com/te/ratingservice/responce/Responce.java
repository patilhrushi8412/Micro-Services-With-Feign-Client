package com.te.ratingservice.responce;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Responce {

	private boolean error;
	private String message;
	private Object data;
}
