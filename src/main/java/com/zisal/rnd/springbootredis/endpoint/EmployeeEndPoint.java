package com.zisal.rnd.springbootredis.endpoint;

import com.zisal.rnd.springbootredis.converter.EmployeeConverter;
import com.zisal.rnd.springbootredis.data.dto.EmployeeDTO;
import com.zisal.rnd.springbootredis.data.model.Employee;
import com.zisal.rnd.springbootredis.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/employee")
public class EmployeeEndPoint {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeConverter employeeConverter;

    @GetMapping("/findAllDB")
    public List<Employee> findAllDB() {
        return employeeService.findAll();
    }

    @GetMapping("/findall")
    public List<EmployeeDTO> findAll() {
        List<Employee> employees = employeeService.findAll();
        List<EmployeeDTO> em = new ArrayList<>();
        for (Employee employee : employees) {
            em.add(employeeConverter.convertModelToDTO(employee));
        }
        return em;
    }

    @PostMapping("/insert")
    public EmployeeDTO insert(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeConverter.convertDTOToModel(employeeDTO);
        return employeeService.insert(employee);
    }

    @Cacheable(value = "employee", key = "#id")
    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable("id") Integer id) {
        return employeeService.findById(id);
    }

    @CacheEvict(value = "employee", allEntries=true)
    @DeleteMapping("/delete/{id}")
    public void delete(@RequestParam("id") Integer id) {
        employeeService.delete(id);
    }
}
