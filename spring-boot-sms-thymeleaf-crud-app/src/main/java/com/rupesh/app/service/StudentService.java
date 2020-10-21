package com.rupesh.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rupesh.app.beans.Student;
import com.rupesh.app.dao.StudentRepository;
import java.util.Optional;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Iterable<Student> createStudents(Iterable<Student> students) {
		return studentRepository.saveAll(students);
	}

	public Iterable<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public void saveStudent(Student student) {
		this.studentRepository.save(student);
	}

	public Student getStudentById(int studentId) {
		Optional<Student> optional = studentRepository.findById(studentId);
		Student student = null;
		if (optional.isPresent()) {
			student = optional.get();
		}else {
			throw new RuntimeException("Student not found with id = "+studentId);
		}
		return student;
	}
	
	public void deleteStudent(int id) {
		this.studentRepository.deleteById(id);
	}
	
}
