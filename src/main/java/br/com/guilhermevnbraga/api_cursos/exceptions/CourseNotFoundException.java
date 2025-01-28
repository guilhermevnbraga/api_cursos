package br.com.guilhermevnbraga.api_cursos.exceptions;

public class CourseNotFoundException extends RuntimeException {
  public CourseNotFoundException() {
    super("Course not found.");
  }
    
}
