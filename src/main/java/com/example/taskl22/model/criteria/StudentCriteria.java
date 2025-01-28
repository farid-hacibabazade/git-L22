package com.example.taskl22.model.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCriteria {
    private String name;
    private Integer ageFrom;
    private Integer ageTo;
    private String className;
}
