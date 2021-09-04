package dev.patika.patikahw04.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({StudentAgeNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleException(StudentAgeNotValidException exc){
        ErrorResponse response = prepareErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CourseIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleException(CourseIsAlreadyExistException exc){
        ErrorResponse response = prepareErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InstructorIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleException(InstructorIsAlreadyExistException exc){
        ErrorResponse response = prepareErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({StudentNumberForOneCourseExceededException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleException(StudentNumberForOneCourseExceededException exc){
        ErrorResponse response = prepareErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



    private ErrorResponse prepareErrorResponse(HttpStatus httpStatus, String message) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(httpStatus.value());
        errorResponse.setMessage(message);
        return errorResponse;
    }
}
