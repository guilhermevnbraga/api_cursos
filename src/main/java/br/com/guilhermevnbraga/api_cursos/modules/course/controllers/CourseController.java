package br.com.guilhermevnbraga.api_cursos.modules.course.controllers;

import br.com.guilhermevnbraga.api_cursos.modules.course.entities.CourseEntity;
import br.com.guilhermevnbraga.api_cursos.modules.course.useCases.CreateCourseUseCase;
import br.com.guilhermevnbraga.api_cursos.modules.course.useCases.DeleteCourseUseCase;
import br.com.guilhermevnbraga.api_cursos.modules.course.useCases.GetCoursesUseCase;
import br.com.guilhermevnbraga.api_cursos.modules.course.useCases.UpdateActivityUseCase;
import br.com.guilhermevnbraga.api_cursos.modules.course.useCases.UpdateCourseUseCase;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class CourseController {
  @Autowired GetCoursesUseCase getCoursesUseCase;

  @Autowired CreateCourseUseCase createCourseUseCase;

  @Autowired UpdateCourseUseCase updateCourseUseCase;

  @Autowired DeleteCourseUseCase deleteCourseUseCase;

  @Autowired UpdateActivityUseCase updateActivityUseCase;

  @GetMapping("courses")
  public ResponseEntity<List<CourseEntity>>
  getAll(@RequestParam(required = false) String name,
         @RequestParam(required = false) String category) {
    try {
      var result = this.getCoursesUseCase.execute(name, category);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(null);
    }
  }

  @PostMapping("courses")
  public ResponseEntity<Object>
  create(@Valid @RequestBody CourseEntity courseEntity) {
    try {
      var result = this.createCourseUseCase.execute(courseEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PutMapping("courses/{id}")
  public ResponseEntity<Object>
  update(@PathVariable UUID id, @RequestBody CourseEntity courseEntity) {
    try {
      var result = this.updateCourseUseCase.execute(id, courseEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @DeleteMapping("courses/{id}")
  public ResponseEntity<Object> delete(@PathVariable UUID id) {
    try {
      deleteCourseUseCase.execute(id);
      return ResponseEntity.ok().body("Course deleted successfully.");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PatchMapping("courses/{id}/active")
  public ResponseEntity<Object> updateActive(@PathVariable UUID id) {
    try {
      var result = this.updateActivityUseCase.execute(id);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
