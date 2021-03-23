package com.pe.relari.employeemock.config;

import com.pe.relari.employeemock.business.dao.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Lazy
@Configuration
public class RestConfiguration {

  @Value("${application.http-client.employee.base-url}")
  private String uri;

  private Retrofit retrofit() {
    return new Retrofit.Builder()
        .baseUrl(uri)
        .addConverterFactory(GsonConverterFactory.create())
        //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }

  @Bean
  public EmployeeRepository employeeRepository() {
    return retrofit().create(EmployeeRepository.class);
  }
}
