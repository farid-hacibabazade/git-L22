package com.example.taskl22.service;

import com.example.taskl22.dao.repository.StudentRepository;
import com.example.taskl22.mapper.StudentMapper;
import com.example.taskl22.model.criteria.PageCriteria;
import com.example.taskl22.model.criteria.StudentCriteria;
import com.example.taskl22.model.response.PageableResponse;
import com.example.taskl22.model.response.StudentResponse;
import com.example.taskl22.service.specification.StudentSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static com.example.taskl22.mapper.PageableMapper.PAGEABLE_MAPPER;
import static com.example.taskl22.mapper.StudentMapper.STUDENT_MAPPER;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public PageableResponse<StudentResponse> getStudents(PageCriteria pageCriteria,
                                                         StudentCriteria studentCriteria) {
        var pageRequest = PageRequest.of(pageCriteria.getPage(), pageCriteria.getCount());
        var specification = new StudentSpecification(studentCriteria);
        var studentsPage = studentRepository.findAll(specification, pageRequest);
        return PAGEABLE_MAPPER.mapPageToPageableResponse(studentsPage, STUDENT_MAPPER::buildEntityToDto);
    }
}
