package com.example.taskl22.mapper;

import com.example.taskl22.dao.entity.StudentEntity;
import com.example.taskl22.model.response.PageableResponse;
import org.springframework.data.domain.Page;

import java.util.function.Function;

import static com.example.taskl22.mapper.StudentMapper.STUDENT_MAPPER;

public enum PageableMapper {
    PAGEABLE_MAPPER;

    public <T, E> PageableResponse<T> mapPageToPageableResponse(Page<E> pageRequest, Function<E, T> mapper){
       return PageableResponse.<T>builder()
                .content(pageRequest.getContent().stream().map(mapper).toList())
                .totalElements(pageRequest.getTotalElements())
                .lastPageNumber(pageRequest.getTotalPages())
                .hasNextPage(pageRequest.hasNext())
                .build();
    }
}
