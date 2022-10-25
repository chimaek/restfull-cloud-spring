package net.chimaek.restful_msa.exception;

import java.time.LocalDateTime;
import java.util.Date;
import net.chimaek.restful_msa.user.controller.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
    Hang  exception = new Hang(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

    return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public final ResponseEntity<Object> handleUserNotFoundException(Exception ex,WebRequest webRequest){
    Hang  exception = new Hang(LocalDateTime.now(), ex.getMessage(), webRequest.getDescription(false));

    return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
  }
}
