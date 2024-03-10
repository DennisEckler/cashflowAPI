package dev.eckler.cashflow.model.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException{

  public CategoryNotFoundException(String message){
    System.out.println(message);
  }
}
