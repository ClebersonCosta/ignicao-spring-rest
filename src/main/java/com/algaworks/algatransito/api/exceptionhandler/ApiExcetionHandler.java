package com.algaworks.algatransito.api.exceptionhandler;

import com.algaworks.algatransito.domain.exception.NegocioException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestControllerAdvice
public class ApiExcetionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource ms;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {

        Map<String, String> fields = ex.getBindingResult().getAllErrors().stream()
                            .collect(Collectors.toMap(objectError -> ((FieldError) objectError).getField(),
                                    objectError -> ms.getMessage(objectError, LocaleContextHolder.getLocale())));

        ProblemDetail pd = ProblemDetail.forStatus(status);

        pd.setType(URI.create("https://algaworks.com.br/algatransito/invalid-field"));
        pd.setTitle("Um ou mais campo estão inválidos.");
        pd.setProperty("fields", fields);

        return handleExceptionInternal(ex, pd, headers, status, request);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<String> capturar(NegocioException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
