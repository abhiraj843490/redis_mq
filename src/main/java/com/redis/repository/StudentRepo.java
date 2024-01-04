package com.redis.repository;

import com.redis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {
    public static final String HASH_KEY = "Student";
    @Autowired
    private RedisTemplate template;

    public Student save(Student student){
        template.opsForHash().put(HASH_KEY,student.getId(),student);
        return student;
    }

    public List<Student> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Student findStudentById(Long id){
        return (Student) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteStudent(Long id){
        template.opsForHash().delete(HASH_KEY,id);
        return "student removed !!";
    }
}
