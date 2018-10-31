package com.zisal.rnd.springbootredis.dao.entity;

import com.zisal.rnd.springbootredis.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IEmployeeDAO extends JpaRepository<Employee, Integer> {
}
