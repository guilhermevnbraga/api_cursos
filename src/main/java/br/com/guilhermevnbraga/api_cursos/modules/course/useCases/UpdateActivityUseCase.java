package br.com.guilhermevnbraga.api_cursos.modules.course.useCases;

import br.com.guilhermevnbraga.api_cursos.exceptions.CourseNotFoundException;
import br.com.guilhermevnbraga.api_cursos.modules.course.entities.CourseEntity;
import br.com.guilhermevnbraga.api_cursos.modules.course.repositories.CourseRepository;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UpdateActivityUseCase {
  @Autowired CourseRepository courseRepository;

  public CourseEntity execute(UUID id) {
    var course = courseRepository.findById(id).orElseThrow(
        () -> new CourseNotFoundException());

    CourseEntity.Active active = course.getActive() == CourseEntity.Active.YES ? CourseEntity.Active.NO : CourseEntity.Active.YES;
    course.setActive(active);
    
    return this.courseRepository.save(course);
  }
}
