package com.exercise.projectschool.controller.impl;

import com.exercise.projectschool.controller.CourseController;
import com.exercise.projectschool.dto.TeacherStudentDTO;
import com.exercise.projectschool.entity.StudentEntity;
import com.exercise.projectschool.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/course")
public class CourseControllerImpl implements CourseController {
    private final CourseService courseService;

    @GetMapping(path = "/studentsbyteacher/{serialNumber}")
    public ResponseEntity<List<StudentEntity>> getStudentsByTeacher(@PathVariable String serialNumber) {
        return courseService.listStudentByTeacher(serialNumber);
    }

    @GetMapping(path = "/studentsandteachersbyschool/{school}")
    public ResponseEntity<TeacherStudentDTO> getTeachersAndStudentsSameSchool(@PathVariable String school) {
        return courseService.getTeachersAndStudentsSameSchool(school);
    }

    @PostMapping(path = "/addstudent/{teachersSerialNumber}")
    public ResponseEntity<Void> addStudentToCourse (@RequestBody StudentEntity student, @PathVariable String teachersSerialNumber) {
        return courseService.addStudentToCourse(student, teachersSerialNumber);
    }

    @GetMapping(path = "/country/italy")
    public String fetchDataItaly () {
        return courseService.fetchDataItaly();
    }

}