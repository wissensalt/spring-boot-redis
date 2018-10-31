package com.zisal.rnd.springbootredis.dao.redis;

import com.zisal.rnd.springbootredis.data.dto.EmployeeDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Repository
public interface IEmployeeRedisDAO extends CrudRepository<EmployeeDTO, Integer> {
}
