package org.communis.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<Map<String, Object>> handle(ServerException ex) {
        HttpStatus status = getStatus(ex);
        Map<String, Object> map = new HashMap<>();
        map.put("status", status.value());
        map.put("message", ex.getMessage());
        map.put("exceptions", ex.getClass().getName());
        map.put("timestamp", LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return ResponseEntity.status(status).body(map);
    }

    private HttpStatus getStatus(ServerException ex) {
        if (ex instanceof AlreadyExistsException || ex instanceof InvalidDataException)
            return HttpStatus.BAD_REQUEST;
        else if (ex instanceof NotFoundException)
            return HttpStatus.NOT_FOUND;
        else
            return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}