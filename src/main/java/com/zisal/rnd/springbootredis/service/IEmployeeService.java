package com.zisal.rnd.springbootredis.service;

import com.zisal.rnd.springbootredis.data.dto.EmployeeDTO;
import com.zisal.rnd.springbootredis.data.model.Employee;

import java.util.List;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IEmployeeService {

    EmployeeDTO insert(Employee employee);

    EmployeeDTO update(Employee employee, Integer id);

    void delete(Integer id);

    List<Employee> findAll();

    EmployeeDTO findById(Integer id);

    List<EmployeeDTO> findAllRedis();
}
