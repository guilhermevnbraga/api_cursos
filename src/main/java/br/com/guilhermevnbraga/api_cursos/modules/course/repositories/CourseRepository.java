package br.com.guilhermevnbraga.api_cursos.modules.course.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guilhermevnbraga.api_cursos.modules.course.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    Optional<CourseEntity> findByNameAndCategory(String name, String category);
    List<CourseEntity> findByNameContainingOrCategoryContaining(String name, String category);

    @Override
    Optional<CourseEntity> findById(UUID id);
}
