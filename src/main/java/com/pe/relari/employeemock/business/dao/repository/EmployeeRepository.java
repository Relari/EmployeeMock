package com.pe.relari.employeemock.business.dao.repository;

import com.pe.relari.employeemock.business.model.entity.EmployeeEntity;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

  void save(EmployeeEntity employeeEntity);

  List<EmployeeEntity> findAll();

  Optional<EmployeeEntity> findById(Integer id);

  List<EmployeeEntity> findByStatus(Boolean status);

  List<EmployeeEntity> findBySex(String sex);

}
