package br.com.guilhermevnbraga.api_cursos.modules.course.useCases;

import br.com.guilhermevnbraga.api_cursos.modules.course.entities.CourseEntity;
import br.com.guilhermevnbraga.api_cursos.modules.course.repositories.CourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GetCoursesUseCase {
  @Autowired CourseRepository courseRepository;

  public List<CourseEntity> execute(String name, String category) {
    if (name == null && category == null) {
      return courseRepository.findAll();
    }

    return courseRepository.findByNameContainingOrCategoryContaining(name, category);
  }
}
