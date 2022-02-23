package com.example9.A.controller;

import java.time.LocalDateTime;

public class ProductIDInvalidException extends RuntimeException {
	private LocalDateTime datetime;
	private String path;
	private String type;

	public ProductIDInvalidException(LocalDateTime datetime, String path, String type) {
	super();
	this.datetime = datetime;
	this.path = path;
	this.type = type;
	}
	public LocalDateTime getDatetime() {
	return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
	this.datetime = datetime;
	}
	public String getPath() {
	return path;
	}
	public void setPath(String path) {
	this.path = path;
	}
	public String getType() {
	return type;
	}
	public void setType(String type) {
	this.type = type;
	}

}
