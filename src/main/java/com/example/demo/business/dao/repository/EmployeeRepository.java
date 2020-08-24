package com.example.demo.business.dao.repository;

import com.example.demo.business.model.entity.EmployeeEntity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

  List<EmployeeEntity> findAll() throws IOException;

  Optional<EmployeeEntity> findById(Integer id) throws IOException;

  List<EmployeeEntity> findByEstado(Boolean estado) throws IOException;

  List<EmployeeEntity> findBySexo(String sexo) throws IOException;
}
