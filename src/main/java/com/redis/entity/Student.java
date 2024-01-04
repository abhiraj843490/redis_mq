package com.redis.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Student_Redis")
public class Student implements Serializable {
        private static final long serialVersionUID = -4766643524298899209L;
        private Long id;
        private String name;
        private String degree;
        private String address;

}
