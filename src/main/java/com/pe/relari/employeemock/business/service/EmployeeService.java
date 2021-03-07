package com.pe.relari.employeemock.business.service;

import com.pe.relari.employeemock.business.model.domain.Employee;
import java.util.List;

public interface EmployeeService {

  void save(Employee employee);

  List<Employee> findAll();

  Employee findById(Integer id);

  List<Employee> findByStatus(Boolean status);

  List<Employee> findBySex(String sex);

}
