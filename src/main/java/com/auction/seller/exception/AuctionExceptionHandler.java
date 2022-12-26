package com.auction.seller.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.auction.seller.model.AddProductResponse;

@RestControllerAdvice
public class AuctionExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<AddProductResponse> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		AddProductResponse addProductResponse = new AddProductResponse();
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		String errorMessage = "";
		for(String s:resp.keySet()) {
			errorMessage = errorMessage + s+" : "+resp.get(s)+" ";
		}
		addProductResponse.setErrorMsg(errorMessage);
		return new ResponseEntity<AddProductResponse>(addProductResponse, HttpStatus.BAD_REQUEST);
	}
}
