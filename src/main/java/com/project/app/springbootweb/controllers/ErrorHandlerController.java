package com.project.app.springbootweb.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {
  @ExceptionHandler(ArithmeticException.class)
  public String customArithmeticException(Exception ex, Model model) {
    model.addAttribute("error", "Arithmetic error");
    model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
    return "error/custom-arithmetic-exception";
  }
}
