package com.zisal.rnd.springbootredis.converter;

import com.zisal.rnd.springbootredis.data.dto.EmployeeDTO;
import com.zisal.rnd.springbootredis.data.model.Employee;
import org.springframework.stereotype.Service;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class EmployeeConverter {

    public Employee convertDTOToModel(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setCode(employeeDTO.getCode());
        employee.setName(employeeDTO.getName());
        employee.setRemarks(employeeDTO.getRemarks());
        employee.setStatus(employeeDTO.getStatus());
        return employee;
    }

    public EmployeeDTO convertModelToDTO(Employee employee) {
        EmployeeDTO result = new EmployeeDTO();
        result.setId(employee.getId());
        result.setCode(employee.getCode());
        result.setName(employee.getName());
        result.setRemarks(employee.getRemarks());
        result.setStatus(employee.getStatus());
        return result;
    }
}
