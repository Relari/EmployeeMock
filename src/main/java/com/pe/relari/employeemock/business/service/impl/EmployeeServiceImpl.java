package com.pe.relari.employeemock.business.service.impl;

import com.pe.relari.employeemock.business.dao.EmployeeDao;
import com.pe.relari.employeemock.business.model.domain.Employee;
import com.pe.relari.employeemock.business.service.EmployeeService;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeDao employeeDao;

  @Override
  public void save(Employee employee) {
    employeeDao.save(employee);
  }

  @Override
  public List<Employee> findAll() {
    return employeeDao.findAll();
  }

  @Override
  public Employee findById(Integer id) {
    return employeeDao.findById(id);
  }

  @Override
  public List<Employee> findByStatus(Boolean status) {
    return employeeDao.findByStatus(status);
  }

  @Override
  public List<Employee> findBySex(String sex) {
    return employeeDao.findBySex(sex);
  }
}
