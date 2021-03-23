package com.pe.relari.employeemock.business.service;

import com.pe.relari.employeemock.business.model.domain.Employee;
import java.io.IOException;
import java.util.List;

public interface EmployeeService {

  void save(Employee employee) throws IOException;

  List<Employee> findAll() throws IOException;

  Employee findById(String id);

  List<Employee> findByStatus(Boolean status);

  List<Employee> findBySex(String sex);

}
