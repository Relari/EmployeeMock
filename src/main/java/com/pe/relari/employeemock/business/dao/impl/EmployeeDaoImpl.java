package com.pe.relari.employeemock.business.dao.impl;

import com.pe.relari.employeemock.business.dao.EmployeeDao;
import com.pe.relari.employeemock.business.dao.repository.EmployeeRepository;
import com.pe.relari.employeemock.business.exception.ErrorCategory;
import com.pe.relari.employeemock.business.exception.ExceptionFactory;
import com.pe.relari.employeemock.business.model.domain.Employee;
import com.pe.relari.employeemock.business.model.entity.EmployeeEntity;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
class EmployeeDaoImpl implements EmployeeDao {

  private final EmployeeRepository employeeRepository;

  @Override
  public void save(Employee employee) throws IOException {

    log.debug("Registering the employee.");
    EmployeeEntity employeeEntity = mapEmployeeEntity(employee);

    log.trace(employeeEntity.toString());
    boolean response = employeeRepository.save(employeeEntity)
            .execute()
            .isSuccessful();

    if (response) { log.info("Registered Employee. [{}]", true); }

  }

  private EmployeeEntity mapEmployeeEntity(Employee employee) {
    return EmployeeEntity.builder()
            .name(employee.getName())
            .position(employee.getPosition())
            .salary(employee.getSalary())
            .sex(employee.getSex())
            .status(employee.getStatus())
            .build();
  }

  @Override
  public List<Employee> findAll() throws IOException {

    log.debug("List all employees.");

    return Objects.requireNonNull(employeeRepository.findAll().execute().body()).stream()
            .map(this::mapEmployee)
            .peek(employee -> log.trace(employee.toString()))
            .collect(Collectors.toList());
  }

  @Override
  public Employee findById(String id) {

    log.debug("Search for the employee with the id = [{}]", id);

    return employeeRepository.findById(id)
            .map(this::mapEmployee)
            .orElseThrow(() -> ExceptionFactory.builder()
                    .category(ErrorCategory.NOT_FOUND)
                    .message("Error search id")
                    .build()
                    .getException());
  }

  @Override
  public List<Employee> findByStatus(Boolean status) {

    log.debug("Search for the employee with the status = [{}]", status);

    return employeeRepository.findByStatus(status).stream()
            .map(this::mapEmployee)
            .peek(employee -> log.trace(employee.toString()))
            .collect(Collectors.toList());
  }

  @Override
  public List<Employee> findBySex(String sex) {

    log.debug("Search for the employee with the sex = [{}]", sex);

    return employeeRepository.findBySex(sex).stream()
            .map(this::mapEmployee)
            .peek(employee -> log.trace(employee.toString()))
            .collect(Collectors.toList());
  }

  private Employee mapEmployee(EmployeeEntity employeeEntity) {
    return Employee.builder()
            .position(employeeEntity.getPosition())
            .status(employeeEntity.getStatus())
            .name(employeeEntity.getName())
            .sex(employeeEntity.getSex())
            .salary(employeeEntity.getSalary())
            .build();
  }
}
