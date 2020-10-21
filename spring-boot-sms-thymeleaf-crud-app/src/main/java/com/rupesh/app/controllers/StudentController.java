package com.rupesh.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.rupesh.app.beans.Student;
import com.rupesh.app.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("listStudent", studentService.getAllStudent());
		return "index";
	}

	@GetMapping("/register")
	public String saveForm(Model model) {
		model.addAttribute("student", new Student());
		return "add-student-form";
	}

	@PostMapping("/addStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		this.studentService.saveStudent(student);
		return "redirect:/";
	}

	@GetMapping("/showUpdateForm/{id}")
	public String updateForm(@PathVariable(value = "id") int id, Model model) {
		Student studentFromDb = studentService.getStudentById(id);
		model.addAttribute("student", studentFromDb);
		return "update-form";
	}

	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value = "id") int id) {
		this.studentService.deleteStudent(id);
		return "redirect:/";
	}

}
