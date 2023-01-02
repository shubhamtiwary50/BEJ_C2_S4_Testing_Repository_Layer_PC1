package com.niit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "customer with the provided id is already present/registered")
public class CustomerAlreadyExistsException extends Exception{
}
