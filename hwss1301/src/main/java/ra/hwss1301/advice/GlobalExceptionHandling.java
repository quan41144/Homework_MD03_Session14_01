package ra.hwss1301.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.hwss1301.exception.UserExistedException;
import ra.hwss1301.model.dto.response.ApiDataResponse;
import ra.hwss1301.model.entity.User;

@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(UserExistedException.class)
    public ResponseEntity<ApiDataResponse<User>> handleUserExistedException(UserExistedException ex) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                false,
                ex.getMessage(),
                null,
                HttpStatus.BAD_REQUEST
        ), HttpStatus.BAD_REQUEST);
    }
}
