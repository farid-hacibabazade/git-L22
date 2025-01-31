package com.example.taskl22.mapper;

import com.example.taskl22.dao.entity.StudentEntity;
import com.example.taskl22.model.response.StudentResponse;

public enum StudentMapper {
    STUDENT_MAPPER;

    public StudentResponse buildEntityToDto (StudentEntity studentEntity){
        return StudentResponse.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .age(studentEntity.getAge())
                .className(studentEntity.getClassName())
                .build();
    }
}
