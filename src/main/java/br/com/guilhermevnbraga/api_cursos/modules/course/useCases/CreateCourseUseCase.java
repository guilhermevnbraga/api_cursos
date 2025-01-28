package br.com.guilhermevnbraga.api_cursos.modules.course.useCases;

import br.com.guilhermevnbraga.api_cursos.exceptions.CourseAlreadyExistsException;
import br.com.guilhermevnbraga.api_cursos.modules.course.entities.CourseEntity;
import br.com.guilhermevnbraga.api_cursos.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateCourseUseCase {
  @Autowired private CourseRepository courseRepository;

  public CourseEntity execute(CourseEntity courseEntity) {
    this.courseRepository
        .findByNameAndCategory(courseEntity.getName(),
                               courseEntity.getCategory())
        .ifPresent(course -> {
          throw new CourseAlreadyExistsException("Course already exists");
        });
    
    return this.courseRepository.save(courseEntity);
  }
}
