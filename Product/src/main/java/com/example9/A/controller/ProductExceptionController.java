package com.example9.A.controller;



import java.time.LocalDateTime;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.fasterxml.jackson.annotation.JsonFormat;



class ProductExceptionFields {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime datetime;
	private String path;
	private String type;
	public ProductExceptionFields(LocalDateTime datetime, String path, String type) {
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



@ControllerAdvice
public class ProductExceptionController {
	@ExceptionHandler(value = ProductIDInvalidException.class)
	public ResponseEntity<Object> exception(ProductIDInvalidException ex) {
		ProductExceptionFields more_details = new ProductExceptionFields(ex.getDatetime(),
			ex.getPath(), ex.getType());
		return new ResponseEntity<>(more_details, HttpStatus.NOT_FOUND);
	}
}