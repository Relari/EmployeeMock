package com.pe.relari.employeemock.controller;

import com.pe.relari.employeemock.business.model.api.EmployeeRequest;
import com.pe.relari.employeemock.business.model.api.EmployeeResponse;
import com.pe.relari.employeemock.business.model.domain.Employee;
import com.pe.relari.employeemock.business.service.EmployeeService;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class EmployeeController {

  private final EmployeeService employeeService;

  public void save(EmployeeRequest employeeRequest) throws IOException {
    employeeService.save(mapEmployee(employeeRequest));
  }

  private Employee mapEmployee(EmployeeRequest employeeRequest) {
    return Employee.builder()
            .position(employeeRequest.getPosition())
            .status(Boolean.TRUE)
            .name(employeeRequest.getName())
            .sex(employeeRequest.getSex())
            .salary(employeeRequest.getSalary())
            .build();
  }

  public List<EmployeeResponse> findAll() throws IOException {
    return employeeService.findAll().stream()
            .map(this::mapEmployeeResponse)
            .collect(Collectors.toList());
  }

  public EmployeeResponse findById(String id) {
    return mapEmployeeResponse(employeeService.findById(id));
  }

  public List<EmployeeResponse> findBySex(String sex) {

    return employeeService.findBySex(sex).stream()
            .map(this::mapEmployeeResponse)
            .collect(Collectors.toList());
  }

  public List<EmployeeResponse> findByStatus(Boolean status) {

    return employeeService.findByStatus(status).stream()
            .map(this::mapEmployeeResponse)
            .collect(Collectors.toList());
  }

  private EmployeeResponse mapEmployeeResponse(Employee employee) {
    return EmployeeResponse.builder()
            .position(employee.getPosition())
            .status(employee.getStatus())
            .name(employee.getName())
            .sex(employee.getSex())
            .salary(employee.getSalary())
            .build();
  }
}
