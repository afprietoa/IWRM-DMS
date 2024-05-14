package co.edu.usa.iwrmdms.monitoring_ms.configuration;

import co.edu.usa.iwrmdms.monitoring_ms.domains.exceptions.BadScheduleDeleteIntentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

import static co.edu.usa.iwrmdms.monitoring_ms.configuration.Constants.*;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(BadScheduleDeleteIntentException.class)
    public ResponseEntity<Map<String, String>> handleBadScheduleDeleteIntentException(BadScheduleDeleteIntentException badScheduleDeleteIntentException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, DIFFERENT_RESOURCE_DELETE_ERROR));
    }
}
