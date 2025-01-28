package br.com.guilhermevnbraga.api_cursos.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilhermevnbraga.api_cursos.exceptions.CourseNotFoundException;
import br.com.guilhermevnbraga.api_cursos.modules.course.repositories.CourseRepository;

@Service
public class DeleteCourseUseCase {
    @Autowired CourseRepository courseRepository;

    public void execute(UUID id) {
      if (!courseRepository.existsById(id)) {
        throw new CourseNotFoundException();
      }
      courseRepository.deleteById(id);
    }
}
