package ru.job4j.mapstuct.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.mapstuct.dto.StudentDto;
import ru.job4j.mapstuct.model.StudentEntity;

@Mapper
public interface StudentMapper {
    @Mapping(target = "className", source = "classVal")
    StudentDto getDtoFromEntity(StudentEntity student);

    @InheritInverseConfiguration
    StudentEntity getEntityFromDto(StudentDto studentDto);

    default StudentDto getDtoFromEntityCustom(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setName(studentEntity.getName());
        studentDto.setClassName(studentEntity.getClassVal());
        return studentDto;
    }
}
