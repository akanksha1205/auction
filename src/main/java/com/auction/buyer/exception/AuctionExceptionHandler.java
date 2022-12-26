package com.auction.buyer.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.auction.buyer.model.BidingResponse;


@RestControllerAdvice
public class AuctionExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<BidingResponse> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		BidingResponse bidingResponse = new BidingResponse();
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
		bidingResponse.setErrorMsg(errorMessage);
		return new ResponseEntity<BidingResponse>(bidingResponse, HttpStatus.BAD_REQUEST);
	}
}
