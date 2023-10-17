package com.masai.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;








@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myException(Exception se , WebRequest req){

		MyErrorDetails med = new MyErrorDetails();
        med.setMessage(se.getMessage());
        med.setDescription(req.getDescription(false));

        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;

    }
	
	@ExceptionHandler(NoHandlerFoundException.class)
	 public ResponseEntity<MyErrorDetails> NoHandlerFound(NoHandlerFoundException se , WebRequest req){

		MyErrorDetails med = new MyErrorDetails();
        med.setMessage(se.getMessage());
        med.setDescription(req.getDescription(false));

        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;
    }
	
	@ExceptionHandler(HostarException.class)
	public ResponseEntity<MyErrorDetails> hotstarException(HostarException se,WebRequest req)
	{
		MyErrorDetails med=new MyErrorDetails();
		med.setMessage(se.getMessage());
		med.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(med,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorDetails> NotFoundException(NotFoundException  se,WebRequest req)
	{
		MyErrorDetails med=new MyErrorDetails(se.getMessage(), LocalDateTime.now()  , req.getDescription(false));
		return new ResponseEntity<>(med,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<MyErrorDetails> InvalidException(InvalidDataException se,WebRequest req)
	{
		MyErrorDetails med=new MyErrorDetails(se.getMessage(), LocalDateTime.now()  , req.getDescription(false));
		return new ResponseEntity<>(med,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> handleException(MethodArgumentNotValidException ex){
		//Create an object of MyErrorEntity
		MyErrorDetails entity = new MyErrorDetails();
		entity.setTimeStamp(LocalDateTime.now());
		entity.setMessage("Validation Failed");
		
		//List of all error object is here
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		
		//List of all error messages is here
		List<String> errorMessages = MethodArgumentNotValidException.errorsToStringList(allErrors);
		
		//set the details here
		entity.setDescription(String.join(", ", errorMessages));
		return new ResponseEntity<MyErrorDetails>(entity, HttpStatus.BAD_REQUEST);
		
	}

}
