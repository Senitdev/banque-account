package net.paco.customerservice.handlerexception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class ExceptionCustomer  extends RuntimeException{
    public ExceptionCustomer(String message){
        super(message);
    }
}
