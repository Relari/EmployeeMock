package com.pe.relari.employeemock.controller;

import com.pe.relari.employeemock.business.model.api.EmployeeRequest;
import com.pe.relari.employeemock.business.model.api.EmployeeResponse;
import com.pe.relari.employeemock.business.model.domain.Employee;
import com.pe.relari.employeemock.business.service.EmployeeService;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

@Validated
@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
class EmployeeController {

  private final EmployeeService employeeService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody @Valid EmployeeRequest employeeRequest) {
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

  @GetMapping
  public List<EmployeeResponse> findAll() {
    return employeeService.findAll().stream()
            .map(this::mapEmployeeResponse)
            .collect(Collectors.toList());
  }

  @GetMapping(path = "/{id}")
  public EmployeeResponse findById(@PathVariable(name = "id") Integer id) {
    return mapEmployeeResponse(employeeService.findById(id));
  }

  @GetMapping(path = "/search/sex")
  public List<EmployeeResponse> findBySex(
          @RequestParam(name = "sex")
          @Pattern(regexp = "(M|F)")
          @Size(min = 1, max = 1)
          @NotBlank String sex) {

    return employeeService.findBySex(sex).stream()
            .map(this::mapEmployeeResponse)
            .collect(Collectors.toList());
  }

  @GetMapping(path = "/search/status")
  public List<EmployeeResponse> findByStatus(
          @RequestParam(name = "status")
          @Pattern(regexp = "(true|false)")
          @NotBlank String status) {

    return employeeService.findByStatus(Boolean.valueOf(status)).stream()
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
