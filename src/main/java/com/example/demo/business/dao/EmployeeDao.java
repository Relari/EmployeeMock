package com.example.demo.business.dao;

import com.example.demo.business.model.dto.Employee;
import com.example.demo.business.model.entity.EmployeeEntity;

import java.io.IOException;
import java.util.List;

public interface EmployeeDao {

  List<Employee> findAll() throws IOException;

  Employee findById(Integer id) throws IOException;

  List<Employee> findByEstado(Boolean estado) throws IOException;

  List<Employee> findBySexo(String sexo) throws IOException;

}
