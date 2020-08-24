package com.example.demo.controller;

import com.example.demo.business.model.api.response.EmployeeResponse;
import com.example.demo.business.model.dto.Employee;
import com.example.demo.business.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping(path = "/employees")
@AllArgsConstructor
public class EmployeeController {

  private EmployeeService employeeService;

  @GetMapping(path = "")
  public List<EmployeeResponse> findAll() throws IOException {
    return employeeService.findAll().stream()
            .map(this::employeeResponse)
            .collect(Collectors.toList());
  }

  @GetMapping(path = "/{id}")
  public EmployeeResponse findById(@PathVariable(name = "id") Integer id) throws IOException {
    return employeeResponse(employeeService.findById(id));
  }

  @GetMapping(path = "/searchSexo")
  public List<EmployeeResponse> findBySexo(
          @RequestParam(name = "sexo")
          @Pattern(regexp = "(M|F)")
          @Size(min = 1, max = 1)
          @NotBlank String sexo) throws IOException {

    return employeeService.findBySexo(sexo).stream()
            .map(this::employeeResponse)
            .collect(Collectors.toList());
  }

  @GetMapping(path = "/searchEstado")
  public List<EmployeeResponse> findByEstado(
          @RequestParam(name = "estado")
          @Pattern(regexp = "(true|false)")
          @NotBlank String estado) throws IOException {

    return employeeService.findByEstado(Boolean.valueOf(estado)).stream()
            .map(this::employeeResponse)
            .collect(Collectors.toList());
  }

  private EmployeeResponse employeeResponse(Employee employee) {
    return EmployeeResponse.builder()
            .cargo(employee.getCargo())
            .estado(employee.getEstado())
            .id(employee.getId())
            .nombre(employee.getNombre())
            .sexo(employee.getSexo())
            .sueldo(employee.getSueldo())
            .build();
  }
}
