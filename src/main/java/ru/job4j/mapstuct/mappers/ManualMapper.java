package ru.job4j.mapstuct.mappers;

import ru.job4j.mapstuct.dto.StudentDto;
import ru.job4j.mapstuct.model.StudentEntity;

public class ManualMapper {
    public StudentDto getDto(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setName(studentEntity.getName());
        studentDto.setClassName(studentEntity.getClassVal());
        return studentDto;
    }

    public StudentEntity getEntity(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDto.getId());
        studentEntity.setName(studentDto.getName());
        studentEntity.setClassVal(studentDto.getClassName());
        return studentEntity;
    }
}
