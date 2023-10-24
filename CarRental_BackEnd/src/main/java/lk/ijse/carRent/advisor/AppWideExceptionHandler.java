package lk.ijse.carRent.advisor;

import lk.ijse.carRent.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RuntimeException.class})

    public ResponseUtil handleMyExceptions(RuntimeException e){
        System.out.println(e);
        return new ResponseUtil("Error", e.getMessage(), null);
    }
}
