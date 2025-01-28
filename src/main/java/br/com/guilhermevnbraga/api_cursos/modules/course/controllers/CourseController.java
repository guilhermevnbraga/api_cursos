package br.com.guilhermevnbraga.api_cursos.modules.course.controllers;

import br.com.guilhermevnbraga.api_cursos.modules.course.entities.CourseEntity;
import br.com.guilhermevnbraga.api_cursos.modules.course.useCases.CreateCourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
  @Autowired CreateCourseUseCase createCourseUseCase;

  @PostMapping("/")
  public ResponseEntity<Object>
  create(@Valid @RequestBody CourseEntity courseEntity) {
    try {
      var result = this.createCourseUseCase.execute(courseEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
