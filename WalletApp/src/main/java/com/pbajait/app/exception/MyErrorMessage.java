package com.pbajait.app.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyErrorMessage {
	
	private LocalDateTime localDateTime;
	
	private String message;
	
	private String detailString;
}
