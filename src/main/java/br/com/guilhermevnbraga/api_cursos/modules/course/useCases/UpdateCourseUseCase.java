package br.com.guilhermevnbraga.api_cursos.modules.course.useCases;

import br.com.guilhermevnbraga.api_cursos.exceptions.CourseNotFoundException;
import br.com.guilhermevnbraga.api_cursos.modules.course.entities.CourseEntity;
import br.com.guilhermevnbraga.api_cursos.modules.course.repositories.CourseRepository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilhermevnbraga.api_cursos.exceptions.MissingUpdateFieldsException;

@Service
public class UpdateCourseUseCase {
  @Autowired CourseRepository courseRepository;

  public CourseEntity execute(UUID id, CourseEntity courseEntity) {
    if (courseEntity.getName() == null && courseEntity.getCategory() == null) {
      throw new MissingUpdateFieldsException();
    }

    CourseEntity existingCourse = this.courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException());

    if (courseEntity.getName() != null) {
      existingCourse.setName(courseEntity.getName());
    }
    
    if (courseEntity.getCategory() != null) {
      existingCourse.setCategory(courseEntity.getCategory());
    }

    return this.courseRepository.save(existingCourse);
  }
}
