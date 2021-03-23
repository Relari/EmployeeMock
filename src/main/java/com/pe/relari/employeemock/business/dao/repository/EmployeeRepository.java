package com.pe.relari.employeemock.business.dao.repository;

import com.pe.relari.employeemock.business.model.entity.EmployeeEntity;
import java.util.List;
import java.util.Optional;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EmployeeRepository {

  @POST("business/firebase/v1/employees")
  Call<Void> save(@Body EmployeeEntity employeeEntity);

  @GET("business/firebase/v1/employees")
  Call<List<EmployeeEntity>> findAll();

  Optional<EmployeeEntity> findById(String id);

  List<EmployeeEntity> findByStatus(Boolean status);

  List<EmployeeEntity> findBySex(String sex);

}
