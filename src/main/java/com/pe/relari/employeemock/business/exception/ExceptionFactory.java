package com.pe.relari.employeemock.business.exception;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionFactory {

  private static final String NOT_FOUND = "NOT_FOUND";

  private String message;
  private Throwable throwable;
  private ErrorCategory category;

  public RuntimeException getException() {
    if (NOT_FOUND.equals(category.name())) {

      if (Objects.isNull(throwable)) {
        return new EmployeeNotFoundException(message);
      }
      return new EmployeeNotFoundException(message, throwable);

    } else {

      if (Objects.isNull(throwable)) {
        return new RuntimeException(message);
      }
      return new RuntimeException(message, throwable);

    }

  }

}
