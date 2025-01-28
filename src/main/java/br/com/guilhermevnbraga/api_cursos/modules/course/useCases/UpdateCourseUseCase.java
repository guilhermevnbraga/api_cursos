package br.com.guilhermevnbraga.api_cursos.modules.course.useCases;

import br.com.guilhermevnbraga.api_cursos.exceptions.CourseNotFoundException;
import br.com.guilhermevnbraga.api_cursos.modules.course.entities.CourseEntity;
import br.com.guilhermevnbraga.api_cursos.modules.course.repositories.CourseRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCourseUseCase {
  @Autowired CourseRepository courseRepository;

  public CourseEntity execute(UUID id, CourseEntity courseEntity) {
    CourseEntity existingCourse = this.courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException());

    existingCourse.setName(courseEntity.getName());
    existingCourse.setCategory(courseEntity.getCategory());
    existingCourse.setActive(courseEntity.getActive());

    return this.courseRepository.save(existingCourse);
  }
}
