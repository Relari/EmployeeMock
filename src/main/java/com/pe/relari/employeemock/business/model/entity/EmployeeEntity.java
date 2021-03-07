package com.pe.relari.employeemock.business.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

  private Integer id;
  private String name;
  private String position;
  private Double salary;
  private String sex;
  private Boolean status;

}
