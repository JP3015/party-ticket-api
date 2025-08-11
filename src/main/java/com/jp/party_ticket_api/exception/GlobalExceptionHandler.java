package com.jp.party_ticket_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IngressosIndisponiveisException.class)
    public ResponseEntity<?> handleIngressosIndisponiveisException(IngressosIndisponiveisException ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", HttpStatus.BAD_REQUEST.value());
        erro.put("erro", ex.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    
    @ExceptionHandler(ExcedeuCapacidadeException.class)
    public ResponseEntity<?> handleExcedeuCapacidadeException(ExcedeuCapacidadeException ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", HttpStatus.BAD_REQUEST.value());
        erro.put("erro", ex.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(nomeUsuarioRepetidoException.class)
    public ResponseEntity<?> handleNomeUsuarioRepetidoException(nomeUsuarioRepetidoException ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", HttpStatus.BAD_REQUEST.value());
        erro.put("erro", ex.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(emailRepetidoException.class)
    public ResponseEntity<?> handleEmailRepetidoException(emailRepetidoException ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", HttpStatus.BAD_REQUEST.value());
        erro.put("erro", ex.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
   
}
