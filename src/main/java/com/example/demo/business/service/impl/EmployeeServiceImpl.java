package com.example.demo.business.service.impl;

import com.example.demo.business.dao.EmployeeDao;
import com.example.demo.business.model.dto.Employee;
import com.example.demo.business.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeDao employeeDao;

  @Override
  public List<Employee> findAll() throws IOException {
    return employeeDao.findAll();
  }

  @Override
  public Employee findById(Integer id) throws IOException {
    return employeeDao.findById(id);
  }

  @Override
  public List<Employee> findByEstado(Boolean estado) throws IOException {
    return employeeDao.findByEstado(estado);
  }

  @Override
  public List<Employee> findBySexo(String sexo) throws IOException {
    return employeeDao.findBySexo(sexo);
  }
}
