package com.pe.relari.employeemock.business.dao.repository;

import com.pe.relari.employeemock.business.model.entity.EmployeeEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
class EmployeeRepositoryImpl implements EmployeeRepository {

  @Override
  public void save(EmployeeEntity employeeEntity) {
  }

  @Override
  public List<EmployeeEntity> findAll() {
    return employeeEntities();
  }

  @Override
  public Optional<EmployeeEntity> findById(Integer id) {
    return employeeEntities().stream()
            .filter(employeeEntity -> employeeEntity.getId().equals(id))
            .findFirst();
  }

  @Override
  public List<EmployeeEntity> findByStatus(Boolean status) {
    return employeeEntities().stream()
            .filter(employeeEntity -> employeeEntity.getStatus().equals(status))
            .collect(Collectors.toList());
  }

  @Override
  public List<EmployeeEntity> findBySex(String sex) {
    return employeeEntities().stream()
          .filter(employeeEntity -> employeeEntity.getSex().equals(sex))
          .collect(Collectors.toList());
  }

  public List<EmployeeEntity> employeeEntities() {

    List<EmployeeEntity> employees = new ArrayList<>();

    employees.add(new EmployeeEntity(1, "Daniel", "Asistente",1809.00,"M", true));
    employees.add(new EmployeeEntity(2, "Maria", "Analista", 2403.00, "F", true));
    employees.add(new EmployeeEntity(3, "Juan", "Gerente", 3452.00, "M", false));
    employees.add(new EmployeeEntity(4, "Esther", "Asistente", 3168.00, "F", false));
    employees.add(new EmployeeEntity(5, "Luis", "Analista", 2921.00, "M", true));
    employees.add(new EmployeeEntity(6, "Stephany", "Gerente", 3773.00, "F", false));
    employees.add(new EmployeeEntity(7, "Lucho", "Gerente", 3078.00, "M", false));
    employees.add(new EmployeeEntity(8, "Talia", "Analista", 2510.00, "F", true));
    employees.add(new EmployeeEntity(9, "Alexander", "Gerente", 3860.00, "M", true));
    employees.add(new EmployeeEntity(10, "Lucero", "Gerente", 3948.00, "F", false));

    return employees;
  }
}
