package com.example.demo.business.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Employee {

  private Integer id;
  private String nombre;
  private String cargo;
  private Double sueldo;
  private String sexo;
  private Boolean estado;
}
