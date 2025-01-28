package br.com.guilhermevnbraga.api_cursos.exceptions;

public class CourseAlreadyExistsException extends RuntimeException {
  public CourseAlreadyExistsException(String message) { super(message); }
}
