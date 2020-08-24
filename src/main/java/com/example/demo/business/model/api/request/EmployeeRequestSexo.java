package com.example.demo.business.model.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EmployeeRequestSexo {

  @Pattern(regexp = "(M|F)")
  @NotBlank
  @Size(min = 1, max = 1)
  private String sexo;
}
