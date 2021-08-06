package com.zisal.rnd.springbootredis.service;

import com.zisal.rnd.springbootredis.converter.EmployeeConverter;
import com.zisal.rnd.springbootredis.dao.entity.IEmployeeDAO;
import com.zisal.rnd.springbootredis.dao.redis.IEmployeeRedisDAO;
import com.zisal.rnd.springbootredis.data.dto.EmployeeDTO;
import com.zisal.rnd.springbootredis.data.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDAO employeeDAO;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Autowired
    private IEmployeeRedisDAO employeeRedisDAO;

    @Override
    public EmployeeDTO insert(Employee employee) {
        employeeDAO.save(employee);
        return employeeRedisDAO.save(employeeConverter.convertModelToDTO(employee));
    }

    @Override
    public EmployeeDTO update(Employee employee, Integer id) {
        Employee e = employeeDAO.findById(id).get();
        e.setCode(employee.getCode());
        e.setName(employee.getName());
        e.setRemarks(employee.getRemarks());
        e.setStatus(employee.getStatus());
        employeeDAO.save(e);

        EmployeeDTO tempDTO = employeeConverter.convertModelToDTO(e);

        EmployeeDTO employeeDTO = employeeRedisDAO.findById(id).get();
        tempDTO.setId(employeeDTO.getId());

        return employeeRedisDAO.save(employeeDTO);
    }

    @Override
    public void delete(Integer id) {
        employeeDAO.deleteById(id);

        employeeRedisDAO.deleteById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public EmployeeDTO findById(Integer id) {
        log.info("retrieve from DB");
        return employeeConverter.convertModelToDTO(employeeDAO.findById(id).get());
    }

    @Override
    public List<EmployeeDTO> findAllRedis() {
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        employeeRedisDAO.findAll().forEach(employeeDTOs::add);

        return employeeDTOs;
    }
}
