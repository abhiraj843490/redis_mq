package com.redis.controller;

import com.redis.entity.Student;

import com.redis.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CacheConfig(cacheNames = {"customer"})
public class StudentController {
        @Autowired
        private StudentRepo studentRepo;


        @PostMapping
        public Student save(@RequestBody Student student) {
            return studentRepo.save(student);
        }
        @Cacheable
        @GetMapping
        public List<Student> getAllStudent() {
            return studentRepo.findAll();
        }

        @GetMapping("/{id}")
        @Cacheable(key = "#id")
        public Student findStudent(@PathVariable Long id) {
            return studentRepo.findStudentById(id);
        }
        @DeleteMapping("/{id}")
        public String remove(@PathVariable Long id)   {
            return studentRepo.deleteStudent(id);
        }


}
