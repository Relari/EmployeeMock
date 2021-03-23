package com.pe.relari.employeemock.business.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Employee {

  private String id;
  private String name;
  private String position;
  private Double salary;
  private String sex;
  private Boolean status;

}
