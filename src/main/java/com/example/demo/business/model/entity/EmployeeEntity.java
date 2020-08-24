package com.example.demo.business.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeEntity {

  private Integer id;
  private String nombre;
  private String cargo;
  private Double sueldo;
  private String sexo;
  private Boolean estado;
}
