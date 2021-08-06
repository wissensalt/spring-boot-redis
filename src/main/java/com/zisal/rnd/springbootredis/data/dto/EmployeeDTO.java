package com.zisal.rnd.springbootredis.data.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RedisHash("employee")
@Getter
@Setter
public class EmployeeDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 8831404359805237177L;
    private Integer id;
    private String code;
    private String name;
    private String remarks;
    private Boolean status;

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", remarks='" + remarks + '\'' +
                ", status=" + status +
                '}';
    }
}
