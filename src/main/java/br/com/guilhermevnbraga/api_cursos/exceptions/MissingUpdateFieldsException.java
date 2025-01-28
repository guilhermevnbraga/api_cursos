package br.com.guilhermevnbraga.api_cursos.exceptions;

public class MissingUpdateFieldsException extends RuntimeException {
  public MissingUpdateFieldsException() {
    super("Missing fields to update");
  }
}
