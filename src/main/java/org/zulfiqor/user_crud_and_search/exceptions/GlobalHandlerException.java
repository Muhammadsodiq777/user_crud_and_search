package org.zulfiqor.user_crud_and_search.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zulfiqor.user_crud_and_search.dto.response.ErrorModel;
import org.zulfiqor.user_crud_and_search.dto.response.GeneralResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<GeneralResponse> notFound(NotFoundException exception) {
        return exception(GeneralResponse.error(HttpResponseCode.NOT_FOUND.getCode(),
                exception.getMessage() == null ? HttpResponseCode.NOT_FOUND.getMessage() : exception.getMessage()), 404);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<GeneralResponse> badRequestException(BadRequestException exception) {
        return exception(GeneralResponse.error(400, exception.getMessage()), 400);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<GeneralResponse> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ErrorModel> errorModels = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setName(error.getField());
            errorModel.setDetail(error.getDefaultMessage());
            errorModels.add(errorModel);
        });
        return new ResponseEntity<>(GeneralResponse.error(400, "bad_request", errorModels), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<GeneralResponse> exception(Exception exception) {
        exception.printStackTrace();
        return exception(GeneralResponse.error(500, "Error"), 500);
    }

    private ResponseEntity<GeneralResponse> exception(GeneralResponse response, int status) {
        return new ResponseEntity<>(response, HttpStatus.valueOf(status));
    }
}
