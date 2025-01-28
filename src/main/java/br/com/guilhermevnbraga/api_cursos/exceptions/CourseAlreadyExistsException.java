package br.com.guilhermevnbraga.api_cursos.exceptions;

public class CourseAlreadyExistsException extends RuntimeException {
  public CourseAlreadyExistsException() { 
    super("Course already exists."); 
  }
}
