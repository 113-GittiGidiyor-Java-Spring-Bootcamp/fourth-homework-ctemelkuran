package dev.patika.patikahw04.exceptions;

public class StudentAgeNotValidException extends RuntimeException{
    public StudentAgeNotValidException(String message) {
        super(message);
    }
}
