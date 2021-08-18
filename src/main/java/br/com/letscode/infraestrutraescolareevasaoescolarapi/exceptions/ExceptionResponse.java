package br.com.letscode.infraestrutraescolareevasaoescolarapi.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {

    private final LocalDateTime timeOccurrence = LocalDateTime.now();
    private String exceptionMessage;

    public ExceptionResponse(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}