package com.pe.relari.employeemock.business.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class EmployeeResponse {

  private String name;
  private String position;
  private Double salary;
  private String sex;
  private Boolean status;

}
