package com.example.demo.business.dao.impl;

import com.example.demo.business.dao.EmployeeDao;
import com.example.demo.business.dao.repository.EmployeeRepository;
import com.example.demo.business.model.dto.Employee;
import com.example.demo.business.model.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> findAll() throws IOException {
    return employeeRepository.findAll().stream()
            .map(this::employee)
            .collect(Collectors.toList());
  }

  @Override
  public Employee findById(Integer id) throws IOException {
    return employeeRepository.findById(id)
            .map(this::employee)
            .get();
  }

  @Override
  public List<Employee> findByEstado(Boolean estado) throws IOException {
    return employeeRepository.findByEstado(estado).stream()
            .map(this::employee)
            .collect(Collectors.toList());
  }

  @Override
  public List<Employee> findBySexo(String sexo) throws IOException {
    return employeeRepository.findBySexo(sexo).stream()
            .map(this::employee)
            .collect(Collectors.toList());
  }

  private Employee employee(EmployeeEntity employeeEntity) {
    return Employee.builder()
            .cargo(employeeEntity.getCargo())
            .estado(employeeEntity.getEstado())
            .id(employeeEntity.getId())
            .nombre(employeeEntity.getNombre())
            .sexo(employeeEntity.getSexo())
            .sueldo(employeeEntity.getSueldo())
            .build();
  }
}
