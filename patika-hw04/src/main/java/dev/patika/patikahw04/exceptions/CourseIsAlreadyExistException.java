package dev.patika.patikahw04.exceptions;

public class CourseIsAlreadyExistException extends RuntimeException{
    public CourseIsAlreadyExistException(String message) {
        super(message);
    }
}
