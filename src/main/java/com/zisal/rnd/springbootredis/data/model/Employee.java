package com.zisal.rnd.springbootredis.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Getter
@Setter
@Entity
@Table
public class Employee implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6375330072166343103L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "status")
    private Boolean status;
}
