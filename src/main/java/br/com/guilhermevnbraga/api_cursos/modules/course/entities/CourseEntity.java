package br.com.guilhermevnbraga.api_cursos.modules.course.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.validation.constraints.NotNull;


@Data
@Entity(name = "course")
public class CourseEntity {
  @Id @GeneratedValue(strategy = GenerationType.UUID) private UUID id;

  @NotBlank(message = "Field Name is required") private String name;

  @NotBlank(message = "Field Category is required") private String category;

  public enum Active { YES, NO }

  @NotNull(message = "Field Active is required") private Active active;

  @CreationTimestamp private LocalDateTime createdAt;

  @UpdateTimestamp private LocalDateTime updatedAt;
}
