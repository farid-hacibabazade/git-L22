package com.example.taskl22.controller;

import com.example.taskl22.model.criteria.PageCriteria;
import com.example.taskl22.model.criteria.StudentCriteria;
import com.example.taskl22.model.response.PageableResponse;
import com.example.taskl22.model.response.StudentResponse;
import com.example.taskl22.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public PageableResponse<StudentResponse> getStudents(PageCriteria pageCriteria,
                                                         StudentCriteria studentCriteria){
        return studentService.getStudents(pageCriteria, studentCriteria);
    }
}
