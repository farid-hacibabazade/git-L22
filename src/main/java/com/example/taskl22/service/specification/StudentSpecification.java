package com.example.taskl22.service.specification;

import com.example.taskl22.dao.entity.StudentEntity;
import com.example.taskl22.dao.entity.StudentEntity.Fields;
import com.example.taskl22.model.criteria.StudentCriteria;
import com.example.taskl22.util.PredicateUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Locale;


public record StudentSpecification(StudentCriteria studentCriteria) implements Specification<StudentEntity> {


    @Override
    public Predicate toPredicate(Root<StudentEntity> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder cb) {

        var predicates = PredicateUtil.builder()
                .addNullSafety(
                        studentCriteria.getName(),
                        name -> cb.like(
                                cb.lower(root.get(Fields.name)),
                                applyLikePattern(name))
                )
                .addNullSafety(
                        studentCriteria.getAgeFrom(),
                        ageFrom -> cb.greaterThanOrEqualTo(root.get(Fields.age),
                                ageFrom)
                )
                .addNullSafety(studentCriteria.getAgeTo(),
                        ageTo -> cb.lessThanOrEqualTo(root.get(Fields.age),
                                ageTo))
                .addNullSafety(studentCriteria.getClassName(),
                        clasName -> cb.equal(root.get(Fields.className),
                                clasName))
                .build();
        return cb.and(predicates);
    }

    private String applyLikePattern(String data) {
        return "%" + data.toLowerCase() + "%";
    }
}
