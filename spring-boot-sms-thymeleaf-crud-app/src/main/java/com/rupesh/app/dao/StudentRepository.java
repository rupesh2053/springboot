package com.rupesh.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rupesh.app.beans.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
