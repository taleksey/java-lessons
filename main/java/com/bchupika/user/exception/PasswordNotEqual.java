package com.bchupika.user.exception;

public class PasswordNotEqual extends RuntimeException {
  public PasswordNotEqual(String message) {
    super(message);
  }
}
