package com.satishlabs.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ErrorMessage {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timstamp;
	private int status;
	private String error;
	public LocalDateTime getTimstamp() {
		return timstamp;
	}
	public void setTimstamp(LocalDateTime timstamp) {
		this.timstamp = timstamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
