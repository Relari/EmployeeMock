package com.example.demo.business.dao.repository;

import com.example.demo.business.model.entity.EmployeeEntity;
import com.google.gson.Gson;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

  @Override
  public List<EmployeeEntity> findAll() throws IOException {
    return employees();
  }

  @Override
  public Optional<EmployeeEntity> findById(Integer id) throws IOException {
    return Optional.of(employees().get(0));
  }

  @Override
  public List<EmployeeEntity> findByEstado(Boolean estado) throws IOException {
    return employees().stream()
            .filter(employeeEntity -> employeeEntity.getEstado().equals(estado))
            .collect(Collectors.toList());
  }

  @Override
  public List<EmployeeEntity> findBySexo(String sexo) throws IOException {
    return employees().stream()
          .filter(employeeEntity -> employeeEntity.getSexo().equals(sexo))
          .collect(Collectors.toList());
  }

  private List<EmployeeEntity> employees() throws IOException {
    File resource = new ClassPathResource("employees.json").getFile();

    String employeesJson = new String(Files.readAllBytes(resource.toPath()));

    Gson gson = new Gson();

    EmployeeEntity[] employees = gson.fromJson(employeesJson, EmployeeEntity[].class);

    return Arrays.asList(employees);
  }
}
