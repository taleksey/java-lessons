package com.learn.user.exception;

import java.sql.SQLException;

public class DataProcessingException extends RuntimeException {
  public DataProcessingException(String message, SQLException e) {
    super(message);
  }
}
