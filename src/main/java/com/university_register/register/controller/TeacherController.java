package com.university_register.register.controller;

import com.university_register.register.converter.TeacherConverter;
import com.university_register.register.dto.TeacherDto;
import com.university_register.register.entity.Teacher;
import com.university_register.register.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherConverter teacherConverter;
    public TeacherController(TeacherService teacherService, TeacherConverter teacherConverter) {
        this.teacherService = teacherService;
        this.teacherConverter = teacherConverter;
    }

   @PostMapping
    public ResponseEntity<TeacherDto> save (@RequestBody  TeacherDto teacherDto){
       Teacher teacher = teacherConverter.toTeacher(teacherDto);
       Teacher savedTeacher = teacherService.save(teacher);
        TeacherDto responseTeacher = teacherConverter.toTeacherDto(savedTeacher);
        return ResponseEntity.ok(responseTeacher);
   }

   @GetMapping (value = "/{id}")
    public ResponseEntity<TeacherDto> findById (@PathVariable Long id){
    Teacher foundTeacher = teacherService.findById(id);
    TeacherDto teacherDto = teacherConverter.toTeacherDto(foundTeacher);
    return ResponseEntity.ok(teacherDto);
   }

   @PutMapping (value = "/{id}")
    public ResponseEntity<TeacherDto> updateTeacher (@RequestBody TeacherDto teacherDto, @PathVariable Long id){
        Teacher foundTeacher = teacherConverter.toTeacher(teacherDto);
        Teacher updateTeacher = teacherService.update(foundTeacher,id);
        TeacherDto responseTeacher = teacherConverter.toTeacherDto(updateTeacher);
        return ResponseEntity.ok(responseTeacher);
   }
}
