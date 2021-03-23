package com.pe.relari.employeemock.controller;

import com.pe.relari.employeemock.business.model.api.EmployeeRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Slf4j
@Controller
@AllArgsConstructor
public class EmployeeView {

  private final EmployeeController controller;

  @GetMapping(path = "/employees")
  public void employees(Model model) throws IOException {

    model.addAttribute("employee", new EmployeeRequest());
    model.addAttribute("employees", controller.findAll());

  }

  @GetMapping(path = "/register")
  public void showForm(Model model) {

    model.addAttribute("employee", new EmployeeRequest());

  }

  @PostMapping(path = "/register")
  public void create(@ModelAttribute("employee") EmployeeRequest request) throws IOException {

    log.trace(request.toString());
    controller.save(request);

  }

}

