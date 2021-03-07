package com.pe.relari.employeemock.business.model.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeRequest {

  private static final String ONLY_LETTER = "[A-Z][a-z]*";

  @NotBlank
  @Pattern(regexp = ONLY_LETTER)
  private String name;

  @NotBlank
  @Pattern(regexp = ONLY_LETTER)
  private String position;

  @NotNull
  private Double salary;

  @NotBlank
  @Pattern(regexp = "(M|F)")
  private String sex;

}
